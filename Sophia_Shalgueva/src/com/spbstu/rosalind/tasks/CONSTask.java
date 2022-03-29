package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.utils.FileUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.spbstu.rosalind.utils.Constants.CONS_TASK_PATH;

/**
 * Given: A collection of at most 10 DNA strings of equal length (at most 1 kbp) in FASTA format.
 * <p>
 * Return: A consensus string and profile matrix for the collection.
 * (If several possible consensus strings exist, then you may return any one of them.)
 */
public class CONSTask {
    private static final int PROFILE_ROWS = 4;
    private static final int A_ROW = 0;
    private static final int C_ROW = 1;
    private static final int G_ROW = 2;
    private static final int T_ROW = 3;

    public static void createProfileAndConsensus() {
        List<FASTA> files = FileUtils.readFASTAFile(CONS_TASK_PATH);
        int[][] profileMatrix = buildProfileMatrix(files);
        String consensus = buildConsensusString(profileMatrix);
        System.out.println(consensus);
        printProfileMatrix(profileMatrix);
    }

    private static int[][] buildProfileMatrix(List<FASTA> files) {
        int profileSize = files.size();
        String[] content = files.stream().map(FASTA::getContent).collect(Collectors.toList()).toArray(new String[]{});
        int profilerColumns = content[0].length();
        int[][] profileMatrix = new int[PROFILE_ROWS][profilerColumns];
        for (int i = 0; i < profilerColumns; i++) {
            for (int j = 0; j < profileSize; j++) {
                char currentChar = content[j].charAt(i);
                switch (currentChar) {
                    case 'A':
                        profileMatrix[A_ROW][i]++;
                        break;
                    case 'C':
                        profileMatrix[C_ROW][i]++;
                        break;
                    case 'G':
                        profileMatrix[G_ROW][i]++;
                        break;
                    case 'T':
                        profileMatrix[T_ROW][i]++;
                        break;
                }
            }
        }

        return profileMatrix;
    }

    private static String buildConsensusString(int[][] profileMatrix) {
        StringBuilder consensus = new StringBuilder();
        for (int i = 0; i < profileMatrix[0].length; i++) {
            char dominantSymbol = findDominantGen(profileMatrix[A_ROW][i], profileMatrix[C_ROW][i],
                    profileMatrix[G_ROW][i], profileMatrix[T_ROW][i]);
            consensus.append(dominantSymbol);
        }
        return consensus.toString();
    }

    private static char findDominantGen(int A, int C, int G, int T) {
        if (A > C && A > G && A > T) {
            return 'A';
        } else if (C > G && C > T) {
            return 'C';
        } else if (G > T) {
            return 'G';
        } else {
            return 'T';
        }
    }

    private static void printProfileMatrix(int[][] matrix) {
        for (int i = 0; i < PROFILE_ROWS; i++) {
            if (i == A_ROW) {
                System.out.print("A: ");
            }
            if (i == C_ROW) {
                System.out.print("C: ");
            }
            if (i == G_ROW) {
                System.out.print("G: ");
            }
            if (i == T_ROW) {
                System.out.print("T: ");
            }
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
