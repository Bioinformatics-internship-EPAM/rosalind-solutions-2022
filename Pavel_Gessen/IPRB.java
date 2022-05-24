import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/iprb/

Problem

Probability is the mathematical study of randomly occurring phenomena. We will model such
a phenomenon with a random variable, which is simply a variable that can take a number of
different distinct outcomes depending on the result of an underlying random process.

For example, say that we have a bag containing 3 red balls and 2 blue balls. If we let X
represent the random variable corresponding to the color of a drawn ball, then the probability
of each of the two outcomes is given by Pr(X=red)=35 and Pr(X=blue)=25.

Random variables can be combined to yield new random variables. Returning to the ball example,
let Y model the color of a second ball drawn from the bag (without replacing the first ball).
The probability of Y being red depends on whether the first ball was red or blue. To represent
all outcomes of X and Y, we therefore use a probability tree diagram. This branching diagram
represents all possible individual probabilities for X and Y, with outcomes at the endpoints
("leaves") of the tree. The probability of any outcome is given by the product of probabilities
along the path from the beginning of the tree; see Figure 2 for an illustrative example.

An event is simply a collection of outcomes. Because outcomes are distinct, the probability of
an event can be written as the sum of the probabilities of its constituent outcomes. For our
colored ball example, let A be the event "Y is blue." Pr(A) is equal to the sum of the probabilities
of two different outcomes: Pr(X=blue and Y=blue)+Pr(X=red and Y=blue), or 310+110=25 (see Figure 2 above).

Given: Three positive integers k, m, and n, representing a population containing k+m+n organisms:
k individuals are homozygous dominant for a factor, m are heterozygous, and n are homozygous recessive.

Return: The probability that two randomly selected mating organisms will produce an individual possessing
a dominant allele (and thus displaying the dominant phenotype). Assume that any two organisms can mate.

Sample Dataset
2 2 2
Sample Output
0.78333
 */
 
public class IPRB {
    public static void main(String[] args) {
        String fileName = "data/rosalind_iprb.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        double total = k + m + n;
        double probDomDom = (k/total)*((k-1)/(total-1));
        double probHetHet = (m/total)*((m-1)/(total-1));
        double probDomHet = ( (k/total)*(m/(total-1)) ) + ((m/total)*(k/(total-1)));
        double probDomRec = ( (k/total)*(n/(total-1)) ) + ((n/total)*(k/(total-1)));
        double probHetRec = ( (m/total)*(n/(total-1)) ) + ((n/total)*(m/(total-1)));

        System.out.println(probDomDom + probDomHet + (probHetHet * 0.75) + probDomRec + (probHetRec * 0.5));
    }
}
