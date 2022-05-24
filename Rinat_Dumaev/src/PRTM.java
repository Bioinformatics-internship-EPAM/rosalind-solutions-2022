import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Collectors;


/**
 * Calculating Protein Mass
 * https://rosalind.info/problems/prtm/
 */
public class PRTM {
    private static final String FILE_NAME = "resources/rosalind_prtm.txt";

    public static void main(String[] args) throws IOException {
        HashMap<Character, Double> monoisotopicMass = getMonoisotopicMassTable();

        String input = Files.readString(Path.of(FILE_NAME)).replace("\n", "");

        Double result = input
                .chars()
                .mapToObj(c -> (char) c)
                .map(monoisotopicMass::get)
                .collect(Collectors.summarizingDouble(Double::doubleValue))
                .getSum();

        System.out.println(result);
    }

    private static HashMap<Character, Double> getMonoisotopicMassTable() {
        HashMap<Character, Double> monoisotopicMassTable = new HashMap<>();

        monoisotopicMassTable.put('A', 71.03711);
        monoisotopicMassTable.put('C', 103.00919);
        monoisotopicMassTable.put('D', 115.02694);
        monoisotopicMassTable.put('E', 129.04259);
        monoisotopicMassTable.put('F', 147.06841);
        monoisotopicMassTable.put('G', 57.02146);
        monoisotopicMassTable.put('H', 137.05891);
        monoisotopicMassTable.put('I', 113.08406);
        monoisotopicMassTable.put('K', 128.09496);
        monoisotopicMassTable.put('L', 113.08406);
        monoisotopicMassTable.put('M', 131.04049);
        monoisotopicMassTable.put('N', 114.04293);
        monoisotopicMassTable.put('P', 97.05276);
        monoisotopicMassTable.put('Q', 128.05858);
        monoisotopicMassTable.put('R', 156.10111);
        monoisotopicMassTable.put('S', 87.03203);
        monoisotopicMassTable.put('T', 101.04768);
        monoisotopicMassTable.put('V', 99.06841);
        monoisotopicMassTable.put('W', 186.07931);
        monoisotopicMassTable.put('Y', 163.06333);

        return monoisotopicMassTable;

    }
}
