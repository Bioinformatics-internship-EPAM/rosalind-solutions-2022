package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FindingAllSimilarMotifs {

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

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            String t = in.nextLine();
            String regex = "[ACGT]+";
            if (k>0 && Pattern.matches(regex, s) && Pattern.matches(regex, t)) {
                for (int i = 0; i < t.length(); i++)
                    for (int j = i + 1; j <= t.length(); j++) {
                        String str = t.substring(i, j);
                        if (editDistance(s, str) <= k) {
                            System.out.printf("%s %s\n", i, str.length());
                        }
                    }
            }
            else
                System.out.println("Not positive number or not DNA string was entered");
        }
        catch (InputMismatchException e) {
            System.err.println("Not integer number was entered");
        }
    }
}
