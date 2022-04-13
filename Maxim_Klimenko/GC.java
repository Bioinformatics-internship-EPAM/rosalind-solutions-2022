import utils.FastaFormatUtil;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/gc/
Sample Input:
>Rosalind_6404
CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC
TCCCACTAATAATTCTGAGG
>Rosalind_5959
CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT
ATATCCATTTGTCAGCAGACACGC
>Rosalind_0808
CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC
TGGGAACCTGCGGGCAGTAGGTGGAAT

Sample Output:
Rosalind_0808
60.919540
*/

public class GC {

    static private String INPUT_FILE = "src/resources/rosalind_gc.txt";

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));

        HashMap<String, String> dnaTable = FastaFormatUtil.readFastaFile( scanner );

        double highestScore = 0.0;
        String highestScoreLabel = "";

        for ( String dna : dnaTable.values() ) {
            double tmpScore = calculateGCcontent(dna);

            if ( highestScore < tmpScore ) {
                highestScore = tmpScore;
                highestScoreLabel = FastaFormatUtil.getLabelByValue( dnaTable, dna );
            }
        }

        System.out.println (highestScoreLabel + "\n" + highestScore );

    }

    private static double calculateGCcontent( String dnaStr ) {
        int gcCount = 0;

        for ( char c : dnaStr.toCharArray() ) {
            if ( c == 'G' || c == 'C' ) {
                gcCount++;
            }
        }

        return 100.0 * gcCount / dnaStr.length();
    }
}
