package com.company;

import java.util.Scanner;

public class SexLinkedInheritance {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String p = in.nextLine();
            String[] pa = p.split(" ");
            float[] A = new float[pa.length];
            for (int i = 0; i < A.length; i++)
                A[i] = Float.parseFloat(pa[i]);
            boolean isProbability = true;
            for (float value : A)
                if (value < 0 || value > 1) {
                    isProbability = false;
                    break;
                }
            if (isProbability) {
                float[] B = new float[A.length];
                for (int i = 0; i < B.length; i++)
                    B[i] = 2 * A[i] * (1 - A[i]);
                StringBuilder pr = new StringBuilder();
                for (float v : B) pr.append(v).append(" ");
                System.out.println(pr);
            }
            else
                System.out.println("Not probability was entered");
        }
        catch (NumberFormatException e) {
            System.err.println("Not number was entered");
        }
    }
}
