// Inferring mRNA from Protein
// https://rosalind.info/problems/mrna/

// Given: A protein string of length at most 1000 aa.
// Return: The total number of different RNA strings from which the protein could have been
// translated, modulo 1,000,000.
// (Don't neglect the importance of the stop codon in protein translation.)


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MRNA {

    public static int task() {
        String proteinStr = ReadFile.resFileToStringList("rosalind_mrna.txt").get(0);

        List<String> codons = ReadFile.resFileToStringList("info/RNA_codon_table.txt");
        Map<String, String> codonMap= new HashMap<>();
        codons.forEach(line -> {
            String[] pair = line.split(" ");
            codonMap.put(pair[0], pair[1]);
        });

        int rnaOptionsNum = 1;
        int codonsNum;
        String aminoAcid;
        while (!proteinStr.isEmpty()) {
            codonsNum = 0;
            aminoAcid = proteinStr.substring(0,1);
            for (Map.Entry entry : codonMap.entrySet()) {
                if (entry.getValue().equals(aminoAcid)) {
                    codonsNum += 1;
                }
            }

            rnaOptionsNum *= codonsNum;
            //cause result should be just remainder of division by 10^6
            rnaOptionsNum  = rnaOptionsNum % 1000000;
            proteinStr = proteinStr.substring(1);
        }
        rnaOptionsNum *= 3; //cause of 3 stop codons

        return rnaOptionsNum;
    }
}
