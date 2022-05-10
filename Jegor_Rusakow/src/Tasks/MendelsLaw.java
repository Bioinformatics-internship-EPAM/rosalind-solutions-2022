package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Given:  Three positive integers k, m, and n, representing a population containing k+m+n organisms: k individuals
        are homozygous dominant for a factor, m are heterozygous, and n are homozygous recessive.

Return: The probability that two randomly selected mating organisms will produce an individual possessing a dominant
        allele (and thus displaying the dominant phenotype). Assume that any two organisms can mate.
 */
public class MendelsLaw {

    public static double computeProbability(int k, int m, int n){
        // population
        int p = k + m + n;

        double probability = 0.;
        probability += (double) k / p;
        probability += (double) m / p * (
                        (double) k / (p - 1) +
                        (double) (m - 1) / (p - 1) * 0.75 +
                        (double) n / (p - 1) * 0.5
        );
        probability += (double) n / p * (
                        (double) k / (p - 1) +
                        (double) m / (p - 1) * 0.5
                );
        return probability;
    }

    public static void main(String[] args) throws IOException {
        String[] coeffs = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_iprb.txt")).get(0).split(" ");
        int k = Integer.parseInt(coeffs[0]);
        int m = Integer.parseInt(coeffs[1]);
        int n = Integer.parseInt(coeffs[2]);
        System.out.println(computeProbability(k, m, n));
    }

}
