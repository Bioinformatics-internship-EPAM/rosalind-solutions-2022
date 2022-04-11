import java.io.File;
import java.util.*;

// https://rosalind.info/problems/cons/
public class CONS {
    public static int sequenceLength = 0;

    public enum NucleotideType {A, C, G, T}

    public static String solve(String inputPath) throws Exception {
        File inputFile = new File(inputPath);
        Scanner sc = new Scanner(inputFile);

        String label = sc.nextLine();
        String sequence = sc.nextLine().toUpperCase();
        sequenceLength = sequence.length();

        int[][] profile = new int[4][sequenceLength];

        while (true) {
            if (sequence.length() != sequenceLength) {
                throw new Exception("Sequence " + label + " has incorrect length");
            }
            for (int i = 0; i < sequenceLength; i++) {
                char chr = sequence.charAt(i);
                try {
                    NucleotideType nucleotide = NucleotideType.valueOf(Character.toString(chr));
                    profile[nucleotide.ordinal()][i]++;
                } catch (IllegalArgumentException e) {
                    throw new Exception("Incorrect nucleotide symbol: " + chr + " (" + label + ")");
                }
            }
            if (!sc.hasNextLine()) {
                break;
            }
            label = sc.nextLine();
            sequence = sc.nextLine().toUpperCase();
        }
        sc.close();

        StringBuilder consensus = new StringBuilder();
        for (int i = 0; i < sequenceLength; i++) {
            int maxNucl = 0;
            for (NucleotideType nucl : NucleotideType.values()) {
                maxNucl = profile[nucl.ordinal()][i] > profile[maxNucl][i] ? nucl.ordinal() : maxNucl;
            }
            consensus.append(NucleotideType.values()[maxNucl]);
        }
        for (NucleotideType nucl : NucleotideType.values()) {
            String[] tmpStringArray = Arrays
                    .stream(profile[nucl.ordinal()])
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
            consensus.append("\n" + nucl + ": " + String.join(" ", tmpStringArray));
        }

        return consensus.toString();
    }
}
