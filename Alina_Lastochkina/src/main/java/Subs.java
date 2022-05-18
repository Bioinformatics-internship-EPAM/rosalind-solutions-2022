import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Subs {
   // private static String path = "src/main/resources/rosalind_subs.txt";
    public static void main(String[] args) {
        //String subs = null;
        StringBuilder result = new StringBuilder();
        //StringBuilder result;
        try {
            File file = new File("src/main/resources/rosalind_subs.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            String subs = reader.readLine();
            // считываем остальные строки в цикле
            String st = reader.readLine();
            int seqLength = st.length();
            for (int i = 0; i < subs.length() - seqLength; i++) {
                String substring = subs.substring(i, i + seqLength);
                if (substring.equals(st)) result.append(i + 1).append(" ");
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if (result.length() > 0) {
            String t = result.substring(0, result.length() - 1);
            System.out.println(t);
        }
    }
}
