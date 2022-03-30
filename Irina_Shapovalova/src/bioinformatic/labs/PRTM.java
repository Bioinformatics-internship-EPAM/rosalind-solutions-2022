package bioinformatic.labs;

import bioinformatic.labs.utils.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bioinformatic.labs.utils.Constants.resourceFilePath;

/* https://rosalind.info/problems/prtm/ */
public class PRTM {
    private static final String MonoisotopicMassTableFile = resourceFilePath("monoisotopic_mass_table.txt");

    public static double solution(String str) {
        Map<Character, Double> rules = getMonoisotopicMassTable();

        double res = 0.0;
        for (char c : str.toCharArray()) {
            res += rules.getOrDefault(c, 0.0);
        }

        return res;
    }

    private static Map<Character, Double> getMonoisotopicMassTable() {
        Map<Character, Double> rules = new HashMap<>();

        try {
            List<String> encodeTable = FileReader.readLinesFromFile(MonoisotopicMassTableFile);

            for (String line: encodeTable) {
                String[] parsedLine = line.split("[ ]+");
                rules.put(parsedLine[0].charAt(0), Double.parseDouble(parsedLine[1]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rules;
    }
}
