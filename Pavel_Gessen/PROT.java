import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/prot/

Problem
The 20 commonly occurring amino acids are abbreviated by using 20 letters from
the English alphabet (all letters except for B, J, O, U, X, and Z). Protein strings
are constructed from these 20 symbols. Henceforth, the term genetic string will
incorporate protein strings along with DNA strings and RNA strings.

The RNA codon table dictates the details regarding the encoding of specific
codons into the amino acid alphabet.

Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).

Return: The protein string encoded by s.

Sample Dataset
AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA
Sample Output
MAMAPRTEINSTRING
 */

public class PROT {
    public static void main(String[] args) {
        String fileName = "data/rosalind_prot.txt";
        String data = null;
        try {
            Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            data = scanner.nextLine();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> rnaTable = new HashMap<>();

        rnaTable.put("UUU", "F");
        rnaTable.put("UUC", "F");
        rnaTable.put("UUA", "L");
        rnaTable.put("UUG", "L");
        rnaTable.put("UCU", "S");
        rnaTable.put("UCC", "S");
        rnaTable.put("UCA", "S");
        rnaTable.put("UCG", "S");
        rnaTable.put("UAU", "Y");
        rnaTable.put("UAC", "Y");
        rnaTable.put("UAA", "Stop");
        rnaTable.put("UAG", "Stop");
        rnaTable.put("UGU", "C");
        rnaTable.put("UGC", "C");
        rnaTable.put("UGA", "Stop");
        rnaTable.put("UGG", "W");

        rnaTable.put("CUU", "L");
        rnaTable.put("CUC", "L");
        rnaTable.put("CUA", "L");
        rnaTable.put("CUG", "L");
        rnaTable.put("CCU", "P");
        rnaTable.put("CCC", "P");
        rnaTable.put("CCA", "P");
        rnaTable.put("CCG", "P");
        rnaTable.put("CAU", "H");
        rnaTable.put("CAC", "H");
        rnaTable.put("CAA", "Q");
        rnaTable.put("CAG", "Q");
        rnaTable.put("CGU", "R");
        rnaTable.put("CGC", "R");
        rnaTable.put("CGA", "R");
        rnaTable.put("CGG", "R");

        rnaTable.put("AUU", "I");
        rnaTable.put("AUC", "I");
        rnaTable.put("AUA", "I");
        rnaTable.put("AUG", "M");
        rnaTable.put("ACU", "T");
        rnaTable.put("ACC", "T");
        rnaTable.put("ACA", "T");
        rnaTable.put("ACG", "T");
        rnaTable.put("AAU", "N");
        rnaTable.put("AAC", "N");
        rnaTable.put("AAA", "K");
        rnaTable.put("AAG", "K");
        rnaTable.put("AGU", "S");
        rnaTable.put("AGC", "S");
        rnaTable.put("AGA", "R");
        rnaTable.put("AGG", "R");

        rnaTable.put("GUU", "V");
        rnaTable.put("GUC", "V");
        rnaTable.put("GUA", "V");
        rnaTable.put("GUG", "V");
        rnaTable.put("GCU", "A");
        rnaTable.put("GCC", "A");
        rnaTable.put("GCA", "A");
        rnaTable.put("GCG", "A");
        rnaTable.put("GAU", "D");
        rnaTable.put("GAC", "D");
        rnaTable.put("GAA", "E");
        rnaTable.put("GAG", "E");
        rnaTable.put("GGU", "G");
        rnaTable.put("GGC", "G");
        rnaTable.put("GGA", "G");
        rnaTable.put("GGG", "G");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length() - 3; i = i + 3) {
            String rnaSubstr = data.substring(i, i + 3);
            String protSubstr = rnaTable.get(rnaSubstr);
            if (protSubstr.equals("Stop")) {
                break;
            }
            result.append(protSubstr);
        }

        System.out.println(result.toString());
    }
}
