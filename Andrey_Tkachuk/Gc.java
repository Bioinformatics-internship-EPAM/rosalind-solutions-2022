import java.io.File;
import java.util.Scanner;
import models.Fasta;

/**
 * Gc - Computing GC Content
 * Link to Rosalind task: https://rosalind.info/problems/gc/
 * 
 * Task brief description:
 * The GC-content of a DNA string is given by the percentage of symbols in the string 
 * that are 'C' or 'G'. For example, the GC-content of "AGCTATAG" is 37.5%. Note that 
 * the reverse complement of any DNA string has the same GC-content.
 * 
 * DNA strings must be labeled when they are consolidated into a database. A commonly 
 * used method of string labeling is called FASTA format. In this format, the string 
 * is introduced by a line that begins with '>', followed by some labeling 
 * information. Subsequent lines contain the string itself; the first line to begin 
 * with '>' indicates the label of the next string.
 * 
 * In Rosalind's implementation, a string in FASTA format will be labeled by the ID 
 * "Rosalind_xxxx", where "xxxx" denotes a four-digit code between 0000 and 9999.
 * 
 * Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).
 * 
 * Return: The ID of the string having the highest GC-content, followed by the 
 *         GC-content of that string. Rosalind allows for a default error of 
 *         0.001 in all decimal answers unless otherwise stated; please see 
 *         the note on absolute error below.
 */
public class Gc {

    static private String INPUT_FILE_NAME = "data/rosalind_gc.txt";

    public static void main(String[] args) {

        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Fasta maxGcFasta = new Fasta(scanner);

        while (scanner.hasNextLine())
        {
            Fasta temp = new Fasta(scanner);

            if (temp.getGcScore() > maxGcFasta.getGcScore())
            {
                maxGcFasta = temp;
            }
        }

        scanner.close();

        System.out.println(maxGcFasta.getHeader());
        System.out.println(maxGcFasta.getGcScore());
    }

}
