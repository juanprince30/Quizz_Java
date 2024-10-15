import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuizApp extends JFrame {

    private ArrayList<question> questions;
    private ArrayList<Quizz> quizzList;
    private JPanel mainPanel;

    public QuizApp() {
        questions = new ArrayList<>();
        quizzList = new ArrayList<>();
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        setTitle("Application de Quiz");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Créer le menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem ajouterQuestionItem = new JMenuItem("Ajouter Question");
        ajouterQuestionItem.addActionListener(e -> showAddQuestionPanel());
        menu.add(ajouterQuestionItem);

        JMenuItem ajouterQuizzItem = new JMenuItem("Ajouter Quizz");
        ajouterQuizzItem.addActionListener(e -> showAddQuizzPanel());
        menu.add(ajouterQuizzItem);

        JMenuItem afficherQuizzItem = new JMenuItem("Afficher Quizz");
        afficherQuizzItem.addActionListener(e -> showDisplayQuizzPanel());
        menu.add(afficherQuizzItem);

        JMenuItem quitterItem = new JMenuItem("Quitter");
        quitterItem.addActionListener(e -> System.exit(0));
        menu.add(quitterItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Ajouter les panels
        mainPanel.add(createAddQuestionPanel(), "AddQuestionPanel");
        mainPanel.add(createAddQuizzPanel(), "AddQuizzPanel");
        mainPanel.add(createDisplayQuizzPanel(), "DisplayQuizzPanel");

        add(mainPanel);
    }

    private void showAddQuestionPanel() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "AddQuestionPanel");
    }

    private void showAddQuizzPanel() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "AddQuizzPanel");
    }

    private void showDisplayQuizzPanel() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "DisplayQuizzPanel");
    }

    private JPanel createAddQuestionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JTextField questionField = new JTextField();
        JTextField answerAField = new JTextField();
        JTextField answerBField = new JTextField();
        JTextField answerCField = new JTextField();
        JTextField answerDField = new JTextField();
        JTextField correctAnswerField = new JTextField();
        JTextField pointsField = new JTextField();
        JTextField levelField = new JTextField();

        JButton addButton = new JButton("Ajouter Question");
        addButton.addActionListener(e -> {
            String questionText = questionField.getText();
            String answerA = answerAField.getText();
            String answerB = answerBField.getText();
            String answerC = answerCField.getText();
            String answerD = answerDField.getText();
            String correctAnswer = correctAnswerField.getText();
            int points = Integer.parseInt(pointsField.getText());
            String level = levelField.getText();

            question newQuestion = new question(questionText, answerA, answerB, answerC, answerD, correctAnswer, points, level);
            questions.add(newQuestion);
            JOptionPane.showMessageDialog(this, "Question ajoutée !");
        });

        panel.add(new JLabel("Question :"));
        panel.add(questionField);
        panel.add(new JLabel("Réponse A :"));
        panel.add(answerAField);
        panel.add(new JLabel("Réponse B :"));
        panel.add(answerBField);
        panel.add(new JLabel("Réponse C :"));
        panel.add(answerCField);
        panel.add(new JLabel("Réponse D :"));
        panel.add(answerDField);
        panel.add(new JLabel("Réponse Correcte :"));
        panel.add(correctAnswerField);
        panel.add(new JLabel("Points :"));
        panel.add(pointsField);
        panel.add(new JLabel("Niveau :"));
        panel.add(levelField);
        panel.add(addButton);

        return panel;
    }

    private JPanel createAddQuizzPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField themeField = new JTextField();
        JTextArea questionsArea = new JTextArea();
        JButton addQuizzButton = new JButton("Ajouter Quizz");

        addQuizzButton.addActionListener(e -> {
            String theme = themeField.getText();
            ArrayList<question> selectedQuestions = new ArrayList<>(questions); // Ajoutez ici des questions spécifiques si nécessaire
            Quizz newQuizz = new Quizz();
            newQuizz.ajouterQuestion(theme, selectedQuestions);
            quizzList.add(newQuizz);
            JOptionPane.showMessageDialog(this, "Quizz ajouté !");
        });

        panel.add(new JLabel("Thème :"), BorderLayout.NORTH);
        panel.add(themeField, BorderLayout.CENTER);
        panel.add(questionsArea, BorderLayout.SOUTH);
        panel.add(addQuizzButton, BorderLayout.EAST);

        return panel;
    }

    private JPanel createDisplayQuizzPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea displayArea = new JTextArea();
        for (Quizz quizz : quizzList) {
            for(String key: quizz.listQuestion.keySet())
            {
                displayArea.append("Thème: " + key + "\n");
                displayArea.append("Questions:\n");
                for (question quest : quizz.listQuestion.get(key)) {
                    displayArea.append(quest.Question + "\n");
                }
                displayArea.append("\n");
            }
        }
        displayArea.setEditable(false);

        panel.add(new JLabel("Quizz Disponibles :"), BorderLayout.NORTH);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        return panel;
    }


}