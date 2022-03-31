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
