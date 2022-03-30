import java.io.IOException;
import java.util.Map;

/**
 * REVC task solution: https://rosalind.info/problems/revc/
 *
 * Given: A DNA string s of length at most 1000 bp.
 * 
 * Return: The reverse complement s^c of s.
 */

public class REVC {

    public static StringBuilder REVCTask () throws IOException {
        var dataSet = Utils.readFromFile("resources/rosalind_revc.txt").get(0);
        StringBuilder complimentDNA = new StringBuilder();
        String reversed = new StringBuilder(dataSet).reverse().toString();
        var complements = Map.of(
                'A', 'T',
                'T', 'A',
                'G', 'C',
                'C', 'G'
        );
        for (int i=0; i < dataSet.length(); i++) {
            complimentDNA.append(complements.get(reversed.charAt(i)));
        }
        return complimentDNA;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(REVCTask());
    }
}
