import java.io.IOException;

/**
 * FIB task solution: https://rosalind.info/problems/fib/
 *
 * Given: Positive integers n≤40 and k≤5.
 * 
 * Return: The total number of rabbit pairs that will be present after n months, if we begin with 1 pair and in each generation,
 *         every pair of reproduction-age rabbits produces a litter of k rabbit pairs (instead of only 1 pair).
 */

public class FIB {

    public static long FIBTask () throws IOException {
        var data = Utils.readFromFile("resources/rosalind_fib.txt").get(0);
        var splitData = data.split(" ");
        int months = Integer.parseInt(splitData[0]);
        int rabbitsProductivity = Integer.parseInt(splitData[1]);
        long parents = 1;
        long pairs = 1;
        long children = 0;
        if (months == 1 || months == 2) {
            return pairs;
        }
        else {
            for (int i=2; i < months; i++) {
                children = (parents * rabbitsProductivity) + pairs;
                parents = pairs;
                pairs = children;
            }
            return pairs;
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println(FIBTask());
    }
}
