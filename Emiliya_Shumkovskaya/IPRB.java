// https://rosalind.info/problems/iprb/
//Given: Three positive integers k, m, and n, representing a population containing k+m+n organisms:
// k individuals are homozygous dominant for a factor, m are heterozygous, and n are homozygous recessive.
//Return: The probability that two randomly selected mating organisms will produce an individual possessing
// a dominant allele (and thus displaying the dominant phenotype). Assume that any two organisms can mat

public class IPRB {
    public double countDominantProperty(int k, int m, int n) {
        double sum = k + m + n;
        double prop = k / sum;
        prop += m / sum * k / (sum-1);
        prop += 0.75 * m / sum * (m-1) / (sum-1);
        prop += 0.5 * m / sum * n / (sum-1);
        prop += n / sum * k / (sum-1);
        prop += 0.5 * n / sum * m / (sum-1);
        return prop;
    }
}
