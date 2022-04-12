import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Rosalind task - https://rosalind.info/problems/rna/
Sample Input - GATGGAACTTGACTACGTAAATT
Sample Output - GAUGGAACUUGACUACGUAAAUU
*/

public class RNA {

    static private String INPUT_FILE = "src/resources/rosalind_rna.txt";

    public static void main( String[] args ) throws Exception {
        Path filePath = Paths.get(INPUT_FILE);
        final String inputString = new String( Files.readAllBytes(filePath) );

        System.out.println( inputString.replace('T', 'U') );

    }
}
