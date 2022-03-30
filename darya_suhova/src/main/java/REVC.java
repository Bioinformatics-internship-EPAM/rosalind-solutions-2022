import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Scanner;

public class REVC {
    public static void main(String[] args) {
        Map<Character, Character> map = ImmutableMap.of(
            'T', 'A',
            'A', 'T',
            'C', 'G',
            'G', 'C');

        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        char[] resultArr = new char[input.length];

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                resultArr[input.length - 1 - i] = map.get(input[i]);
            }
        }

        String result = String.valueOf(resultArr);
        System.out.println(result);
    }
}
