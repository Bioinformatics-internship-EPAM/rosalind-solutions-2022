package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MendelFirstLaw {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            if (k>0 && m>0 && n>0) {
                double[][] P = {{k * (k - 1), k * m, k * n}, {m * k, m * (m - 1), m * n}, {n * k, n * m, n * (n - 1)}};
                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        P[i][j] /= ((k + m + n) * (k + m + n - 1));
                double phmr = P[1][1] * 0.25 + P[1][2] * 0.5 + P[2][1] * 0.5 + P[2][2];
                double pht = P[0][1] * 0.5 + P[0][2] + P[1][0] * 0.5 + P[1][1] * 0.5 + P[1][2] * 0.5 + P[2][0] + P[2][1] * 0.5;
                double phmd = P[0][0] + P[0][1] * 0.5 + P[1][0] * 0.5 + P[1][1] * 0.25;
                System.out.println(pht + phmd);
            }
            else
                System.out.println("Not positive number was entered");
        }
        catch (InputMismatchException e) {
            System.err.println("Not integer number was entered");
        }
    }
}
