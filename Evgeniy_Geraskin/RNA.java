import java.io.IOException;

/**
 * RNA task solution: https://rosalind.info/problems/rna/
 *
 * Given: A DNA string t having length at most 1000 nt.
 * 
 * Return: The transcribed RNA string of t.
 */

public class RNA {

    public static String solveRNATask () throws IOException {
        var dataSet = Utils.readFromFile("resources/rosalind_rna.txt").get(0);
        return dataSet.replace('T', 'U');
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solveRNATask());
    }
}
