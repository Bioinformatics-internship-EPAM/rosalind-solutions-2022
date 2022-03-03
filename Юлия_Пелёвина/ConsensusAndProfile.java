package com.company;

import java.util.Scanner;

public class ConsensusAndProfile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] dnaStrings = str.split(" ");
        boolean isNotDNA = false;
        for (String string : dnaStrings)
            for (int j = 0; j < string.length(); j++)
                if (string.charAt(j) != 'A' && string.charAt(j) != 'C' && string.charAt(j) != 'G' && string.charAt(j) != 'T') {
                    isNotDNA = true;
                    break;
                }
        if (!isNotDNA) {
            boolean isNotEqualLength = false;
            for (int i=0; i<dnaStrings.length-1; i++)
                if (dnaStrings[i].length() != dnaStrings[i+1].length()) {
                    isNotEqualLength = true;
                    break;
                }
            if (!isNotEqualLength) {
                int[][] profile = new int[4][dnaStrings[0].length()];
                for (String dnaString : dnaStrings)
                    for (int j = 0; j < dnaString.length(); j++)
                        if (dnaString.charAt(j) == 'A')
                            profile[0][j] += 1;
                        else if (dnaString.charAt(j) == 'C')
                            profile[1][j] += 1;
                        else if (dnaString.charAt(j) == 'G')
                            profile[2][j] += 1;
                        else if (dnaString.charAt(j) == 'T')
                            profile[3][j] += 1;
                int[] maximums = new int[dnaStrings[0].length()];
                for (int i=0; i<dnaStrings[0].length(); i++) {
                    int max = profile[0][i];
                    int maxIndex = 0;
                    for (int j=1; j<profile.length; j++)
                        if (profile[j][i] > max) {
                            max = profile[j][i];
                            maxIndex = j;
                        }
                    maximums[i] = maxIndex;
                }
                StringBuilder consensus = new StringBuilder();
                for (int maximum : maximums)
                    if (maximum == 0)
                        consensus.append("A");
                    else if (maximum == 1)
                        consensus.append("C");
                    else if (maximum == 2)
                        consensus.append("G");
                    else if (maximum == 3)
                        consensus.append("T");
                System.out.println(consensus);
                for (int[] ints : profile) {
                    StringBuilder s = new StringBuilder();
                    for (int anInt : ints) s.append(anInt).append(" ");
                    System.out.println(s);
                }
            }
            else
                System.out.println("DNA strings have different length");
        }
        else
            System.out.println("DNA strings are wrong");
    }
}
