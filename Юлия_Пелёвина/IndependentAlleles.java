package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IndependentAlleles {

    public static int factorial(int a) {
        if (a==0 || a==1)
            return 1;
        else
            return a*factorial(a-1);
    }

    public static int combination(int a, int b) {
        return factorial(a)/(factorial(a-b)*factorial(b));
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            int N = in.nextInt();
            if (k>0 && N>0 && N<=(int)Math.pow(2,k)) {
                int n = (int) Math.pow(2, k);
                double[] arr = new double[(int) Math.pow(2, k)];
                Arrays.fill(arr, 0.25);
                double probability = 0.;
                int index = 0;
                while (n >= N) {
                    double p = 1.;
                    for (double v : arr) p *= v;
                    probability += p * combination(arr.length, n);
                    arr[index] = 0.75;
                    index += 1;
                    n -= 1;
                }
                System.out.println(probability);
            }
            else
                System.out.println("Not positive number or too large second number was entered");
        }
        catch (InputMismatchException e) {
            System.err.println("Not integer number was entered");
        }
    }
}
