import java.util.Scanner;

public class FIB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = scanner.nextInt();
        int monthlyOffsprings = scanner.nextInt();

        long parent = 1;
        long child = 1;

        for (int i = 0; i < months - 1; i++) {
            long tmp = child;
            child += parent * monthlyOffsprings;
            parent = tmp;
        }

        System.out.println(parent);
    }
}
