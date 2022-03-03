package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MultipleAlignment {

    public static int editDistance(String s, String st) {
        int[][] matr = new int[s.length()+1][st.length()+1];
        matr[0][0] = 0;
        for (int i=1; i<matr.length; i++)
            matr[i][0] = i;
        for (int i=1; i<matr[0].length; i++)
            matr[0][i] = i;
        for (int i=1; i<matr.length; i++)
            for (int j=1; j<matr[i].length; j++)
                matr[i][j] = Math.min(Math.min(matr[i][j-1]+1, matr[i-1][j]+1), matr[i-1][j-1]+((s.charAt(i-1)==st.charAt(j-1))?0:1));
        return matr[s.length()][st.length()];
    }

    public static boolean isSortedAndUnique(int[] a) {
        for (int i=0; i<a.length-1; i++)
            if (a[i] >= a[i+1])
                return false;
        return true;
    }

    public static int findMax(int[] a) {
        int max = a[0];
        for (int i=1; i<a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 4;
        String[] dnaStrings = new String[n];
        for (int i=0; i<n; i++)
            dnaStrings[i] = in.nextLine();
        boolean isNotDNA = false;
        for (String string : dnaStrings)
            for (int j = 0; j < string.length(); j++)
                if (string.charAt(j) != 'A' && string.charAt(j) != 'C' && string.charAt(j) != 'G' && string.charAt(j) != 'T') {
                    isNotDNA = true;
                    break;
                }
        if (!isNotDNA) {
            int maxLen = dnaStrings[0].length();
            for (int i = 1; i < dnaStrings.length; i++)
                if (dnaStrings[i].length() > maxLen)
                    maxLen = dnaStrings[i].length();
            ArrayList<String>[] lists = new ArrayList[n];
            for (int i = 0; i < n; i++)
                lists[i] = new ArrayList<String>();
            String baseString = "";
            for (String dnaString : dnaStrings)
                if (dnaString.length() == maxLen) {
                    baseString = dnaString;
                    break;
                }
            for (int i = 0; i < dnaStrings.length; i++) {
                if (dnaStrings[i].length() != maxLen) {
                    int[] seq = new int[(int) Math.pow(maxLen, maxLen - dnaStrings[i].length())];
                    for (int j = 0; j < seq.length; j++)
                        seq[j] = j;
                    int[][] iWords = new int[seq.length][maxLen - dnaStrings[i].length()];
                    for (int k = 0; k < iWords.length; k++) {
                        int p = maxLen - dnaStrings[i].length() - 1;
                        int m = seq[k];
                        for (int j = 0; j < iWords[k].length; j++) {
                            iWords[k][j] = m / (int) Math.pow(maxLen, p);
                            m %= (int) Math.pow(maxLen, p);
                            p -= 1;
                        }
                    }
                    ArrayList<int[]> arrayList = new ArrayList<>();
                    for (int[] iWord : iWords)
                        if (isSortedAndUnique(iWord))
                            arrayList.add(iWord);
                    char[][] recepients = new char[arrayList.size()][baseString.length()];
                    for (int j = 0; j < recepients.length; j++)
                        recepients[j] = baseString.toCharArray();
                    for (int j = 0; j < recepients.length; j++) {
                        int countGap = 0;
                        int countSymbols = 0;
                        for (int k = 0; k < recepients[j].length; k++)
                            if (k == arrayList.get(j)[countGap]) {
                                recepients[j][k] = '-';
                                if (countGap < arrayList.get(j).length - 1)
                                    countGap += 1;
                            } else {
                                recepients[j][k] = dnaStrings[i].toCharArray()[countSymbols];
                                if (countSymbols < dnaStrings[i].length() - 1)
                                    countSymbols += 1;
                            }
                    }
                    for (char[] recepient : recepients) lists[i].add(String.valueOf(recepient));
                } else
                    lists[i].add(dnaStrings[i]);
            }
            int productLength = 1;
            for (ArrayList<String> list : lists) productLength *= list.size();
            int[][] cartesian = new int[productLength][dnaStrings.length];
            for (int i=0; i<dnaStrings.length; i++)
                cartesian[0][i] = 0;
            for (int i=1; i<cartesian.length; i++) {
                boolean[] wasPlus = new boolean[cartesian[i].length-1];
                Arrays.fill(wasPlus, false);
                cartesian[i][cartesian[i].length-1] = cartesian[i-1][cartesian[i-1].length-1] + 1;
                if (cartesian[i][cartesian[i].length-1] == lists[cartesian[i].length-1].size()) {
                    cartesian[i][cartesian[i].length-1] = 0;
                    cartesian[i][cartesian[i].length-2] = cartesian[i-1][cartesian[i-1].length-2] + 1;
                    wasPlus[wasPlus.length-1] = true;
                    for (int j=cartesian[i].length-2; j>0; j--)
                        if (cartesian[i][j] == lists[j].size()) {
                            cartesian[i][j] = 0;
                            cartesian[i][j-1] = cartesian[i-1][j-1] + 1;
                            wasPlus[j-1] = true;
                        }
                }
                for (int j=cartesian[i].length-2; j>=0; j--)
                    if (!wasPlus[j])
                        cartesian[i][j] = cartesian[i-1][j];
            }
            String[][] alignments = new String[productLength][dnaStrings.length];
            for (int i = 0; i < alignments.length; i++)
                for (int j = 0; j < alignments[i].length; j++)
                    alignments[i][j] = lists[j].get(cartesian[i][j]);
            int[] scores = new int[alignments.length];
            for (int i = 0; i < alignments.length; i++) {
                int s = 0;
                for (int j = 0; j < alignments[i].length; j++)
                    for (int k = j + 1; k < alignments[i].length; k++)
                        s -= editDistance(alignments[i][j], alignments[i][k]);
                scores[i] = s;
            }
            int max = findMax(scores);
            System.out.println(max);
            int maxIndex = 0;
            for (int i=0; i<alignments.length; i++)
                if (scores[i] == max)
                    maxIndex = i;
            for (int i=0; i<alignments[0].length; i++)
                System.out.println(alignments[maxIndex][i]);
        }
        else
            System.out.println("DNA strings are wrong");
    }
}
