package homework6.poems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class TextPoem {

    void createPoemYouth(){
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("youth.txt"));
            ps.println("Поезд трясет от холода.\n" +
                    "Утро зевает в ухо.\n" +
                    "Не плачь, моя милая молодость!\n" +
                    "Нам ли тонуть в бытовухе?\n" +
                    "\n" +
                    "Мы еще многое можем: нам только б расправить крылья!\n" +
                    "Нам отдрожать бы дрожи, пока нас еще не зарыли\n");
            ps.flush();
            ps.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void createPoemPunkRock(){
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("punk_rock.txt"));
            ps.println("В землю, как непригодных, списанных, лишних, ненужных\n" +
                    "Неадекватных, не модных, неизлечимо простуженных.\n" +
                    "\n" +
                    "Пой, моя бедная молодость!\n" +
                    "Всё обязательно будет!\n" +
                    "Тем, чьи сердца не остыли в холоде -\n" +
                    "Вселенная дарит чудо!\n");
            ps.flush();
            ps.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void createPoemYouthAndPunkRock(){
        try {
            Scanner sc = new Scanner(new FileInputStream("youth.txt"));
            PrintStream ps = new PrintStream(new FileOutputStream("youth_and_punk_rock.txt"));
            while (sc.hasNext()) {
                ps.println(sc.nextLine());
            }
            sc = new Scanner(new FileInputStream("punk_rock.txt"));
            while (sc.hasNext()) {
                ps.println(sc.nextLine());
            }
            sc.close();
            ps.flush();
            ps.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void writePoem(String poem) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(poem));
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    boolean findStringInFile(String file,String word){
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNext()){
                if(sc.next().equals(word)){
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
