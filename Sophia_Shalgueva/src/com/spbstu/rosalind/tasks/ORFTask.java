package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.utils.FileUtils;

import java.util.*;

import static com.spbstu.rosalind.utils.Constants.*;

/**
 * Given: A DNA string ss of length at most 1 kbp in FASTA format.
 * <p>
 * Return: Every distinct candidate protein string that can be translated from ORFs of ss.
 * Strings can be returned in any order.
 */
public class ORFTask {
    private final static String START_CODON = "AUG";
    private final static String STOP_CODON_SIGN = "Stop";

    public static Set<String> readODFs() {
        FASTA file = FileUtils.readFASTAFile(ORF_TASK_PATH).get(0);
        String initialDna = file.getContent();
        String complementaryDna = findReversedComplementaryDna(initialDna);
        String initialRna = convertToRNA(initialDna);
        String complementaryRna = convertToRNA(complementaryDna);

        Map<String, String> aminosMap = FileUtils.readAminosTableFile(AMINOS_FILE_PATH);
        List<String> odfFromInitialRna = findAllCandidates(initialRna, aminosMap);
        List<String> odfFromComplRna = findAllCandidates(complementaryRna, aminosMap);
        Set<String> resultODFs = new HashSet<>();
        resultODFs.addAll(odfFromInitialRna);
        resultODFs.addAll(odfFromComplRna);
        return resultODFs;
    }

    static String findReversedComplementaryDna(String dna) {
        StringBuilder complementedDna = new StringBuilder();
        for (char c : dna.toCharArray()) {
            switch (c) {
                case 'A':
                    complementedDna.append('T');
                    break;
                case 'T':
                    complementedDna.append('A');
                    break;
                case 'C':
                    complementedDna.append('G');
                    break;
                case 'G':
                    complementedDna.append('C');
                    break;
            }
        }
        return complementedDna.reverse().toString();
    }

    private static String convertToRNA(String dna) {
        return dna.replaceAll("T", "U");
    }

    private static List<String> findAllCandidates(String rna, Map<String, String> aminosTable) {
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < rna.length() - CODON_LENGTH; i++) {
            if (rna.substring(i, i + CODON_LENGTH).equals(START_CODON)) {
                candidates.add(findFirstStopCodon(rna.substring(i), aminosTable));
            }
        }
        return candidates;
    }

    private static String findFirstStopCodon(String rna, Map<String, String> aminosTable) {
        String ribRNA = "";
        for (int i = CODON_LENGTH; i < rna.length() - CODON_LENGTH; i += CODON_LENGTH) {
            String currCodon = rna.substring(i, i + CODON_LENGTH);
            if (aminosTable.get(currCodon).equals(STOP_CODON_SIGN)) {
                ribRNA = rna.substring(0, i + CODON_LENGTH);
                break;
            }
        }

        StringBuilder currProtein = new StringBuilder();
        if (ribRNA.length() > 0) {
            for (int i = 0; i < ribRNA.length() - CODON_LENGTH; i += CODON_LENGTH) {
                currProtein.append(aminosTable.get(ribRNA.substring(i, i + CODON_LENGTH)));
            }
        }
        return currProtein.toString();
    }

}
