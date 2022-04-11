import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

// https://rosalind.info/problems/prot/
public class PROT {
    private static final HashMap<String, String> rnaCodonTable = new HashMap<>(Map.ofEntries(
            entry("UUU", "F"), entry("CUU", "L"), entry("AUU", "I"), entry("GUU", "V"),
            entry("UUC", "F"), entry("CUC", "L"), entry("AUC", "I"), entry("GUC", "V"),
            entry("UUA", "L"), entry("CUA", "L"), entry("AUA", "I"), entry("GUA", "V"),
            entry("UUG", "L"), entry("CUG", "L"), entry("AUG", "M"), entry("GUG", "V"),
            entry("UCU", "S"), entry("CCU", "P"), entry("ACU", "T"), entry("GCU", "A"),
            entry("UCC", "S"), entry("CCC", "P"), entry("ACC", "T"), entry("GCC", "A"),
            entry("UCA", "S"), entry("CCA", "P"), entry("ACA", "T"), entry("GCA", "A"),
            entry("UCG", "S"), entry("CCG", "P"), entry("ACG", "T"), entry("GCG", "A"),
            entry("UAU", "Y"), entry("CAU", "H"), entry("AAU", "N"), entry("GAU", "D"),
            entry("UAC", "Y"), entry("CAC", "H"), entry("AAC", "N"), entry("GAC", "D"),
            entry("UAA", "Stop"), entry("CAA", "Q"), entry("AAA", "K"), entry("GAA", "E"),
            entry("UAG", "Stop"), entry("CAG", "Q"), entry("AAG", "K"), entry("GAG", "E"),
            entry("UGU", "C"), entry("CGU", "R"), entry("AGU", "S"), entry("GGU", "G"),
            entry("UGC", "C"), entry("CGC", "R"), entry("AGC", "S"), entry("GGC", "G"),
            entry("UGA", "Stop"), entry("CGA", "R"), entry("AGA", "R"), entry("GGA", "G"),
            entry("UGG", "W"), entry("CGG", "R"), entry("AGG", "R"), entry("GGG", "G")
    ));

    public static String solve(String rnaString) throws Exception {
        if (rnaString == null) {
            throw new Exception("RNA string is null");
        }
        if (rnaString.length() % 3 != 0) {
            throw new Exception("RNA string with incorrect length");
        }
        String codon = rnaString.substring(0, 3);
        if (!codon.equals("AUG")) {
            throw new Exception("Incorrect start codon: " + codon);
        }
        codon = rnaString.substring(rnaString.length() - 3);
        if (!rnaCodonTable.get(codon).equals("Stop")) {
            throw new Exception("Incorrect last codon: " + codon);
        }

        StringBuilder proteinString = new StringBuilder();
        for (int i = 0; i < rnaString.length() - 3; i += 3) {
            codon = rnaString.substring(i, i + 3);
            if (!rnaCodonTable.containsKey(codon)) {
                throw new Exception("Incorrect codon: " + codon);
            }
            proteinString.append(rnaCodonTable.get(codon));
        }

        return proteinString.toString();
    }
}
