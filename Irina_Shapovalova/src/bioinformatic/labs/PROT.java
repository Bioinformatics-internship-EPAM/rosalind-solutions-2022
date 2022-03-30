package bioinformatic.labs;

import bioinformatic.labs.utils.Constants;
import bioinformatic.labs.utils.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bioinformatic.labs.utils.Constants.resourceFilePath;

/* https://rosalind.info/problems/prot/ */
public class PROT {
    private static final int KEY_LENGTH = 3;
    private static final String RNACodonTableFile = resourceFilePath("RNA_codon_table.txt");

    public static String solution(String str) {
        assert str.length() % KEY_LENGTH == 0;
        Map<String, String> rules = getRNACodonTable();

        StringBuilder proteinString = new StringBuilder();
        for (int i = 0; i < str.length(); i += KEY_LENGTH) {
            String substring = str.substring(i, i + KEY_LENGTH);
            String protein = rules.get(substring);

            if (protein != null && !protein.equals("Stop"))
                proteinString.append(protein);
            else
                break;
        }

        return proteinString.toString();
    }

    private static Map<String, String> getRNACodonTable() {
        Map<String, String> rules = new HashMap<>();

        try {
            List<String> encodeTable = FileReader.readLinesFromFile(RNACodonTableFile);

            for (String line: encodeTable) {
                String[] parsedLine = line.split("[ ]+");
                assert parsedLine[0].length() == KEY_LENGTH;
                rules.put(parsedLine[0], parsedLine[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rules;
    }
}