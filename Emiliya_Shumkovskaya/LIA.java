// https://rosalind.info/problems/lia/
//Given: Two positive integers k (k≤7) and N. In this problem, we begin with Tom, who in the 0th
// generation has genotype Aa Bb. Tom has two children in the 1st generation, each of whom has two
// children, and so on. Each organism always mates with an organism having genotype Aa Bb.
//Return: The probability that at least N Aa Bb organisms will belong to the k-th generation
// of Tom's family tree (don't count the Aa Bb mates at each level).
// Assume that Mendel's second law holds for the factors.

public class LIA {
    double countProp(int k, int N){
        //при скрещивании AaBb с любым генотипом потомок AaBb появится с вероятностью 25%
        double prop = 0;
        double children = Math.pow(2, k);
        for(int i = N; i<=children; i++){
            int binom = factorial(children)/(factorial(i)*factorial(children-i));
            prop += binom*Math.pow(0.25, i) * Math.pow(0.75, children-i);
        }
        return prop;
    }
    private static int factorial(double x){
        int result=1;
        for (int i = 1; i <= x; i++)
        {
            result *= i;
        }
        return  result;
    }
}
