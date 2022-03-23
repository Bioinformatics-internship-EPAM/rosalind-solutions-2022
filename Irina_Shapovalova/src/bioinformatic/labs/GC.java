package bioinformatic.labs;

import bioinformatic.labs.utils.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bioinformatic.labs.utils.FileReader.parseFASTAFormat;

/* https://rosalind.info/problems/gc/ */
public class GC {
    public static Map.Entry<String, Double> solution(String filename) {
        Map<String, String> DNAStrings = readFASTAFormat(filename);

        Map.Entry<String, Double> result = Map.entry("", 0.0);
        double currentGCContent = result.getValue();
        double newGCContent;

        for (Map.Entry<String, String> dnaString : DNAStrings.entrySet()) {
            newGCContent = countGCContent(dnaString.getValue());

            if (newGCContent > currentGCContent) {
                result = Map.entry(dnaString.getKey(), newGCContent);
                currentGCContent = newGCContent;
            }
        }
        return result;
    }

    private static double countGCContent(String str) {
        int counter = 0;
        for (char c : str.toCharArray()) {
            if (c == 'G' || c == 'C') counter++;
        }
        return (double) counter / str.length() * 100.0;
    }

    private static Map<String, String> readFASTAFormat(String filename) {
        Map<String, String> DNAStrings = new HashMap<>();

        try {
            List<String> file = FileReader.readLinesFromFile(filename);
            DNAStrings = parseFASTAFormat(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return DNAStrings;
    }
}
