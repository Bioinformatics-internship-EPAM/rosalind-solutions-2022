import java.io.File;
import java.util.Vector;
import java.util.Scanner;
import models.Fasta;

/**
 * Cons - Consensus and Profile
 * Link to Rosalind task: https://rosalind.info/problems/cons/
 * 
 * Task brief description:
 * 
 * 
 * A matrix is a rectangular table of values divided into rows and columns. An m×n matrix 
 * has m rows and n columns. Given a matrix A, we write Ai,j to indicate the value found 
 * at the intersection of row i and column j.
 * 
 * Say that we have a collection of DNA strings, all having the same length n. 
 * Their profile matrix is a 4×n matrix P in which P1,j represents the number 
 * of times that 'A' occurs in the jth position of one of the strings, P2,j 
 * represents the number of times that C occurs in the jth position, and so on (see below).
 * 
 * A consensus string c is a string of length n formed from our collection 
 * by taking the most common symbol at each position; the jth symbol of c 
 * therefore corresponds to the symbol having the maximum value in the j-th 
 * column of the profile matrix. Of course, there may be more than one most 
 * common symbol, leading to multiple possible consensus strings.
 * 
 *              A T C C A G C T
 *              G G G C A A C T
 *              A T G G A T C T
 * DNA Strings  A A G C A A C C
 *              T T G G A A C T
 *              A T G C C A T T
 *              A T G G C A C T
 * 
 *          A   5 1 0 0 5 5 0 0
 * Profile  C   0 0 1 4 2 0 6 1
 *          G   1 1 6 3 0 1 0 0
 *          T   1 5 0 0 0 1 1 6
 * 
 * Consensus    A T G C A A C T
 * 
 * Given: A collection of at most 10 DNA strings of equal length (at most 1 kbp) in FASTA format.
 * 
 * Return: A consensus string and profile matrix for the collection. (If several possible consensus strings exist, then you may return any one of them.)
 */
public class Cons {

    static private String INPUT_FILE_NAME = "rosalind_cons.txt";

    public static void main(String[] args) {

        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Fasta temp = new Fasta(scanner);

        int dnaLen = temp.getDnaStr().length();
        int[] profileA = new int[dnaLen];
        int[] profileC = new int[dnaLen];
        int[] profileG = new int[dnaLen];
        int[] profileT = new int[dnaLen];

        for (int i = 0; i < dnaLen; ++i)
        {
            profileA[i] = 0;
            profileC[i] = 0;
            profileG[i] = 0;
            profileT[i] = 0;
            switch (temp.getDnaStr().charAt(i)) {
                case 'A':
                    profileA[i] = 1;
                    break;
                case 'C':
                    profileC[i] = 1;
                    break;
                case 'G':
                    profileG[i] = 1;
                    break;
                case 'T':
                    profileT[i] = 1;
                    break;
                default:
                    break;
            }
        }

        while (scanner.hasNextLine())
        {
            temp = new Fasta(scanner);

            for (int i = 0; i < dnaLen; ++i)
            {
                switch (temp.getDnaStr().charAt(i)) {
                    case 'A':
                        profileA[i]++;
                        break;
                    case 'C':
                        profileC[i]++;
                        break;
                    case 'G':
                        profileG[i]++;
                        break;
                    case 'T':
                        profileT[i]++;
                        break;
                    default:
                        break;
                }
            }
        }
        scanner.close();
        
        StringBuilder consensusString = new StringBuilder();
        for (int i = 0; i < dnaLen; ++i)
        {
            if (profileA[i] >= profileC[i] && 
                profileA[i] >= profileG[i] && 
                profileA[i] >= profileT[i])
            {
                consensusString.append("A");
            }
            else if (profileC[i] >= profileA[i] && 
                     profileC[i] >= profileG[i] && 
                     profileC[i] >= profileT[i])
            {
                consensusString.append("C");
            }
            else if (profileG[i] >= profileC[i] && 
                     profileG[i] >= profileA[i] && 
                     profileG[i] >= profileT[i])
            {
                consensusString.append("G");
            }
            else
            {
                consensusString.append("T");
            }
        }

        System.out.println(consensusString.toString());

        printProfile("A", profileA, dnaLen);
        printProfile("C", profileC, dnaLen);
        printProfile("G", profileG, dnaLen);
        printProfile("T", profileT, dnaLen);
    }

    private static void printProfile(String type, int[] arr, int len)
    {
        System.out.print(type + ": ");
        for (int i = 0; i < len; ++i)
        {
            System.out.print(String.format("%d ", arr[i]));
        }
        System.out.println();
    }
}
