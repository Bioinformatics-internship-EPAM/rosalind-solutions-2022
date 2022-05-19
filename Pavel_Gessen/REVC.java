import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/revc/

Problem
In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.

The reverse complement of a DNA string s is the string sc formed by reversing the symbols
 of s, then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").

Given: A DNA string s of length at most 1000 bp.

Return: The reverse complement sc of s.

Sample Dataset
AAAACCCGGT
Sample Output
ACCGGGTTTT
 */
 
public class REVC {
    public static void main(String[] args) {
        String fileName = "data/rosalind_revc.txt";
        String data = null;
        try {
            Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            data = scanner.nextLine();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder result = new StringBuilder();
        for (char token : data.toCharArray()) {
            switch (token) {
                case 'A':
                    result.append('T');
                    break;
                case 'C':
                    result.append('G');
                    break;
                case 'G':
                    result.append('C');
                    break;
                case 'T':
                    result.append('A');
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }

        System.out.println(result.reverse().toString());
    }
}
