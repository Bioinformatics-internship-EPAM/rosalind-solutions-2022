// Translating RNA into Protein
// https://rosalind.info/problems/prot/

// Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).
// Return: The protein string encoded by s.


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PROT {

    public static String task() {
        String rnaStr = ReadFile.resFileToStringList("rosalind_prot.txt").get(0);

        List<String> codons = ReadFile.resFileToStringList("info/RNA_codon_table.txt");
        Map<String, String> codonMap= new HashMap<>();
        codons.forEach(line -> {
            String[] pair = line.split(" ");
            codonMap.put(pair[0], pair[1]);
        });

        StringBuilder proteinStr = new StringBuilder();
        String value;
        while (!rnaStr.isEmpty()) {
            value = codonMap.get(rnaStr.substring(0, 3));
            if (!value.equals("Stop")) {
                proteinStr.append(value);
                rnaStr = rnaStr.substring(3);
            } else {
                break;
            }
        }

        return proteinStr.toString();
    }
}
