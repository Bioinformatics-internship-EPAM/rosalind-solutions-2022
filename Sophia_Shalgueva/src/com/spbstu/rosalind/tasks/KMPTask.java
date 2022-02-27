package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.utils.FileUtils;

import static com.spbstu.rosalind.utils.Constants.KMP_TASK_PATH;

/**
 * Given: A DNA string s (of length at most 100 kbp) in FASTA format.
 * <p>
 * Return: The failure array of s.
 */
public class KMPTask {
    public static int[] findFailureArray() {
        FASTA file = FileUtils.readFASTAFile(KMP_TASK_PATH).get(0);
        String dna = file.getContent();
        return countPrefixFunction(dna);
    }

    private static int[] countPrefixFunction(String dna) {
        int[] failureArray = new int[dna.length()];
        for (int i = 1; i < dna.length(); i++) {
            int j = failureArray[i - 1];
            while (j > 0 && dna.charAt(i) != dna.charAt(j)) {
                j = failureArray[j - 1];
            }
            if (dna.charAt(i) == dna.charAt(j)) {
                j++;
            }
            failureArray[i] = j;
        }
        return failureArray;
    }

}
