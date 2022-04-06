import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Subs - 
 * Link to Rosalind task: https://rosalind.info/problems/subs/
 * 
 * Task brief description:
 * Given two strings s and t, t is a substring of s if t is contained 
 * as a contiguous collection of symbols in s (as a result, t must be 
 * no longer than s).
 * 
 * The position of a symbol in a string is the total number of symbols 
 * found to its left, including itself (e.g., the positions of all 
 * occurrences of 'U' in "AUGCUUCAGAAAGGUCUUACG" are 2, 5, 6, 15, 17, and 18). 
 * The symbol at position i of s is denoted by s[i].
 * 
 * A substring of s can be represented as s[j:k], where j and k represent 
 * the starting and ending positions of the substring in s; for example, 
 * if s = "AUGCUUCAGAAAGGUCUUACG", then s[2:5] = "UGCU".
 * 
 * The location of a substring s[j:k] is its beginning position j; note 
 * that t will have multiple locations in s if it occurs more than once 
 * as a substring of s (see the Sample below).
 * 
 * Given: Two DNA strings s and t (each of length at most 1 kbp).
 * 
 * Return: All locations of t as a substring of s.
 */
public class Subs {

    static private String INPUT_FILE_NAME = "data/rosalind_subs.txt";

    public static void main(String[] args) {

        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String dnaStr = scanner.nextLine();
        String dnaSubStr = scanner.nextLine();

        List<Integer> subStrLoc = new ArrayList<Integer>();
        Integer searchPos = 0;

        while (dnaStr.indexOf(dnaSubStr, searchPos) != -1)
        {
            searchPos = dnaStr.indexOf(dnaSubStr, searchPos) + 1;
            subStrLoc.add(searchPos);
        }

        for (Integer val : subStrLoc)
        {
            System.out.printf("%d ", val);
        }
    }
}
