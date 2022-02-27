package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.utils.FileUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.spbstu.rosalind.utils.Constants.PROB_TASK_PATH;

/**
 * Given: A DNA string s of length at most 100 bp and an array A containing at most 20 numbers between 0 and 1.
 * <p>
 * Return: An array B having the same length as A in which B[k] represents the common logarithm of the probability
 * that a random string constructed with the GC-content found in A[k] will match s exactly.
 */
public class PROBTask {
    private static final int PRECISION = 3;

    public static double[] findProbability() {
        List<String> lines = FileUtils.readLines(PROB_TASK_PATH);
        String dna = lines.get(0);
        double[] gcContents = Arrays.stream(lines.get(1).split(" ")).mapToDouble(Double::valueOf).toArray();
        long amountOfAT = dna.chars().filter(c -> c == 'A' || c == 'T').count();
        long amountOfGC = dna.chars().filter(c -> c == 'C' || c == 'G').count();
        List<Double> resultedLogs = new ArrayList<>(gcContents.length);
        for (double content : gcContents) {
            double probability = amountOfGC * Math.log10(content / 2) + amountOfAT * Math.log10((1 - content) / 2);
            resultedLogs.add(probability);
        }
        return Arrays.stream(resultedLogs.toArray(new Double[0])).mapToDouble(d -> BigDecimal.valueOf(d)
                .setScale(PRECISION, RoundingMode.HALF_UP)
                .doubleValue()).toArray();
    }
}
