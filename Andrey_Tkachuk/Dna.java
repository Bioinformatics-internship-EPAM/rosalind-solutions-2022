import java.io.*;
import java.util.Scanner;

/**
 * Dna - Counting DNA Nucleotides
 * Link to Rosalind task: https://rosalind.info/problems/dna/
 * 
 * Task brief description:
 * A string is simply an ordered collection of symbols selected from some 
 * alphabet and formed into a word; the length of a string is the number 
 * of symbols that it contains.
 * 
 * An example of a length 21 DNA string (whose alphabet contains the 
 * symbols 'A', 'C', 'G', and 'T') is "ATGCTTCAGAAAGGTCTTACG."
 * 
 * Given: A DNA string s of length at most 1000 nt.
 * 
 * Return: Four integers (separated by spaces) counting 
 * the respective number of times that the symbols 
 * 'A', 'C', 'G', and 'T' occur in s.
 */
public class Dna {

    static private String INPUT_FILE_NAME = "data/rosalind_dna.txt";


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
