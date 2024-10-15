public class reponse {
    public String ReponseQuestion;

    public String Statutreponse(String reponseCorrect){
        if (this.ReponseQuestion.matches("[A-D]")) { // Vérifie si la réponse est entre A et D
            if (reponseCorrect.equals(this.ReponseQuestion)) {
                System.out.println("La réponse est correcte, bravo !");
                return "Correct";
            } else {
                System.out.println("La réponse est incorrecte, une prochaine fois");
                return "Incorrect";
            }
        } else {
            System.out.println("Réponse invalide");
            return "Invalide";
        }

    }

    public reponse(String reponseQuestion){
        this.ReponseQuestion=reponseQuestion;
    }
}
