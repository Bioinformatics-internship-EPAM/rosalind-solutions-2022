import java.util.Scanner;

public class IPRB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        float sum = k + m + n;
        float res = (float) (((k / sum) * (k - 1 + m + n)
                            + (m / sum) * (k + (m - 1) * 0.75 + n * 0.5)
                            + (n / sum) * (k + m * 0.5))
                            / (sum - 1));
        System.out.println(res);
    }
}
