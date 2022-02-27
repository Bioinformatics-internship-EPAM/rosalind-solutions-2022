package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.utils.FileUtils;

import java.util.List;

import static com.spbstu.rosalind.utils.Constants.SPLC_TASK_PATH;

/**
 * Given: A DNA string s (of length at most 1 kbp) and a collection of substrings of s acting as introns.
 * All strings are given in FASTA format.
 * <p>
 * Return: A protein string resulting from transcribing and translating the exons of s.
 * (Note: Only one solution will exist for the dataset provided.)
 */
public class SPLCTask {

    public static String transcribeAndTranslate() {
        List<FASTA> files = FileUtils.readFASTAFile(SPLC_TASK_PATH);
        FASTA dna = files.get(0);
        String dnaContent = dna.getContent();
        for (int i = 1; i < files.size(); i++) {
            dnaContent = dnaContent.replaceAll(files.get(i).getContent(), "");
        }
        String rna = convertToRNA(dnaContent);
        return PROTTask.buildProteinString(rna);
    }

    private static String convertToRNA(String dna) {
        return dna.replaceAll("T", "U");
    }
}
