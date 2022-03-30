import java.io.IOException;

/**
 * IPRB task solution: https://rosalind.info/problems/iprb/
 *
 * Given: Three positive integers k, m, and n, representing a population containing k+m+n organisms:
 *        k individuals are homozygous dominant for a factor, m are heterozygous, and n are homozygous recessive.
 * 
 * Return: The probability that two randomly selected mating organisms will produce an individual possessing a dominant allele
 *         (and thus displaying the dominant phenotype). Assume that any two organisms can mate.
 */

public class IPRB {

    public static double IPRBTask () throws IOException {
        var data = Utils.readFromFile("resources/rosalind_iprb.txt").get(0);
        var splitData = data.split(" ");
        int k = Integer.parseInt(splitData[0]);
        int m = Integer.parseInt(splitData[1]);
        int n = Integer.parseInt(splitData[2]);
        double total = k + m + n;
        double probBothDom = (k/total)*((k-1)/(total-1));
        double probBothHetero = (m/total)*((m-1)/(total-1));
        double probDomRec = ( (k/total)*(n/(total-1)) ) + ((n/total)*(k/(total-1)));
        double probDomHetero = ( (k/total)*(m/(total-1)) ) + ((m/total)*(k/(total-1)));
        double probHeteroRec = ( (m/total)*(n/(total-1)) ) + ((n/total)*(m/(total-1)));

        return probBothDom + probDomHetero + (probBothHetero * 0.75) + probDomRec + (probHeteroRec * 0.5);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(IPRBTask());
    }

}
