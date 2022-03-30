import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * DNA task solution: https://rosalind.info/problems/dna/
 *
 * Given: A DNA string s of length at most 1000 nt.
 * 
 * Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s.
 */

public class DNA {

    public static List<Integer> DNATask () throws IOException {
        var data = Utils.readFromFile("resources/rosalind_dna.txt").get(0);
        Map <Character, Integer> map = new HashMap<>();
        for (int i=0; i < data.length(); i++) {
            map.merge(data.charAt(i), 1, Integer::sum);
        }
        return List.of(map.get('A'), map.get('C'), map.get('G'), map.get('T'));
    }
    public static void main(String[] args) throws IOException {
        System.out.println(DNATask());
    }
}
