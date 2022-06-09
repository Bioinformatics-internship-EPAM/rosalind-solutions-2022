package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Given:  Positive integers n≤40 and k≤5.
Return: The total number of rabbit pairs that will be present after n months, if we begin with 1 pair and in each
        generation, every pair of reproduction-age rabbits produces a litter of k rabbit pairs (instead of only 1 pair).
 */
public class FibonacciRabbits {

    public static long countRabbits(int n, int k){
        long newbornRabbits;
        long babyRabbits = 1;
        long matureRabbits = 0;

        for (int i = 1; i < n; i ++){
            newbornRabbits = matureRabbits * k;
            matureRabbits = matureRabbits + babyRabbits;
            babyRabbits = newbornRabbits;
        }

        return babyRabbits + matureRabbits;
    }

    public static void main(String[] args) throws IOException {
        String[] arguments = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_fib.txt")).get(0).split(" ");
        int n = Integer.parseInt(arguments[0]);
        int k = Integer.parseInt(arguments[1]);
        System.out.println(countRabbits(n, k));
    }

}
