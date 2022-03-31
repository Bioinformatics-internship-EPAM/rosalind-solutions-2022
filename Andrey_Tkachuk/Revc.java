import java.io.*;
import java.util.Scanner;

/**
 * Revc - Complementing a Strand of DNA
 * Link to Rosalind task: https://rosalind.info/problems/revc/
 * 
 * Task brief description:
 * In DNA strings, symbols 'A' and 'T' are complements of each 
 * other, as are 'C' and 'G'.
 * 
 * The reverse complement of a DNA string s is the string sc 
 * formed by reversing the symbols of s, then taking the 
 * complement of each symbol (e.g., the reverse complement 
 * of "GTCA" is "TGAC").
 * 
 * Given: A DNA string s of length at most 1000 bp.
 * 
 * Return: The reverse complement sc of s.
 */
public class Revc {

    static private String INPUT_FILE_NAME = "data/rosalind_revc.txt";

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