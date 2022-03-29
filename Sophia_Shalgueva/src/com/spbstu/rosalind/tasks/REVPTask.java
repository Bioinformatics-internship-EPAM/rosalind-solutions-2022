package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.entity.REVPPair;
import com.spbstu.rosalind.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

import static com.spbstu.rosalind.utils.Constants.REVP_TASK_PATH;

/**
 * Given: A DNA string of length at most 1 kbp in FASTA format.
 * <p>
 * Return: The position and length of every reverse palindrome in the string having length between 4 and 12.
 * You may return these pairs in any order.
 */
public class REVPTask {
    private static final int MIN_PALINDROME_LENGTH = 4;
    private static final int MAX_PALINDROME_LENGTH = 12;

    public static List<REVPPair> collectAllPairs() {
        FASTA file = FileUtils.readFASTAFile(REVP_TASK_PATH).get(0);
        String dna = file.getContent();
        int dnaLength = dna.length();
        List<REVPPair> pairs = new ArrayList<>();
        for (int i = 0; i < dnaLength - 3; i++) {
            int endIndex = (i < dnaLength - MAX_PALINDROME_LENGTH) ? (MAX_PALINDROME_LENGTH + 1) : (dnaLength - i + 1);
            for (int j = MIN_PALINDROME_LENGTH; j < endIndex; j++) {
                String temp = dna.substring(i, i + j);
                if (temp.equals(ORFTask.findReversedComplementaryDna(temp))) {
                    pairs.add(new REVPPair(i + 1, j));
                }
            }
        }
        return pairs;
    }

}
