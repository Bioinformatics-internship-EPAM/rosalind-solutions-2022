import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/fibd/

Problem

Recall the definition of the Fibonacci numbers from “Rabbits and Recurrence Relations”,
which followed the recurrence relation Fn=Fn−1+Fn−2 and assumed that each pair of rabbits
reaches maturity in one month and produces a single pair of offspring (one male, one female)
each subsequent month.

Our aim is to somehow modify this recurrence relation to achieve a dynamic programming
solution in the case that all rabbits die out after a fixed number of months.

Given: Positive integers n≤100 and m≤20.

Return: The total number of pairs of rabbits that will remain after the n-th month if
all rabbits live for m months.

Sample Dataset
6 3
Sample Output
4
 */
 
public class FIBD {
    public static void main(String[] args) {
        String fileName = "data/rosalind_fibd.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger parents = BigInteger.ZERO;
        BigInteger children = BigInteger.ONE;
        BigInteger reproduction = BigInteger.ONE;
        BigInteger babies;
        Queue<BigInteger> deaths = new LinkedList<>();

        for (int i = 1; i < n; i++){
            deaths.add(children);
            babies = parents.multiply(reproduction);
            parents = parents.add(children);
            if (i >= m){
                parents = parents.subtract(deaths.poll());
            }
            children = babies;
        }
        System.out.println(parents.add(children));
    }
}
