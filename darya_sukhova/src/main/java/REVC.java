import java.util.Scanner;

public class REVC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = new StringBuilder(input)
            .reverse().toString()
            .replaceAll("T", "a")
            .replaceAll("A", "t")
            .replaceAll("C", "g")
            .replaceAll("G", "c")
            .toUpperCase();

        System.out.println(result);
    }
}
