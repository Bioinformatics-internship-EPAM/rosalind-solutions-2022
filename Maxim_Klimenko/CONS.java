import utils.FastaFormatUtil;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/cons/

Sample input:
>Rosalind_1
ATCCAGCT
>Rosalind_2
GGGCAACT
>Rosalind_3
ATGGATCT
>Rosalind_4
AAGCAACC
>Rosalind_5
TTGGAACT
>Rosalind_6
ATGCCATT
>Rosalind_7
ATGGCACT

Sample output:
ATGCAACT
A: 5 1 0 0 5 5 0 0
C: 0 0 1 4 2 0 6 1
G: 1 1 6 3 0 1 0 0
T: 1 5 0 0 0 1 1 6
*/

public class CONS {

    static private String INPUT_FILE = "src/resources/rosalind_cons.txt";

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));

        ArrayList<char[]> charMatrix = new ArrayList<>();
        for ( String dna : FastaFormatUtil.readFastaFile(scanner).values() ) {
                charMatrix.add(dna.toCharArray());
        }

        int dnaStringLeght = charMatrix.get(0).length;

        HashMap<Character, int[]> profileMatrix = getProfileMatrix( charMatrix, dnaStringLeght );

        System.out.println(getConsensusString( profileMatrix, dnaStringLeght ));

        char[] symbols = new char[]{'A','C','G','T'};
        for ( char key: symbols ) {
            System.out.print( key + ": " );

            int[] n = profileMatrix.get(key);
            for ( int i = 0; i < n.length ; i++ ) {
                System.out.print(n[i] + " ");
            }

            System.out.println();
        }

    }

    private static HashMap<Character, int[]> getProfileMatrix( ArrayList<char[]> matrix, int dnaStringLeght ) {

        HashMap<Character, int[]> profileMap = new HashMap<>();
        for ( int i = 0; i < dnaStringLeght ; i++ ) {

            for (char[] c : matrix) {
                int[] n = profileMap.get(c[i]);

                if (n == null) {
                    n = new int[dnaStringLeght];
                    Arrays.fill(n, 0);
                    n[i] = 1;
                    profileMap.put(c[i], n);
                } else {
                    n[i]++;
                    profileMap.put(c[i], n);
                }
            }
        }

        return profileMap;
    }

    private static String getConsensusString( HashMap<Character, int[]> matrix , int dnaStringLeght ) {
        StringBuilder consensusString = new StringBuilder();

        int maxValue;
        char maxValueKey;

        for ( int i = 0; i < dnaStringLeght; i++ ) {
            maxValue = 0;
            maxValueKey = ' ';

            for (char key : matrix.keySet()) {
                if (maxValue < matrix.get(key)[i]) {
                    maxValue = matrix.get(key)[i];
                    maxValueKey = key;
                }
            }

            consensusString.append(maxValueKey);

        }

        return consensusString.toString();
    }

}
