import java.util.Scanner;

public class FIBD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = scanner.nextInt();
        int livePeriod = scanner.nextInt();
        long result = 0;

        long[] parents = new long[livePeriod];
        parents[0] = 1;

        for (int i = 1; i < months; i++) {
            long[] child = new long[livePeriod];
            for (int j = 1; j < livePeriod; j++) {
                child[j] = parents[j - 1];
                child[0] += parents[j];
            }
            for (int k = 0; k < livePeriod; k++) {
                parents[k] = child[k];
                if (i == months - 1) result += child[k];
            }
        }

        System.out.println(result);
    }
}