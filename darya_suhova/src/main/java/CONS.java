import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Scanner;

public class CONS {
    private static Map<Character, Integer> map = ImmutableMap.of(
        'A', 0,
        'C', 1,
        'G', 2,
        'T', 3
    );
    private static String[] dict = new String[]{"A", "C", "G", "T"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        int[][] result = new int[4][1000];
        String input = scanner.nextLine();

        while (!input.equals("")) {
            input = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            while (!input.startsWith(">") && !input.equals("")) {
                builder.append(input);
                input = scanner.nextLine();
            }
            char[] seq = builder.toString().toCharArray();
            cnt = seq.length;
            for (int i = 0; i < cnt; i++) {
                result[map.get(seq[i])][i]++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            int max = -1;
            String maxSym = "";
            for (int j = 0; j < 4; j++) {
                if (result[j][i] > max) {
                    max = result[j][i];
                    maxSym = dict[j];
                }
            }
            builder.append(maxSym);
        }
        System.out.println(builder.toString());
        for (int i = 0; i < 4; i++) {
            System.out.print(dict[i] + ": ");
            for (int j = 0; j < cnt; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
