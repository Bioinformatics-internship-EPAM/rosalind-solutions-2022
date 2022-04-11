import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.min;

// https://rosalind.info/problems/edit/
public class EDIT {
    public static int solve(String inputPath) throws FileNotFoundException {
        File inputFile = new File(inputPath);
        Scanner sc = new Scanner(inputFile);
        sc.nextLine();
        String sequence1 = sc.nextLine();
        sc.nextLine();
        String sequence2 = sc.nextLine();
        int dist = calculateDistance(sequence1, sequence2);
        return dist;
    }

    private static int calculateDistance(String str1, String str2) {
        int[][] distances = new int[str1.length() + 1][str2.length() + 1];
        for (int idx1 = 0; idx1 <= str1.length(); idx1++) {
            distances[idx1][0] = idx1;
        }
        for (int idx2 = 0; idx2 <= str2.length(); idx2++) {
            distances[0][idx2] = idx2;
        }
        for (int idx1 = 1; idx1 <= str1.length(); idx1++) {
            for (int idx2 = 1; idx2 <= str2.length(); idx2++) {
                int cur = str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1) ? 0 : 1;
                distances[idx1][idx2] = min(
                        min(
                                distances[idx1 - 1][idx2] + 1,  // gap in str2
                                distances[idx1][idx2 - 1] + 1   // gap in str1
                        ),
                        distances[idx1 - 1][idx2 - 1] + cur     // match/mismatch in strings
                );
            }
        }
        return distances[str1.length()][str2.length()];
    }
}
