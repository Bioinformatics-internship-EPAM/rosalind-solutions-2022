import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/hamm/

Problem

Given two strings s and t of equal length, the Hamming distance between s and t, denoted dH(s,t),
is the number of corresponding symbols that differ in s and t.

Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).

Return: The Hamming distance dH(s,t).

Sample Dataset
GAGCCTACTAACGGGAT
CATCGTAATGACGGCCT
Sample Output
7
 */

public class HAMM {
    public static void main(String[] args) {
        String fileName = "data/rosalind_hamm.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String data1 = scanner.nextLine();
        String data2 = scanner.nextLine();

        int hammDist = 0;
        for (int i = 0; i < data1.length(); i++)
        {
            if (data1.charAt(i) != data2.charAt(i))
            {
                hammDist++;
            }
        }

        System.out.println(hammDist);
    }
}
