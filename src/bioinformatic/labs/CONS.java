package bioinformatic.labs;

import bioinformatic.labs.utils.FileReader;

import java.util.*;
import java.util.stream.Collectors;

import static bioinformatic.labs.utils.FileReader.parseFASTAFormat;

/* https://rosalind.info/problems/cons/ */
public class CONS {
    private int[][] profileMatrix;
    private int n = 0;

    private final int aChar = 0;
    private final int cChar = 1;
    private final int gChar = 2;
    private final int tChar = 3;

    public void solution(String filename) {
        List<String> DNAStrings = new ArrayList<>();

        try {
            List<String> file = FileReader.readLinesFromFile(filename);
            Map<String, String> DNAMap = parseFASTAFormat(file);
            DNAStrings.addAll(DNAMap.values());
            n = DNAStrings.get(0).length();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        profileMatrix = new int[4][n];
        for (String line : DNAStrings) {
            for (int i = 0; i < n; i++) {
                switch (line.charAt(i)) {
                    case 'A':
                        profileMatrix[aChar][i]++;
                        break;
                    case 'C':
                        profileMatrix[cChar][i]++;
                        break;
                    case 'G':
                        profileMatrix[gChar][i]++;
                        break;
                    case 'T':
                        profileMatrix[tChar][i]++;
                    default:
                        break;
                }
            }
        }
    }

    public String getProfileMatrix() {
        return "" +
                "A: " + join(profileMatrix[aChar]) + "\n" +
                "C: " + join(profileMatrix[cChar]) + "\n" +
                "G: " + join(profileMatrix[gChar]) + "\n" +
                "T: " + join(profileMatrix[tChar]) + "\n";
    }

    public String getConsensus() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            List<Integer> column = List.of(
                    profileMatrix[aChar][i],
                    profileMatrix[cChar][i],
                    profileMatrix[gChar][i],
                    profileMatrix[tChar][i]
            );
            int maxPosition = column.indexOf(Collections.max(column));
            switch (maxPosition) {
                case aChar:
                    builder.append('A');
                    break;
                case cChar:
                    builder.append('C');
                    break;
                case gChar:
                    builder.append('G');
                    break;
                case tChar:
                    builder.append('T');
                    break;
                default:
                    break;
            }
        }

        return builder.toString();
    }

    private String join(int[] intArray) {
        return Arrays
                .stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
