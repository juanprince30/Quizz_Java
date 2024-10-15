import java.util.ArrayList;
import java.util.Scanner;

public class Joueur extends Utilisateur{

    public Joueur(String nom, int scoreTotal) {
        super(nom, scoreTotal);
    }

    public void passerQuizz(ArrayList<Quizz> listeQuizz) {
        Scanner sc = new Scanner(System.in);

        // Afficher tous les thèmes disponibles
        System.out.println("Voici les thèmes disponibles:");
        for (int i = 0; i < listeQuizz.size(); i++) {
            Quizz quizz = listeQuizz.get(i);
            System.out.println((i + 1) + ": " + quizz.listQuestion.keySet());
        }

        // Choisir le quizz auquel participer en fonction du thème
        System.out.println("Entrez le numéro du Quizz auquel vous voulez participer:");
        int choixQuizz = sc.nextInt();
        sc.nextLine(); // Vider le buffer

        if (choixQuizz < 1 || choixQuizz > listeQuizz.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        // Récupérer le quizz sélectionné
        Quizz quizzChoisi = listeQuizz.get(choixQuizz - 1);

        // Récupérer le thème
        String theme = quizzChoisi.listQuestion.keySet().iterator().next();
        System.out.println("Vous participez au Quizz sur le thème : " + theme);

        // Récupérer la liste des questions
        ArrayList<question> quests = quizzChoisi.listQuestion.get(theme);
        int scoreTotal = 0; // Pour garder une trace du score du participant

        for (question quest : quests) {
            System.out.println("La Question est de niveau " + quest.DifficulteQuestion + " et compte pour " + quest.PointReponse + " points");
            System.out.println(quest.Question);
            System.out.println("A: " + quest.OptionReponse.get("A"));
            System.out.println("B: " + quest.OptionReponse.get("B"));
            System.out.println("C: " + quest.OptionReponse.get("C"));
            System.out.println("D: " + quest.OptionReponse.get("D"));

            // Récupérer la réponse de l'utilisateur
            String reponse = "";
            while (!reponse.matches("[A-D]")) {
                System.out.println("Entrez votre réponse (A, B, C, ou D) :");
                reponse = sc.nextLine().toUpperCase();
            }

            // Vérifier si la réponse est correcte
            if (reponse.equals(quest.ReponseCorrect)) {
                System.out.println("Bonne réponse !");
                scoreTotal += quest.PointReponse;
            } else {
                System.out.println("Mauvaise réponse. La bonne réponse était " + quest.ReponseCorrect);
            }

            System.out.println(); // Saut de ligne pour séparer les questions
        }

        // Afficher le score final
        System.out.println("Vous avez terminé le Quizz.");
        System.out.println("Votre score final est : " + scoreTotal + " points.");

        // Enregistrer le score si nécessaire (si l'utilisateur est lié à un score global, par exemple)
        this.scoreTotal=this.scoreTotal + scoreTotal;
    }

}
