import java.io.File;
import java.util.Scanner;

/**
 * Rna - Transcribing DNA into RNA
 * Link to Rosalind task: https://rosalind.info/problems/rna/
 * 
 * Task brief description:
 * An RNA string is a string formed from the alphabet 
 * containing 'A', 'C', 'G', and 'U'.
 * 
 * Given a DNA string t corresponding to a coding strand, 
 * its transcribed RNA string u is formed by replacing 
 * all occurrences of 'T' in t with 'U' in u.
 * 
 * Given: A DNA string t having length at most 1000 nt.
 * 
 * Return: The transcribed RNA string of t.
 */
public class Rna {

    static private String INPUT_FILE_NAME = "data/rosalind_rna.txt";

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