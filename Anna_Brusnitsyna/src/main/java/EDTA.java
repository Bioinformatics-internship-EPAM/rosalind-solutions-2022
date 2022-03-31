import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// https://rosalind.info/problems/edta/
public class EDTA {
    private static int[][] distances;
    private static String[][][] strings;

    public static String solve(String inputPath) throws FileNotFoundException {
        File inputFile = new File(inputPath);
        Scanner sc = new Scanner(inputFile);
        sc.nextLine();
        String sequence1 = sc.nextLine();
        sc.nextLine();
        String sequence2 = sc.nextLine();
        calculateDistance(sequence1, sequence2);
        return distances[sequence1.length()][sequence2.length()] + "\n" +
                strings[sequence1.length()][sequence2.length()][0] + "\n" +
                strings[sequence1.length()][sequence2.length()][1];
    }

    private static void calculateDistance(String str1, String str2) {
        distances = new int[str1.length() + 1][str2.length() + 1];
        strings = new String[str1.length() + 1][str2.length() + 1][2];
        for (int idx1 = 0; idx1 <= str1.length(); idx1++) {
            distances[idx1][0] = idx1;
            strings[idx1][0][0] = str1.substring(0, idx1);
            char[] ch = new char[idx1];
            Arrays.fill(ch, '-');
            strings[idx1][0][1] = new String(ch);
        }
        for (int idx2 = 0; idx2 <= str2.length(); idx2++) {
            distances[0][idx2] = idx2;
            strings[0][idx2][1] = str2.substring(0, idx2);
            char[] ch = new char[idx2];
            Arrays.fill(ch, '-');
            strings[0][idx2][0] = new String(ch);
        }
        for (int idx1 = 1; idx1 <= str1.length(); idx1++) {
            for (int idx2 = 1; idx2 <= str2.length(); idx2++) {
                int cur = str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1) ? 0 : 1;
                if ((distances[idx1 - 1][idx2 - 1] + cur < distances[idx1 - 1][idx2] + 1) &&
                        (distances[idx1 - 1][idx2 - 1] + cur < distances[idx1][idx2 - 1] + 1)) {
                    // match/mismatch in strings
                    distances[idx1][idx2] = distances[idx1 - 1][idx2 - 1] + cur;
                    strings[idx1][idx2][0] = strings[idx1 - 1][idx2 - 1][0] + str1.charAt(idx1 - 1);
                    strings[idx1][idx2][1] = strings[idx1 - 1][idx2 - 1][1] + str2.charAt(idx2 - 1);
                } else if (distances[idx1 - 1][idx2] + 1 < distances[idx1][idx2 - 1] + 1) {
                    // gap in str2
                    distances[idx1][idx2] = distances[idx1 - 1][idx2] + 1;
                    strings[idx1][idx2][0] = strings[idx1 - 1][idx2][0] + str1.charAt(idx1 - 1);
                    strings[idx1][idx2][1] = strings[idx1 - 1][idx2][1] + '-';
                } else {
                    // gap in str1
                    distances[idx1][idx2] = distances[idx1][idx2 - 1] + 1;
                    strings[idx1][idx2][0] = strings[idx1][idx2 - 1][0] + '-';
                    strings[idx1][idx2][1] = strings[idx1][idx2 - 1][1] + str2.charAt(idx2 - 1);
                }
            }
        }
    }
}
