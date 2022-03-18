import java.util.Scanner;

public class SUBS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String mask = scanner.nextLine();
        int index = input.indexOf(mask);
        while (index >= 0) {
            System.out.print((index + 1) + " ");
            index = input.indexOf(mask, index + 1);
        }
    }
}
