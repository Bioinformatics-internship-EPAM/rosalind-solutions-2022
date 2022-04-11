//https://rosalind.info/problems/fib/
//Given: Positive integers n≤40 and k≤5.
//Return: The total number of rabbit pairs that will be present after n months,
// if we begin with 1 pair and in each generation,
 //every pair of reproduction-age rabbits produces a litter of k rabbit pairs (instead of only 1 pair).

public class FIB {
    int reproduce(int n, int k) {
        if(n==1) {
            return 1;
        } else
        if(n==2) {
            return 1;
        } else {
            return reproduce(n-1, k) + reproduce(n-2, k) * k;
        }
    }
}
