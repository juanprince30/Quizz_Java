import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainInterface extends JFrame {

    private Image backgroundImage;

    public MainInterface() {
        // Chargement de l'image d'arrière-plan
        backgroundImage = new ImageIcon("one.jpg").getImage(); // Remplace par le chemin réel de ton image

        // Configuration de base du JFrame principal
        setTitle("Sélection d'Interface");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création du panneau personnalisé avec l'image en arrière-plan
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 400, 200 , 500, 500, this); // Dessiner l'image à l'échelle
            }
        };
        mainPanel.setLayout(null); // Utilisation d'un layout null pour placer les boutons manuellement

        // Création des boutons avec des marges et positions spécifiques
        JButton btnAdmin = new JButton("Administrateur");
        btnAdmin.setBounds(100, 50, 200, 50); // Position et taille du bouton Administrateur

        JButton btnJoueur = new JButton("Joueur");
        btnJoueur.setBounds(100, 120, 200, 50); // Position et taille du bouton Joueur

        // Action pour le bouton Administrateur
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Créer un administrateur factice et ouvrir l'interface administrateur
                Administrateur admin = new Administrateur("admin", 0, "password");

                ArrayList<Quizz> listQuizz = ramdomQuizz();
                ArrayList<question> questions= new ArrayList<>();
                for(Quizz quizz: listQuizz){
                   for(String key:quizz.listQuestion.keySet()){
                       questions.addAll(quizz.listQuestion.get(key));
                   }
                }
                InterfaceAdministrateur interadmin =new InterfaceAdministrateur(admin); // Ouvrir l'interface administrateur
                interadmin.setQuizzList(listQuizz);
                interadmin.setQuestions(questions);
                dispose(); // Fermer l'interface principale
            }
        });

        // Action pour le bouton Joueur
        btnJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Demander le nom du joueur
                setVisible(false);
                String nomJoueur = JOptionPane.showInputDialog(null, "Entrez votre nom :", "Nom du Joueur", JOptionPane.QUESTION_MESSAGE);

                if (nomJoueur != null && !nomJoueur.trim().isEmpty()) {
                    // Créer une liste de quizz factice pour le test
                    ArrayList<Quizz> listQuizz = ramdomQuizz();
                    // Créer un joueur avec le nom entré
                    Joueur joueur = new Joueur(nomJoueur, 0);
                    // Ouvrir l'interface joueur avec le joueur créé
                    JoueurUI joueurUI = new JoueurUI(joueur, listQuizz);
                    joueurUI.setVisible(true); // Ouvrir l'interface joueur
                    dispose(); // Fermer l'interface principale
                } else {
                    // Si le joueur n'a pas entré de nom, afficher un message d'erreur
                    JOptionPane.showMessageDialog(null, "Le nom du joueur ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ajout des boutons au panneau principal
        mainPanel.add(btnAdmin);
        mainPanel.add(btnJoueur);

        // Ajouter le panneau principal au JFrame
        add(mainPanel);
    }


    public ArrayList<Quizz> ramdomQuizz(){
        Quizz quizz1 = new Quizz();
        Quizz quizz2 = new Quizz();
        Quizz quizz3 = new Quizz();
        Quizz quizz4 = new Quizz();
        Quizz quizz5 = new Quizz();
        ArrayList<Quizz> allquizz= new ArrayList<Quizz>();

        // Création des questions pour chaque quizz
        ArrayList<question> questionsQuizz1 = new ArrayList<>();
        questionsQuizz1.add(new question("Quelle est la capitale de la France ?", "Paris", "Berlin", "Rome", "Madrid", "A", 5, "Facile"));
        questionsQuizz1.add(new question("Quelle est la racine carrée de 16 ?", "2", "4", "6", "8", "B", 5, "Facile"));
        questionsQuizz1.add(new question("Qui a peint la Joconde ?", "Van Gogh", "Picasso", "Léonard de Vinci", "Rembrandt", "C", 10, "Moyenne"));
        questionsQuizz1.add(new question("Quelle est la plus grande planète du système solaire ?", "Terre", "Mars", "Jupiter", "Saturne", "C", 10, "Moyenne"));
        questionsQuizz1.add(new question("Combien d'os dans le corps humain ?", "206", "208", "204", "200", "A", 10, "Difficile"));

        ArrayList<question> questionsQuizz2 = new ArrayList<>();
        questionsQuizz2.add(new question("Quelle est la capitale du Japon ?", "Tokyo", "Pékin", "Séoul", "Bangkok", "A", 5, "Facile"));
        questionsQuizz2.add(new question("Qui est le fondateur de Microsoft ?", "Steve Jobs", "Bill Gates", "Elon Musk", "Mark Zuckerberg", "B", 5, "Facile"));
        questionsQuizz2.add(new question("En quelle année l'Homme a-t-il marché sur la Lune ?", "1969", "1970", "1965", "1972", "A", 10, "Moyenne"));
        questionsQuizz2.add(new question("Combien de continents sur Terre ?", "5", "6", "7", "8", "C", 5, "Facile"));
        questionsQuizz2.add(new question("Qui a écrit 'Les Misérables' ?", "Victor Hugo", "Balzac", "Flaubert", "Zola", "A", 10, "Difficile"));

        ArrayList<question> questionsQuizz3 = new ArrayList<>();
        questionsQuizz3.add(new question("Quelle est la formule chimique de l'eau ?", "H2O", "CO2", "O2", "N2", "A", 5, "Facile"));
        questionsQuizz3.add(new question("Combien d'heures dans une journée ?", "12", "24", "48", "60", "B", 5, "Facile"));
        questionsQuizz3.add(new question("Qui est le créateur de Facebook ?", "Steve Jobs", "Bill Gates", "Elon Musk", "Mark Zuckerberg", "D", 10, "Moyenne"));
        questionsQuizz3.add(new question("Quelle est la vitesse de la lumière ?", "299 792 km/s", "100 000 km/s", "1 000 000 km/s", "299 000 km/s", "A", 10, "Difficile"));
        questionsQuizz3.add(new question("Quelle est la capitale du Canada ?", "Toronto", "Ottawa", "Vancouver", "Montréal", "B", 5, "Facile"));

        ArrayList<question> questionsQuizz4 = new ArrayList<>();
        questionsQuizz4.add(new question("Quel est le symbole chimique de l'or ?", "Au", "Ag", "Fe", "Hg", "A", 10, "Moyenne"));
        questionsQuizz4.add(new question("Combien de côtés a un hexagone ?", "5", "6", "7", "8", "B", 5, "Facile"));
        questionsQuizz4.add(new question("Quelle est la capitale de l'Espagne ?", "Lisbonne", "Madrid", "Barcelone", "Séville", "B", 5, "Facile"));
        questionsQuizz4.add(new question("Qui a écrit 'La Métamorphose' ?", "Kafka", "Camus", "Sartre", "Proust", "A", 10, "Difficile"));
        questionsQuizz4.add(new question("Quelle est la température de fusion du fer ?", "1538°C", "1084°C", "500°C", "1000°C", "A", 15, "Difficile"));

        ArrayList<question> questionsQuizz5 = new ArrayList<>();
        questionsQuizz5.add(new question("Quel est le plus grand désert du monde ?", "Sahara", "Antarctique", "Gobi", "Kalahari", "B", 10, "Moyenne"));
        questionsQuizz5.add(new question("Quelle est la formule chimique du sel ?", "NaCl", "H2O", "CO2", "O2", "A", 5, "Facile"));
        questionsQuizz5.add(new question("En quelle année la Seconde Guerre mondiale a-t-elle commencé ?", "1939", "1914", "1941", "1945", "A", 10, "Difficile"));
        questionsQuizz5.add(new question("Qui a découvert la théorie de la relativité ?", "Isaac Newton", "Galilée", "Albert Einstein", "Niels Bohr", "C", 15, "Difficile"));
        questionsQuizz5.add(new question("Combien de cordes une guitare classique possède-t-elle ?", "5", "6", "7", "8", "B", 5, "Facile"));

        // Ajouter les questions à chaque quizz
        quizz1.ajouterQuestion("Culture Générale", questionsQuizz1);
        quizz2.ajouterQuestion("Histoire et Sciences", questionsQuizz2);
        quizz3.ajouterQuestion("Technologie", questionsQuizz3);
        quizz4.ajouterQuestion("Chimie et Littérature", questionsQuizz4);
        quizz5.ajouterQuestion("Géographie et Sciences", questionsQuizz5);

        // Afficher les quizz
        allquizz.add(quizz1);
        allquizz.add(quizz2);
        allquizz.add(quizz3);
        allquizz.add(quizz4);
        allquizz.add(quizz5);

        return allquizz;

    }

}
