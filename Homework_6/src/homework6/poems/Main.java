package homework6.poems;

public class Main {

    public static void main(String[] args) {

        TextPoem tp = new TextPoem();
        tp.createPoemYouth();
        tp.createPoemPunkRock();
        tp.createPoemYouthAndPunkRock();
        tp.writePoem("youth_and_punk_rock.txt");
        System.out.println(tp.findStringInFile("youth.txt","Утро"));
    }
}
