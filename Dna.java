import java.io.*;
import java.util.Scanner;

/**
 * dna
 */
public class Dna {

    static private String INPUT_FILE_NAME = "rosalind_dna.txt";


    public static void main(String[] args) {
        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        int aTokenCounter = 0;
        int cTokenCounter = 0;
        int gTokenCounter = 0;
        int tTokenCounter = 0;

        String dnaStr = scanner.nextLine();
        for (char token : dnaStr.toCharArray()) {
            switch (token) {
                case 'A':
                    aTokenCounter++;
                    break;
                case 'C':
                    cTokenCounter++;
                    break;
                case 'G':
                    gTokenCounter++;
                    break;
                case 'T':
                    tTokenCounter++;
                    break;
                default:
                    System.out.println("Unrecognized token " + token);
                    break;
            }
        }

        System.out.printf("%d %d %d %d",
                          aTokenCounter,
                          cTokenCounter,
                          gTokenCounter,
                          tTokenCounter);
    }
}
