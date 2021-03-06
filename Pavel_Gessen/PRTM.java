import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/prtm/

Problem
In a weighted alphabet, every symbol is assigned a positive real
number called a weight. A string formed from a weighted alphabet
is called a weighted string, and its weight is equal to the sum
of the weights of its symbols.

The standard weight assigned to each member of the 20-symbol amino
acid alphabet is the monoisotopic mass of the corresponding amino acid.

Given: A protein string P of length at most 1000 aa.

Return: The total weight of P. Consult the monoisotopic mass table.

Sample Dataset
SKADYEK
Sample Output
821.392
 */

public class PRTM {
    public static void main(String[] args) {
        String fileName = "data/rosalind_prtm.txt";
        String data = null;
        try {
            Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            data = scanner.nextLine();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Double> massTable = new HashMap<>();

        massTable.put("A", 71.03711);
        massTable.put("C", 103.00919);
        massTable.put("D", 115.02694);
        massTable.put("E", 129.04259);
        massTable.put("F", 147.06841);
        massTable.put("G", 57.02146);
        massTable.put("H", 137.05891);
        massTable.put("I", 113.08406);
        massTable.put("K", 128.09496);
        massTable.put("L", 113.08406);
        massTable.put("M", 131.04049);
        massTable.put("N", 114.04293);
        massTable.put("P", 97.05276);
        massTable.put("Q", 128.05858);
        massTable.put("R", 156.10111);
        massTable.put("S", 87.03203);
        massTable.put("T", 101.04768);
        massTable.put("V", 99.06841);
        massTable.put("W", 186.07931);
        massTable.put("Y", 163.06333);

        Double result = 0.;
        for (char token : data.toCharArray())
        {
            result = result + massTable.get("" + token);
        }

        System.out.println(result);
    }
}
