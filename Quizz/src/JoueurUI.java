import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class JoueurUI extends JFrame {

    private Joueur joueur;
    private ArrayList<Quizz> listeQuizz;
    private JComboBox<String> quizzComboBox;
    private JPanel questionPanel;
    private JLabel questionLabel;
    private JRadioButton optionA, optionB, optionC, optionD;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private int currentQuestionIndex;
    private int score;
    private ArrayList<question> currentQuestions;

    public JoueurUI(Joueur joueur, ArrayList<Quizz> listeQuizz) {
        this.joueur = joueur;
        this.listeQuizz = listeQuizz;
        this.currentQuestionIndex = 0;
        this.score = 0;

        // Configurer la fenêtre principale
        setTitle("Interface Joueur - Quiz");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau de sélection du quiz
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));

        JLabel selectQuizzLabel = new JLabel("Sélectionnez un quiz:");
        topPanel.add(selectQuizzLabel);

        quizzComboBox = new JComboBox<>();
        for (Quizz quizz : listeQuizz) {
            String theme = quizz.listQuestion.keySet().iterator().next();
            quizzComboBox.addItem(theme);
        }
        topPanel.add(quizzComboBox);

        JButton startQuizButton = new JButton("Commencer le quiz");
        startQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startQuiz();
            }
        });
        topPanel.add(startQuizButton);

        add(topPanel, BorderLayout.NORTH);

        // Panneau pour les questions et réponses
        questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(6, 1));
        questionLabel = new JLabel("Question:");
        questionPanel.add(questionLabel);

        optionA = new JRadioButton("A");
        optionB = new JRadioButton("B");
        optionC = new JRadioButton("C");
        optionD = new JRadioButton("D");

        optionGroup = new ButtonGroup();
        optionGroup.add(optionA);
        optionGroup.add(optionB);
        optionGroup.add(optionC);
        optionGroup.add(optionD);

        questionPanel.add(optionA);
        questionPanel.add(optionB);
        questionPanel.add(optionC);
        questionPanel.add(optionD);

        nextButton = new JButton("Question Suivante");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
            }
        });
        questionPanel.add(nextButton);
        questionPanel.setVisible(false);

        add(questionPanel, BorderLayout.CENTER);
    }

    private void startQuiz() {
        // Récupérer le quiz sélectionné
        String selectedTheme = (String) quizzComboBox.getSelectedItem();
        for (Quizz quizz : listeQuizz) {
            String theme = quizz.listQuestion.keySet().iterator().next();
            if (theme.equals(selectedTheme)) {
                currentQuestions = quizz.listQuestion.get(theme);
                break;
            }
        }
        currentQuestionIndex = 0;
        score = 0;
        questionPanel.setVisible(true);
        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            question currentQuestion = currentQuestions.get(currentQuestionIndex);

            questionLabel.setText("Question: " + currentQuestion.Question);
            optionA.setText("A: " + currentQuestion.OptionReponse.get("A"));
            optionB.setText("B: " + currentQuestion.OptionReponse.get("B"));
            optionC.setText("C: " + currentQuestion.OptionReponse.get("C"));
            optionD.setText("D: " + currentQuestion.OptionReponse.get("D"));

            optionGroup.clearSelection();
        } else {
            endQuiz();
        }
    }

    private void nextQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            question currentQuestion = currentQuestions.get(currentQuestionIndex);
            String selectedAnswer = null;

            if (optionA.isSelected()) {
                selectedAnswer = "A";
            } else if (optionB.isSelected()) {
                selectedAnswer = "B";
            } else if (optionC.isSelected()) {
                selectedAnswer = "C";
            } else if (optionD.isSelected()) {
                selectedAnswer = "D";
            }

            // Vérifier la réponse
            if (selectedAnswer != null && selectedAnswer.equals(currentQuestion.ReponseCorrect)) {
                score += currentQuestion.PointReponse;
            }

            currentQuestionIndex++;
            displayQuestion();
        }
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz terminé !\nVotre score est : " + score);
        joueur.scoreTotal=joueur.scoreTotal + score;
        questionPanel.setVisible(false);
    }
}
