import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceAdministrateur {

    private JFrame frame;
    private Administrateur administrateur;
    private ArrayList<question> questions;
    private ArrayList<Quizz> quizzList;

    public void setQuestions(ArrayList<question> questions){
        this.questions=questions;
    }

    public void setQuizzList(ArrayList<Quizz> quizzList) {
        this.quizzList = quizzList;
    }

    public InterfaceAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
        this.questions = new ArrayList<>();
        this.quizzList = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Interface Administrateur");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new GridLayout(6, 1));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JButton btnAjouterQuestion = new JButton("Ajouter une Question");
        JButton btnModifierQuestion = new JButton("Modifier une Question");
        JButton btnSupprimerQuestion = new JButton("Supprimer une Question");
        JButton btnAjouterQuizz = new JButton("Ajouter un Quizz");
        JButton btnModifierQuizz = new JButton("Modifier un Quizz");
        JButton btnSupprimerQuizz = new JButton("Supprimer un Quizz");

        // Ajuster la taille des boutons
        Dimension buttonSize = new Dimension(150, 50); // Largeur 150px, Hauteur 40px
        btnAjouterQuestion.setPreferredSize(buttonSize);
        btnModifierQuestion.setPreferredSize(buttonSize);
        btnSupprimerQuestion.setPreferredSize(buttonSize);
        btnAjouterQuizz.setPreferredSize(buttonSize);
        btnModifierQuizz.setPreferredSize(buttonSize);
        btnSupprimerQuizz.setPreferredSize(buttonSize);

        // Action pour ajouter une question
        btnAjouterQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ajouterQuestionFrame = new JFrame("Ajouter une Question");
                ajouterQuestionFrame.setSize(800, 500);
                ajouterQuestionFrame.setLayout(new GridLayout(10, 1));

                JTextField txtQuestion = new JTextField();
                JTextField txtReponseA = new JTextField();
                JTextField txtReponseB = new JTextField();
                JTextField txtReponseC = new JTextField();
                JTextField txtReponseD = new JTextField();
                JTextField txtReponseCorrect = new JTextField();
                JTextField txtPoints = new JTextField();
                JTextField txtDifficulte = new JTextField();

                JButton btnSaveQuestion = new JButton("Enregistrer");

                ajouterQuestionFrame.add(new JLabel("Question:"));
                ajouterQuestionFrame.add(txtQuestion);
                ajouterQuestionFrame.add(new JLabel("Réponse A:"));
                ajouterQuestionFrame.add(txtReponseA);
                ajouterQuestionFrame.add(new JLabel("Réponse B:"));
                ajouterQuestionFrame.add(txtReponseB);
                ajouterQuestionFrame.add(new JLabel("Réponse C:"));
                ajouterQuestionFrame.add(txtReponseC);
                ajouterQuestionFrame.add(new JLabel("Réponse D:"));
                ajouterQuestionFrame.add(txtReponseD);
                ajouterQuestionFrame.add(new JLabel("Réponse Correcte (A/B/C/D):"));
                ajouterQuestionFrame.add(txtReponseCorrect);
                ajouterQuestionFrame.add(new JLabel("Points:"));
                ajouterQuestionFrame.add(txtPoints);
                ajouterQuestionFrame.add(new JLabel("Difficulté (Facile/Difficile/Normale):"));
                ajouterQuestionFrame.add(txtDifficulte);
                ajouterQuestionFrame.add(btnSaveQuestion);

                btnSaveQuestion.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Récupérer les données et ajouter la question
                        String questionText = txtQuestion.getText();
                        String reponseA = txtReponseA.getText();
                        String reponseB = txtReponseB.getText();
                        String reponseC = txtReponseC.getText();
                        String reponseD = txtReponseD.getText();
                        String reponseCorrect = txtReponseCorrect.getText();
                        int points = Integer.parseInt(txtPoints.getText());
                        String difficulte = txtDifficulte.getText();

                        // Ajouter la question à la liste
                        question newQuestion = new question(questionText, reponseA, reponseB, reponseC, reponseD, reponseCorrect, points, difficulte);
                        questions.add(newQuestion);
                        JOptionPane.showMessageDialog(ajouterQuestionFrame, "Question ajoutée avec succès!");
                        ajouterQuestionFrame.dispose(); // Fermer la fenêtre
                    }
                });

                ajouterQuestionFrame.setVisible(true);
            }
        });

        // Action pour modifier une question
        btnModifierQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame modifierQuestionFrame = new JFrame("Modifier une Question");
                modifierQuestionFrame.setSize(800, 500);
                modifierQuestionFrame.setLayout(new GridLayout(10, 1));

                JComboBox<question> questionComboBox = new JComboBox<>(questions.toArray(new question[0]));
                JTextField txtQuestion = new JTextField();
                JTextField txtReponseA = new JTextField();
                JTextField txtReponseB = new JTextField();
                JTextField txtReponseC = new JTextField();
                JTextField txtReponseD = new JTextField();
                JTextField txtReponseCorrect = new JTextField();
                JTextField txtPoints = new JTextField();
                JTextField txtDifficulte = new JTextField();

                JButton btnSaveModification = new JButton("Enregistrer les modifications");

                modifierQuestionFrame.add(new JLabel("Sélectionnez une Question:"));
                modifierQuestionFrame.add(questionComboBox);
                modifierQuestionFrame.add(new JLabel("Question:"));
                modifierQuestionFrame.add(txtQuestion);
                modifierQuestionFrame.add(new JLabel("Réponse A:"));
                modifierQuestionFrame.add(txtReponseA);
                modifierQuestionFrame.add(new JLabel("Réponse B:"));
                modifierQuestionFrame.add(txtReponseB);
                modifierQuestionFrame.add(new JLabel("Réponse C:"));
                modifierQuestionFrame.add(txtReponseC);
                modifierQuestionFrame.add(new JLabel("Réponse D:"));
                modifierQuestionFrame.add(txtReponseD);
                modifierQuestionFrame.add(new JLabel("Réponse Correcte (A/B/C/D):"));
                modifierQuestionFrame.add(txtReponseCorrect);
                modifierQuestionFrame.add(new JLabel("Points:"));
                modifierQuestionFrame.add(txtPoints);
                modifierQuestionFrame.add(new JLabel("Difficulté (Facile/Difficile/Normale):"));
                modifierQuestionFrame.add(txtDifficulte);
                modifierQuestionFrame.add(btnSaveModification);

                // Remplir les champs lorsque la question est sélectionnée
                questionComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        question selectedQuestion = (question) questionComboBox.getSelectedItem();
                        if (selectedQuestion != null) {
                            txtQuestion.setText(selectedQuestion.Question);
                            txtReponseA.setText(selectedQuestion.OptionReponse.get("A"));
                            txtReponseB.setText(selectedQuestion.OptionReponse.get("B"));
                            txtReponseC.setText(selectedQuestion.OptionReponse.get("C"));
                            txtReponseD.setText(selectedQuestion.OptionReponse.get("D"));
                            txtReponseCorrect.setText(selectedQuestion.ReponseCorrect);
                            txtPoints.setText(String.valueOf(selectedQuestion.PointReponse));
                            txtDifficulte.setText(selectedQuestion.DifficulteQuestion);
                        }
                    }
                });

                btnSaveModification.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Mettre à jour les données de la question sélectionnée
                        question selectedQuestion = (question) questionComboBox.getSelectedItem();
                        if (selectedQuestion != null) {
                            selectedQuestion.Question=txtQuestion.getText();
                            selectedQuestion.OptionReponse.put("A", txtReponseA.getText());
                            selectedQuestion.OptionReponse.put("B", txtReponseB.getText());
                            selectedQuestion.OptionReponse.put("C" ,txtReponseC.getText());
                            selectedQuestion.OptionReponse.put("D", txtReponseD.getText());
                            selectedQuestion.ReponseCorrect=txtReponseCorrect.getText();
                            selectedQuestion.PointReponse=Integer.parseInt(txtPoints.getText());
                            selectedQuestion.DifficulteQuestion=txtDifficulte.getText();
                            JOptionPane.showMessageDialog(modifierQuestionFrame, "Question modifiée avec succès!");
                            modifierQuestionFrame.dispose();
                        }
                    }
                });

                modifierQuestionFrame.setVisible(true);
            }
        });

        // Action pour supprimer une question
        btnSupprimerQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame supprimerQuestionFrame = new JFrame("Supprimer une Question");
                supprimerQuestionFrame.setSize(800, 500);
                supprimerQuestionFrame.setLayout(new GridLayout(2, 1));

                JComboBox<question> questionComboBox = new JComboBox<>(questions.toArray(new question[0]));
                JButton btnSupprimer = new JButton("Supprimer");

                supprimerQuestionFrame.add(new JLabel("Sélectionnez une Question à supprimer:"));
                supprimerQuestionFrame.add(questionComboBox);
                supprimerQuestionFrame.add(btnSupprimer);

                btnSupprimer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        question selectedQuestion = (question) questionComboBox.getSelectedItem();
                        if (selectedQuestion != null) {
                            questions.remove(selectedQuestion);
                            JOptionPane.showMessageDialog(supprimerQuestionFrame, "Question supprimée avec succès!");
                            supprimerQuestionFrame.dispose();
                        }
                    }
                });

                supprimerQuestionFrame.setVisible(true);
            }
        });

        // Action pour ajouter un quizz
        // Action pour ajouter un quizz
        btnAjouterQuizz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ajouterQuizzFrame = new JFrame("Ajouter un Quizz");
                ajouterQuizzFrame.setSize(800, 500);
                ajouterQuizzFrame.setLayout(new GridLayout(3, 1));

                JTextField txtTitreQuizz = new JTextField();
                JButton btnSaveQuizz = new JButton("Enregistrer le Quizz");

                ajouterQuizzFrame.add(new JLabel("Titre du Quizz:"));
                ajouterQuizzFrame.add(txtTitreQuizz);
                ajouterQuizzFrame.add(btnSaveQuizz);

                btnSaveQuizz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Ajouter le quizz à la liste
                        String titre = txtTitreQuizz.getText();
                        Quizz newQuizz = new Quizz();
                        newQuizz.listQuestion.put(titre, new ArrayList<>());

                        // Ajouter au minimum trois questions
                        JFrame ajouterQuestionsFrame = new JFrame("Ajouter des Questions");
                        ajouterQuestionsFrame.setSize(800, 400); // Taille élargie pour trois colonnes
                        ajouterQuestionsFrame.setLayout(new GridLayout(0, 8)); // 0 lignes, 8 colonnes

                        // Créer les champs de texte pour chaque question
                        JTextField[] txtQuestions = new JTextField[3];
                        JTextField[] txtReponsesA = new JTextField[3];
                        JTextField[] txtReponsesB = new JTextField[3];
                        JTextField[] txtReponsesC = new JTextField[3];
                        JTextField[] txtReponsesD = new JTextField[3];
                        JTextField[] txtReponsesCorrectes = new JTextField[3];
                        JTextField[] txtPoints = new JTextField[3];
                        JTextField[] txtDifficultes = new JTextField[3];

                        // Remplir les tableaux et ajouter au frame
                        for (int i = 0; i < 3; i++) {
                            txtQuestions[i] = new JTextField();
                            txtReponsesA[i] = new JTextField();
                            txtReponsesB[i] = new JTextField();
                            txtReponsesC[i] = new JTextField();
                            txtReponsesD[i] = new JTextField();
                            txtReponsesCorrectes[i] = new JTextField();
                            txtPoints[i] = new JTextField();
                            txtDifficultes[i] = new JTextField();

                            // Ajouter les composants dans l'ordre demandé
                            ajouterQuestionsFrame.add(new JLabel("Question " + (i + 1) + ":"));
                            ajouterQuestionsFrame.add(txtQuestions[i]);
                            ajouterQuestionsFrame.add(new JLabel("Réponse A:"));
                            ajouterQuestionsFrame.add(txtReponsesA[i]);
                            ajouterQuestionsFrame.add(new JLabel("Réponse B:"));
                            ajouterQuestionsFrame.add(txtReponsesB[i]);
                            ajouterQuestionsFrame.add(new JLabel("Réponse C:"));
                            ajouterQuestionsFrame.add(txtReponsesC[i]);
                            ajouterQuestionsFrame.add(new JLabel("Réponse D:"));
                            ajouterQuestionsFrame.add(txtReponsesD[i]);
                            ajouterQuestionsFrame.add(new JLabel("Réponse Correcte (A/B/C/D):"));
                            ajouterQuestionsFrame.add(txtReponsesCorrectes[i]);
                            ajouterQuestionsFrame.add(new JLabel("Points:"));
                            ajouterQuestionsFrame.add(txtPoints[i]);
                            ajouterQuestionsFrame.add(new JLabel("Difficulté (Facile/Difficile/Normale):"));
                            ajouterQuestionsFrame.add(txtDifficultes[i]);
                        }

                        JButton btnSaveQuestions = new JButton("Enregistrer les Questions");
                        ajouterQuestionsFrame.add(btnSaveQuestions); // Ajouter le bouton à la fin

                        btnSaveQuestions.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Ajouter les questions au quizz
                                for (int i = 0; i < 3; i++) {
                                    question newQuestion = new question(
                                            txtQuestions[i].getText(),
                                            txtReponsesA[i].getText(),
                                            txtReponsesB[i].getText(),
                                            txtReponsesC[i].getText(),
                                            txtReponsesD[i].getText(),
                                            txtReponsesCorrectes[i].getText(),
                                            Integer.parseInt(txtPoints[i].getText()),
                                            txtDifficultes[i].getText()
                                    );
                                    newQuizz.listQuestion.get(titre).add(newQuestion);
                                }

                                quizzList.add(newQuizz);
                                JOptionPane.showMessageDialog(ajouterQuestionsFrame, "Quizz ajouté avec succès!");
                                ajouterQuestionsFrame.dispose(); // Fermer la fenêtre
                            }
                        });

                        ajouterQuestionsFrame.setVisible(true);
                    }
                });

                ajouterQuizzFrame.setVisible(true);
            }
        });



        // Action pour modifier un quizz
        // Action pour modifier un quizz
        btnModifierQuizz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame modifierQuizzFrame = new JFrame("Modifier un Quizz");
                modifierQuizzFrame.setSize(800, 500);
                modifierQuizzFrame.setLayout(new GridLayout(3, 1));

                JComboBox<Quizz> quizzComboBox = new JComboBox<>(quizzList.toArray(new Quizz[0]));
                JTextField txtTitreQuizz = new JTextField();
                JButton btnSaveModification = new JButton("Enregistrer les modifications");

                modifierQuizzFrame.add(new JLabel("Sélectionnez un Quizz:"));
                modifierQuizzFrame.add(quizzComboBox);
                modifierQuizzFrame.add(new JLabel("Nouveau Titre:"));
                modifierQuizzFrame.add(txtTitreQuizz);
                modifierQuizzFrame.add(btnSaveModification);

                // Remplir le champ lorsque le quizz est sélectionné
                quizzComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Quizz selectedQuizz = (Quizz) quizzComboBox.getSelectedItem();
                        if (selectedQuizz != null) {
                            txtTitreQuizz.setText(selectedQuizz.listQuestion.keySet().iterator().next());
                        }
                    }
                });

                btnSaveModification.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Mettre à jour le titre du quizz sélectionné
                        Quizz selectedQuizz = (Quizz) quizzComboBox.getSelectedItem();
                        if (selectedQuizz != null) {
                            String oldTheme = selectedQuizz.listQuestion.keySet().iterator().next();
                            ArrayList<question> questions = selectedQuizz.listQuestion.remove(oldTheme);

                            if (questions == null) {
                                System.out.println("Le thème sélectionné ne contient pas de questions.");
                                return;
                            }

                            // Remplacer l'ancien thème par le nouveau
                            selectedQuizz.listQuestion.put(txtTitreQuizz.getText(), questions);
                            JOptionPane.showMessageDialog(modifierQuizzFrame, "Quizz modifié avec succès!");
                            modifierQuizzFrame.dispose();
                        }
                    }
                });

                modifierQuizzFrame.setVisible(true);
            }
        });

        // Action pour supprimer un quizz
        btnSupprimerQuizz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame supprimerQuizzFrame = new JFrame("Supprimer un Quizz");
                supprimerQuizzFrame.setSize(800, 500);
                supprimerQuizzFrame.setLayout(new GridLayout(2, 1));

                JComboBox<Quizz> quizzComboBox = new JComboBox<>(quizzList.toArray(new Quizz[0]));
                JButton btnSupprimer = new JButton("Supprimer");

                supprimerQuizzFrame.add(new JLabel("Sélectionnez un Quizz à supprimer:"));
                supprimerQuizzFrame.add(quizzComboBox);
                supprimerQuizzFrame.add(btnSupprimer);

                btnSupprimer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Quizz selectedQuizz = (Quizz) quizzComboBox.getSelectedItem();
                        if (selectedQuizz != null) {
                            quizzList.remove(selectedQuizz);
                            JOptionPane.showMessageDialog(supprimerQuizzFrame, "Quizz supprimé avec succès!");
                            supprimerQuizzFrame.dispose();
                        }
                    }
                });

                supprimerQuizzFrame.setVisible(true);
            }
        });

        frame.add(btnAjouterQuestion);
        frame.add(btnModifierQuestion);
        frame.add(btnSupprimerQuestion);
        frame.add(btnAjouterQuizz);
        frame.add(btnModifierQuizz);
        frame.add(btnSupprimerQuizz);

        // Ajouter le panel de boutons au frame
        frame.add(buttonPanel, BorderLayout.NORTH); // Ajouter le panel en haut

        frame.setVisible(true);
    }

}
