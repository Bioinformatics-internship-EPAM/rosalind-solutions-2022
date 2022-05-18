import java.nio.file.Files;
import java.nio.file.Path;

public class RNA {
    static private String path = "src/main/resources/rosalind_rna.txt";
    public static void main(String[] args) {

        String rna = " ";
        try {
            rna = Files.readAllLines(Path.of(path)).get(0);
        }
        catch (Exception e) { System.out.printf("Error"); }
         rna = rna.replace("T","U");
        System.out.printf( rna.toString());
    }
}
