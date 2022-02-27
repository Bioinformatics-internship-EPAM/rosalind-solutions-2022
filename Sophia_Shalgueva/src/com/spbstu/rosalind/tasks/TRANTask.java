package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.utils.FileUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.spbstu.rosalind.utils.Constants.TRAN_TASK_PATH;

/**
 * Given: Two DNA strings s1 and s2 of equal length (at most 1 kbp).
 * <p>
 * Return: The transition/transversion ratio R(s1,s2).
 */
public class TRANTask {
    // A <-> G & C <-> T – Transitions
    // A <-> C & G <-> T – Transversions

    private static final int PRECISION = 11;

    public static Double transversionsKoeff() {
        List<FASTA> files = FileUtils.readFASTAFile(TRAN_TASK_PATH);
        String s1 = files.get(0).getContent();
        String s2 = files.get(1).getContent();
        int transitions = 0;
        int transversions = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (checkIfTransition(s1.charAt(i), s2.charAt(i))) {
                transitions++;
            }
            if (checkIfTransversion(s1.charAt(i), s2.charAt(i))) {
                transversions++;
            }
        }
        double koeff = (double)transitions / (double) transversions;
        return BigDecimal.valueOf(koeff)
                .setScale(PRECISION, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private static boolean checkIfTransition(Character s1, Character s2) {
        boolean isAGTransition = (s1 == 'A' && s2 == 'G' || s1 == 'G' && s2 == 'A');
        boolean isCTTransition = (s1 == 'C' && s2 == 'T' || s1 == 'T' && s2 == 'C');
        return isAGTransition || isCTTransition;
    }

    private static boolean checkIfTransversion(Character s1, Character s2) {
        boolean isACTransversion = (s1 == 'A' && s2 == 'C' || s1 == 'C' && s2 == 'A');
        boolean isGTTransversion = (s1 == 'G' && s2 == 'T' || s1 == 'T' && s2 == 'G');
        boolean isGCTransversion = (s1 == 'G' && s2 == 'C' || s1 == 'C' && s2 == 'G');
        boolean isATTransversion = (s1 == 'A' && s2 == 'T' || s1 == 'T' && s2 == 'A');
        return isACTransversion || isGTTransversion || isATTransversion || isGCTransversion;
    }
}
