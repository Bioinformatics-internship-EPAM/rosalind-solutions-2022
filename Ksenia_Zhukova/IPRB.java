// Mendel's First Law
// https://rosalind.info/problems/iprb/

// Given: Three positive integers k, m, and n, representing a population containing
// k+m+n organisms - k individuals are homozygous dominant for a factor, m are heterozygous,
// and n are homozygous recessive.

// Return: The probability that two randomly selected mating organisms will produce
// an individual possessing a dominant allele (and thus displaying the dominant phenotype).
// Assume that any two organisms can mate.


public class IPRB {

    public static double task() {
        String[] values = ReadFile.resFileToStringList("rosalind_iprb.txt").get(0).split(" ");
        int k = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);
        int n = Integer.parseInt(values[2]);

        double all = k + m + n;
        double probDD = (k / all) * ((k - 1) / (all - 1)); //prob to get dominant in this case = 1
        double probDH = (k / all) * (m / (all - 1)) + (m / all) * (k / (all - 1)); //prob in this case = 1
        double probDR = (k / all) * (n / (all - 1)) + (n / all) * (k / (all - 1)); //prob in this case = 1
        double probHH = (m / all) * ((m - 1) / (all - 1)); //prob in this case = 0.75
        double probHR = (m / all) * (n / (all - 1)) + (n / all) * (m / (all - 1)); //prob in this case = 0.5

        return probDD + probDH + probDR + probHH * 0.75 + probHR * 0.5;
    }
}
