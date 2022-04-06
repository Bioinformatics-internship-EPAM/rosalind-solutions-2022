import java.io.*;
import java.util.Scanner;

/**
 * Hamm - Counting Point Mutations
 * Link to Rosalind task: https://rosalind.info/problems/hamm/
 * 
 * Task brief description:
 * Given two strings s and t of equal length, the Hamming distance 
 * between s and t, denoted dH(s,t), is the number of corresponding 
 * symbols that differ in s and t. See Figure 2.
 * 
 * Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
 * 
 * Return: The Hamming distance dH(s,t).
 */
public class Hamm {
    static private String INPUT_FILE_NAME = "data/rosalind_hamm.txt";

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
