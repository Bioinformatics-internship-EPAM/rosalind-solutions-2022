import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/subs/

Problem
Given two strings s and t, t is a substring of s if t is contained as a
contiguous collection of symbols in s (as a result, t must be no longer than s).

The position of a symbol in a string is the total number of symbols found to
its left, including itself (e.g., the positions of all occurrences of 'U' in
"AUGCUUCAGAAAGGUCUUACG" are 2, 5, 6, 15, 17, and 18). The symbol at position i
of s is denoted by s[i].

A substring of s can be represented as s[j:k], where j and k represent the
starting and ending positions of the substring in s; for example, if
s = "AUGCUUCAGAAAGGUCUUACG", then s[2:5] = "UGCU".

The location of a substring s[j:k] is its beginning position j; note that
t will have multiple locations in s if it occurs more than once as a substring
of s (see the Sample below).

Given: Two DNA strings s and t (each of length at most 1 kbp).

Return: All locations of t as a substring of s.

Sample Dataset
GATATATGCATATACTT
ATAT
Sample Output
2 4 10
 */

public class SUBS {
    public static void main(String[] args) {
        String fileName = "data/rosalind_subs.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String data1 = scanner.nextLine();
        String data2 = scanner.nextLine();

        if (data1.length() < data2.length()) {
            System.out.println("Error");
        }

        List<Integer> result = new ArrayList<>();
        Integer searchPos = 0;

        while (data1.indexOf(data2, searchPos) != -1)
        {
            searchPos = data1.indexOf(data2, searchPos) + 1;
            result.add(searchPos);
        }

        for (Integer val : result)
        {
            System.out.printf("%d ", val);
        }
    }
}
