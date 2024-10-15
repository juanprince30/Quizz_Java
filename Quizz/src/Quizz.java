import java.util.ArrayList;
import java.util.HashMap;

public class Quizz implements Affichable {
    HashMap<String, ArrayList<question>> listQuestion= new HashMap<String, ArrayList<question>>();

    public Quizz()
    {}

    public void ajouterQuestion(String theme, ArrayList<question> quests){
        this.listQuestion.put(theme,quests);
    }

    @Override
    public void Afficher() {
        for(String key: listQuestion.keySet()) {
            System.out.println("Theme : " + key);
            ArrayList<question> quests = listQuestion.get(key);
            for(question quest: quests){
                System.out.println("La Question est de niveau "+quest.DifficulteQuestion+" et compte pour "+quest.PointReponse+" points");
                System.out.println(quest.Question);
                System.out.println("A: "+quest.OptionReponse.get("A"));
                System.out.println("B: "+quest.OptionReponse.get("B"));
                System.out.println("C: "+quest.OptionReponse.get("C"));
                System.out.println("D: "+quest.OptionReponse.get("D"));
            }

        }
    }

    @Override
    public String toString() {
        return listQuestion.keySet().toString();
    }
}
