// https://rosalind.info/problems/lia/
public class LIA {
    private static int getBinomialCoef(int n, int k) {
        int[] C = new int[k + 1];
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }

    public static double solve(int generation, int minNumOfOrganisms) throws Exception {
        double prob = 0.25; // probability of AaBb with any mate is 0.25
        int generationSize = (int) Math.pow(2, generation);

        if (generation < 0 || generation > 7) {
            throw new Exception("k should not be bigger than 0 and less than 8: k=" + generation);
        }
        if (minNumOfOrganisms < 0 || minNumOfOrganisms > generationSize) {
            throw new Exception("N should not be bigger than 2**k: N=" + minNumOfOrganisms);
        }

        double probability = 0.0;
        for (int i = 0; i < minNumOfOrganisms; i++) {
            probability += getBinomialCoef(generationSize, i) *
                    Math.pow(prob, i) *
                    Math.pow(1 - prob, generationSize - i);
        }
        return 1 - probability;
    }
}
