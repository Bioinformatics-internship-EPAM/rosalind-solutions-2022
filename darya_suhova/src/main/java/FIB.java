import java.util.Scanner;

public class FIB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = scanner.nextInt();
        int offsprings = scanner.nextInt();

        long parent = 1;
        long child = 1;

        for (int i = 0; i < months - 1; i++) {
            long tmp = parent;
            parent += child * offsprings;
            child = tmp;
        }

        System.out.println(child);
    }
}
