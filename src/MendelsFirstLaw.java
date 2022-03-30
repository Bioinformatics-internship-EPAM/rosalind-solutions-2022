package testofbioinfo;

import java.util.Scanner;

//https://rosalind.info/problems/iprb/

//Given: Three positive integers k, m, and n, representing a population containing k+m+n organisms: k individuals are homozygous dominant for a factor, m are heterozygous, and n are homozygous recessive.
//Return: The probability that two randomly selected mating organisms will produce an individual possessing a dominant allele (and thus displaying the dominant phenotype). Assume that any two organisms can mate.

public class MendelsFirstLaw {
    public static void main(String[] args) {
        System.out.println("MendelsFristLaw");
        System.out.println("please enter numbers");
        Scanner s = new Scanner(System.in);
        double k =s.nextInt();
        double m = s.nextInt();
        double n = s.nextInt();
        System.out.println(mendel_first_law(k,m,n));
    }
    public static double mendel_first_law(double k,double m,double n){
        double t =k+m+n;
        return 1
                - m / t * (m - 1) / (t - 1) * 0.25
                - n / t * (n - 1) / (t - 1)
                - m / t * n / (t - 1);
    }
}
