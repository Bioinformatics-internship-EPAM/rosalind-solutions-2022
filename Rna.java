import java.io.File;
import java.util.Scanner;

/**
 * Rna
 */
public class Rna {

    static private String INPUT_FILE_NAME = "rosalind_rna.txt";

    public static void main(String[] args) {

        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String dnaStr = scanner.nextLine();
        StringBuilder rnaBuilder = new StringBuilder();
        for (char token : dnaStr.toCharArray())
        {
            switch (token) {
                case 'A':
                case 'C':
                case 'G':
                    rnaBuilder.append(token);
                    break;
                case 'T':
                    rnaBuilder.append('U');
                    break;
                default:
                    System.out.println("Unrecognized token " + token);
                    break;
            }
        }

        System.out.println();
        System.out.println(rnaBuilder.toString());
    }
}