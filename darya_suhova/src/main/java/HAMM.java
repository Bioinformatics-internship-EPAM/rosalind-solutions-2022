import java.util.Scanner;

public class HAMM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s1 = scanner.nextLine().toCharArray();
        char[] s2 = scanner.nextLine().toCharArray();

        int cnt = 0;

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
