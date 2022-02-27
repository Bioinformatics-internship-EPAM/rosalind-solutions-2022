package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.utils.FileUtils;

import java.util.List;

import static com.spbstu.rosalind.utils.Constants.GC_TASK_PATH;

/**
 * Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).
 * <p>
 * Return: The ID of the string having the highest GC-content, followed by the GC-content of that string.
 * Rosalind allows for a default error of 0.001 in all decimal answers unless otherwise stated;
 * please see the note on absolute error below.
 */
public class GCTask {

    public static List<String> countHighestGCContent() {
        List<FASTA> files = FileUtils.readFASTAFile(GC_TASK_PATH);
        String header = "";
        double maxIndex = 0.0;
        for (FASTA file : files) {
            long count = file.getContent().chars().filter(ch -> ch == 'C' || ch == 'G').count();
            double index = (double) count / (double) file.getContent().length();
            if (index > maxIndex) {
                header = file.getLabel();
                maxIndex = index;
            }
        }
        return List.of(header, Double.toString(maxIndex * 100));
    }


}
