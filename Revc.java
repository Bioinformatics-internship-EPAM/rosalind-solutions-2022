import java.io.*;
import java.util.Scanner;

/**
 * Revc
 */
public class Revc {

    static private String INPUT_FILE_NAME = "rosalind_revc.txt";

    public static void main(String[] args) {
        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String dnaStr = scanner.nextLine();
        StringBuilder dnaBuilder = new StringBuilder();
        for (char token : dnaStr.toCharArray())
        {
            switch (token) {
                case 'A':
                    dnaBuilder.append('T');
                    break;
                case 'C':
                    dnaBuilder.append('G');
                    break;
                case 'G':
                    dnaBuilder.append('C');
                    break;
                case 'T':
                    dnaBuilder.append('A');
                    break;
                default:
                    System.out.println("Unrecognized token " + token);
                    break;
            }
        }

        System.out.println();
        System.out.println(dnaBuilder.reverse().toString());
    }
}