import java.util.Scanner;

public class GC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id = "";
        String maxId = "";
        float gcCount = 0;
        float length = 1;
        float max = 0;

        String input = scanner.nextLine();
        while (!input.equals("")) {
            if (input.startsWith(">")) {
                float percent = gcCount / length;
                if (max < percent) {
                    max = percent;
                    maxId = id;
                }
                id = input;
                gcCount = 0;
                length = 0;
            } else {
                length += input.length();
                gcCount += input.length() - input
                    .replaceAll("G", "")
                    .replaceAll("C", "")
                    .length();
            }
            input = scanner.nextLine();
        }
        float percent = gcCount / length;
        if (max < percent) {
            max = percent;
            maxId = id;
        }

        System.out.println(maxId.replace(">", "") + " " + max * 100 + "%");
    }
}
