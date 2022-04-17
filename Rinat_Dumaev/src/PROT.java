import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Translating RNA into Protein
 * https://rosalind.info/problems/prot/
 */
public class PROT {
    private static final String FILE_NAME = "resources/rosalind_prot.txt";
    private static final String STOP = "Stop";
    private static final int CODON_SIZE = 3;

    public static void main(String[] args) throws IOException {
        HashMap<String, String> codonTable = getCodonTable();

        String input = Files.readString(Path.of(FILE_NAME));

        String result = split(input, CODON_SIZE)
                .stream()
                .takeWhile(codon -> !codonTable.get(codon).equals(STOP))
                .map(codon -> getCodonTable().get(codon))
                .collect(Collectors.joining());

        System.out.println(result);
    }

    private static List<String> split(String s, int partitionSize) {
        List<String> parts = new ArrayList<>();

        for (int i = 0; i < s.length(); i += partitionSize) {
            parts.add(s.substring(i, Math.min(s.length(), i + partitionSize)));
        }

        return parts;
    }


    private static HashMap<String, String> getCodonTable() {
        HashMap<String, String> codonTable = new HashMap<>();

        codonTable.put("UUU", "F");
        codonTable.put("CUU", "L");
        codonTable.put("AUU", "I");
        codonTable.put("GUU", "V");
        codonTable.put("UUC", "F");
        codonTable.put("CUC", "L");
        codonTable.put("AUC", "I");
        codonTable.put("GUC", "V");
        codonTable.put("UUA", "L");
        codonTable.put("CUA", "L");
        codonTable.put("AUA", "I");
        codonTable.put("GUA", "V");
        codonTable.put("UUG", "L");
        codonTable.put("CUG", "L");
        codonTable.put("AUG", "M");
        codonTable.put("GUG", "V");
        codonTable.put("UCU", "S");
        codonTable.put("CCU", "P");
        codonTable.put("ACU", "T");
        codonTable.put("GCU", "A");
        codonTable.put("UCC", "S");
        codonTable.put("CCC", "P");
        codonTable.put("ACC", "T");
        codonTable.put("GCC", "A");
        codonTable.put("UCA", "S");
        codonTable.put("CCA", "P");
        codonTable.put("ACA", "T");
        codonTable.put("GCA", "A");
        codonTable.put("UCG", "S");
        codonTable.put("CCG", "P");
        codonTable.put("ACG", "T");
        codonTable.put("GCG", "A");
        codonTable.put("UAU", "Y");
        codonTable.put("CAU", "H");
        codonTable.put("AAU", "N");
        codonTable.put("GAU", "D");
        codonTable.put("UAC", "Y");
        codonTable.put("CAC", "H");
        codonTable.put("AAC", "N");
        codonTable.put("GAC", "D");
        codonTable.put("UAA", "Stop");
        codonTable.put("CAA", "Q");
        codonTable.put("AAA", "K");
        codonTable.put("GAA", "E");
        codonTable.put("UAG", "Stop");
        codonTable.put("CAG", "Q");
        codonTable.put("AAG", "K");
        codonTable.put("GAG", "E");
        codonTable.put("UGU", "C");
        codonTable.put("CGU", "R");
        codonTable.put("AGU", "S");
        codonTable.put("GGU", "G");
        codonTable.put("UGC", "C");
        codonTable.put("CGC", "R");
        codonTable.put("AGC", "S");
        codonTable.put("GGC", "G");
        codonTable.put("UGA", "Stop");
        codonTable.put("CGA", "R");
        codonTable.put("AGA", "R");
        codonTable.put("GGA", "G");
        codonTable.put("UGG", "W");
        codonTable.put("CGG", "R");
        codonTable.put("AGG", "R");
        codonTable.put("GGG", "G");

        return codonTable;
    }
}
