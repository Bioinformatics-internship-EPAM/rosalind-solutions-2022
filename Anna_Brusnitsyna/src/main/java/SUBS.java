import java.util.ArrayList;
import java.util.List;

// https://rosalind.info/problems/subs/
public class SUBS {
    public static ArrayList<Integer> solve(String dnaString, String pattern) throws Exception {
        if (dnaString.length() < pattern.length()) {
            throw new Exception("Pattern string is longer than DNA string");
        }

        ArrayList<Integer> subsIdx = new ArrayList<>();

        ArrayList<Integer> prefix = getPrefix(pattern);
        int patternIdx = 0;
        for (int i = 0; i < dnaString.length(); i++) {
            while ((patternIdx > 0) && (dnaString.charAt(i) != pattern.charAt(patternIdx))) {
                patternIdx = prefix.get(patternIdx - 1);
            }
            if (dnaString.charAt(i) == pattern.charAt(patternIdx)) {
                patternIdx++;
            }
            if (patternIdx == pattern.length()) {
                subsIdx.add(i - pattern.length() + 2);
                patternIdx = prefix.get(patternIdx - 1);;
            }
        }
        return subsIdx;
    }

    public static ArrayList<Integer> getPrefix(String str) {
        ArrayList<Integer> prefix = new ArrayList<>(List.of(0));
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while ((j > 0) && (str.charAt(j) != str.charAt(i))) {
                j = prefix.get(j - 1);
            }
            if (str.charAt(j) == str.charAt(i)) {
                j++;
            }
            prefix.add(j);
        }
        return prefix;
    }
}
