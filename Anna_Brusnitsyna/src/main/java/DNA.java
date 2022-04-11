import java.util.Arrays;

// https://rosalind.info/problems/dna/
public class DNA {
    public enum NucleotideType {A, C, G, T}

    public static String count(String dnaString) throws Exception {
        if (dnaString == null) {
            throw new Exception("DNA string is null");
        }

        int[] counters = {0, 0, 0, 0};

        for (char chr : dnaString.toUpperCase().toCharArray()) {
            try {
                NucleotideType nucleotide = NucleotideType.valueOf(Character.toString(chr));
                counters[nucleotide.ordinal()]++;
            } catch (IllegalArgumentException e) {
                throw new Exception("Incorrect nucleotide symbol: " + chr);
            }
        }

        String[] tmpStringArray = Arrays
                .stream(counters)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        return String.join(" ", tmpStringArray);
    }
}
