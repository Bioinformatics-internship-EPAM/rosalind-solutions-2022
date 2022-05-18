import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class Revc {
    static private String path = "src/main/resources/rosalind_revc.txt";
    public static void main(String[] args) {


        String revc = " ";
        String revc_main = " ";
        try {
            revc = Files.readAllLines(Path.of(path)).get(0);
        }
        catch (Exception e) { System.out.printf("Error"); }
        revc = revc.replace("A","1");
        revc = revc.replace("T","2");
        revc = revc.replace("C","3");
        revc = revc.replace("G","4");
        revc = revc.replace("1","T");
        revc = revc.replace("2","A");
        revc = revc.replace("3","G");
        revc = revc.replace("4","C");
        int stringLength = revc.length();
        for (int i = 0; i < stringLength; i++) {
            revc_main = revc.charAt(i) + revc_main;
        }
        System.out.printf( revc_main.toString());
    }
}

