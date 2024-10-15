import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrateur extends Utilisateur {

    private String motDePasse;

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Administrateur(String nom, int scoreTotal, String motDePasse) {
        super(nom, scoreTotal);
        this.motDePasse=motDePasse;
    }


    public question ajouterQuestion() {
        System.out.println("Bonjour vous voulez creer une nouvelle question");
        Scanner sc= new Scanner(System.in);


        String quest="";
        while (quest.isEmpty()) {
            System.out.println("Entrer Votre question");
            quest = sc.nextLine();
        }

        String rA= "";
        while (rA.isEmpty()) {
            System.out.println("Entrer la reponse A");
            rA = sc.nextLine();
        }

        String rB= "";
        while (rB.isEmpty()) {
            System.out.println("Entrer la reponse B");
            rB = sc.nextLine();
        }

        String rC= "";
        while (rC.isEmpty()) {
            System.out.println("Entrer la reponse C");
            rC = sc.nextLine();
        }

        String rD= "";
        while (rD.isEmpty()) {
            System.out.println("Entrer la reponse D");
            rD = sc.nextLine();
        }

        String rCorrect= "";
        while (!rCorrect.matches("[A-D]"))
        {
            System.out.println("Entrer la reponse correcte");
            rCorrect= sc.nextLine();
        }

        boolean pointValide=false;
        int pointR=0;
        while(!pointValide) {
            try{
                System.out.println("Entrer le point de la question");
                pointR= sc.nextInt();
                sc.nextLine();
                pointValide=true;
            } catch (InputMismatchException e) {
                System.out.println("Entrer un entier valide");
                sc.nextLine();
            }
        }

        String NiveauQ= "";
        boolean NiveauValide= false;
        while (NiveauQ.isEmpty() || !NiveauValide)
        {
            System.out.println("Entrer le niveau de la question");
            NiveauQ= sc.nextLine();
            if(NiveauQ.equalsIgnoreCase("facile") | NiveauQ.equalsIgnoreCase("difficile") || NiveauQ.equalsIgnoreCase("normale"))
                NiveauValide=true;
            else
                System.out.println("Difficulte non valide. Choissisez entre Difficile, Facile et Normale");

        }

        question firstquestion= new question(quest, rA,rB, rC, rD,rCorrect,pointR,NiveauQ);
        return firstquestion;
    }


    public void modifierQuestion(ArrayList<question> questions) {
        Scanner sc = new Scanner(System.in);

        // Afficher toutes les questions disponibles
        if (questions.isEmpty()) {
            System.out.println("Aucune question n'est disponible.");
            return;
        }

        System.out.println("Veuillez choisir la question à modifier :");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + 1 + ": " + questions.get(i).Question);
        }

        int choix = -1;
        while (choix < 1 || choix > questions.size()) {
            try {
                System.out.println("Entrez le numéro de la question que vous voulez modifier:");
                choix = sc.nextInt();
                sc.nextLine(); // clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                sc.nextLine(); // clear buffer
            }
        }

        // Modifier la question choisie
        question selectedQuestion = questions.get(choix - 1);

        System.out.println("Modifiez la question actuelle (" + selectedQuestion.Question + "): ");
        String newQuest = sc.nextLine();
        if (!newQuest.isEmpty()) {
            selectedQuestion.Question=newQuest;
        }

        System.out.println("Modifiez la réponse A actuelle (" + selectedQuestion.OptionReponse.get("A") + "): ");
        String newA = sc.nextLine();
        if (!newA.isEmpty()) {
            selectedQuestion.OptionReponse.put("A",newA);
        }

        System.out.println("Modifiez la réponse B actuelle (" + selectedQuestion.OptionReponse.get("B") + "): ");
        String newB = sc.nextLine();
        if (!newB.isEmpty()) {
            selectedQuestion.OptionReponse.put("B",newB);
        }

        System.out.println("Modifiez la réponse C actuelle (" + selectedQuestion.OptionReponse.get("C") + "): ");
        String newC = sc.nextLine();
        if (!newC.isEmpty()) {
            selectedQuestion.OptionReponse.put("C",newC);
        }

        System.out.println("Modifiez la réponse D actuelle (" + selectedQuestion.OptionReponse.get("D") + "): ");
        String newD = sc.nextLine();
        if (!newD.isEmpty()) {
            selectedQuestion.OptionReponse.put("D",newD);
        }

        String newCorrect = "";
        while (!newCorrect.matches("[A-D]")) {
            System.out.println("Modifiez la réponse correcte actuelle (" + selectedQuestion.ReponseCorrect + "): ");
            newCorrect = sc.nextLine();
        }
        selectedQuestion.ReponseCorrect=newCorrect;

        System.out.println("Modification réussie!");
    }



    public void supprimerQuestion(ArrayList<question> questions) {
        Scanner sc = new Scanner(System.in);

        if (questions.isEmpty()) {
            System.out.println("Aucune question à supprimer.");
            return;
        }

        System.out.println("Veuillez choisir la question à supprimer :");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + 1 + ": " + questions.get(i).Question);
        }

        int choix = -1;
        while (choix < 1 || choix > questions.size()) {
            try {
                System.out.println("Entrez le numéro de la question que vous voulez supprimer:");
                choix = sc.nextInt();
                sc.nextLine(); // clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                sc.nextLine(); // clear buffer
            }
        }

        // Supprimer la question choisie
        questions.remove(choix - 1);
        System.out.println("La question a été supprimée.");
    }



    public Quizz ajouterQuizz() {
        Quizz newQuizz=new Quizz();
        System.out.println("Bonjour vous voulez creer un nouveau Quizz");
        Scanner sc= new Scanner(System.in);


        String theme="";
        while (theme.isEmpty()) {
            System.out.println("Entrer le theme du quizz");
            theme = sc.nextLine();
        }

        ArrayList<question> listquestionfinal=new ArrayList<question>();

        int choix=0;
        int i=0;
        while(choix==0)
        {
            question quest=ajouterQuestion();
            listquestionfinal.add(quest);
            if(i>=3) {
                boolean choixValide=false;
                boolean choixdispo=false;
                int choixUser=0;
                while(!choixValide || !choixdispo) {
                    try{
                        System.out.println("Voulez vous ajouter une question ajouter?");
                        System.out.println("0: OUi \t 1: NON");
                        choixUser= sc.nextInt();
                        sc.nextLine();
                        if (choixUser==0 || choixUser==1){
                            choixdispo=true;
                            if (choixUser==1)
                                choix=1;
                        }
                        choixValide=true;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrer un entier valide");
                        sc.nextLine();
                    }
                }

            }
            i++;
        }
        newQuizz.ajouterQuestion(theme,listquestionfinal);
        newQuizz.Afficher();

        return newQuizz;
    }


    public void modifierQuizz(ArrayList<Quizz> listeQuizz) {
        Scanner sc = new Scanner(System.in);

        // Afficher tous les thèmes disponibles
        System.out.println("Voici les thèmes disponibles:");
        for (int i = 0; i < listeQuizz.size(); i++) {
            Quizz quizz = listeQuizz.get(i);
            System.out.println((i + 1) + ": " + quizz.listQuestion.keySet());
        }

        // Choisir le quizz à modifier en fonction du thème
        System.out.println("Entrez le numéro du Quizz que vous voulez modifier:");
        int choixQuizz = sc.nextInt();
        sc.nextLine(); // Vider le buffer

        if (choixQuizz < 1 || choixQuizz > listeQuizz.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Quizz quizzChoisi = listeQuizz.get(choixQuizz - 1); // Récupérer le quizz sélectionné

        // Afficher le thème actuel et demander un nouveau thème
        System.out.println("Modifiez le thème actuel (" + quizzChoisi.listQuestion.keySet() + "): ");
        String newTheme = sc.nextLine();
        if (!newTheme.isEmpty()) {
            // Récupérer l'ancien thème
            String oldTheme = quizzChoisi.listQuestion.keySet().iterator().next();
            ArrayList<question> questions = quizzChoisi.listQuestion.remove(oldTheme);

            if (questions == null) {
                System.out.println("Le thème sélectionné ne contient pas de questions.");
                return;
            }

            // Remplacer l'ancien thème par le nouveau
            quizzChoisi.listQuestion.put(newTheme, questions);
        }

        System.out.println("Que voulez-vous modifier ?");
        System.out.println("1: Modifier une question");
        System.out.println("2: Supprimer une question");
        System.out.println("3: Ajouter une nouvelle question");

        int choix = sc.nextInt();
        sc.nextLine(); // Vider le buffer

        // Vérifier si la liste de questions est null ou vide avant de continuer
        ArrayList<question> questionList = quizzChoisi.listQuestion.get(newTheme);
        if (questionList == null || questionList.isEmpty()) {
            System.out.println("Ce quizz ne contient pas de questions.");
            return;
        }

        switch (choix) {
            case 1:
                modifierQuestion(questionList); // Modifier la question du thème
                break;

            case 2:
                supprimerQuestion(questionList); // Supprimer une question du thème
                break;

            case 3:
                questionList.add(ajouterQuestion());
                System.out.println("Question ajoutée avec succès.");
                break;

            default:
                System.out.println("Choix invalide.");
        }
    }





    public void supprimerQuizz(ArrayList<Quizz> quizzList) {
        Scanner sc = new Scanner(System.in);

        if (quizzList.isEmpty()) {
            System.out.println("Aucun quizz à supprimer.");
            return;
        }

        System.out.println("Veuillez choisir le quizz à supprimer :");
        for (int i = 0; i < quizzList.size(); i++) {
            System.out.println(i + 1 + ": " + quizzList.get(i).listQuestion.keySet());
        }

        int choix = -1;
        while (choix < 1 || choix > quizzList.size()) {
            try {
                System.out.println("Entrez le numéro du quizz que vous voulez supprimer:");
                choix = sc.nextInt();
                sc.nextLine(); // clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                sc.nextLine(); // clear buffer
            }
        }

        // Supprimer le quizz sélectionné
        quizzList.remove(choix - 1);
        System.out.println("Le quizz a été supprimé.");
    }

}
