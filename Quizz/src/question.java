import java.util.HashMap;

public class question {
    public String Question;
    public HashMap<String, String> OptionReponse= new HashMap<>();
    public String ReponseCorrect;
    public int PointReponse;
    public String DifficulteQuestion;

    @Override
    public String toString() {
        return Question; // Retourne le texte de la question
    }

    public question(String Question, String reponseA, String reponseB, String reponseC, String reponseD, String ReponseCorrect, int PointReponse, String DifficulteQuestion){
        this.Question=Question;
        this.OptionReponse.put("A",reponseA);
        this.OptionReponse.put("B",reponseB);
        this.OptionReponse.put("C",reponseC);
        this.OptionReponse.put("D",reponseD);
        this.ReponseCorrect=ReponseCorrect;
        this.PointReponse=PointReponse;
        this.DifficulteQuestion=DifficulteQuestion;

    }
}
