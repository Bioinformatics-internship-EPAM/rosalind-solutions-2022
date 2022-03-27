import java.io.*;
import java.util.Scanner;

/**
 * Hamm
 */
public class Hamm {
    static private String INPUT_FILE_NAME = "rosalind_hamm.txt";

    public static void main(String[] args) {
        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String dnaStr1 = scanner.nextLine();
        String dnaStr2 = scanner.nextLine();
        int hammDist = 0;
        for (int i = 0; i < dnaStr1.length(); i++)
        {
            if (dnaStr1.charAt(i) != dnaStr2.charAt(i))
            {
                hammDist++;
            }
        }

        System.out.println(hammDist);
    }
}
