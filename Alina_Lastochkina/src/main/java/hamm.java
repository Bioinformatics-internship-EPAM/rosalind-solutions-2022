import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class hamm {
  //  private String path = "src/main/resources/rosalind_hamm.txt";

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/rosalind_hamm.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            int c = 0;
            for (int i = 0; i < line1.length(); i++) {
                if (line1.charAt(i) != line2.charAt(i))
                    c++;
            }
            System.out.printf(Integer.toString(c));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
