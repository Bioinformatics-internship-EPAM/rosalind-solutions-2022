import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/rna/

Problem
An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.

Given a DNA string t corresponding to a coding strand, its transcribed
RNA string u is formed by replacing all occurrences of 'T' in t with 'U' in u.

Given: A DNA string t having length at most 1000 nt.

Return: The transcribed RNA string of t.

Sample Dataset
GATGGAACTTGACTACGTAAATT
Sample Output
GAUGGAACUUGACUACGUAAAUU
 */
 
public class RNA {
    public static void main(String[] args) {
        String fileName = "data/rosalind_rna.txt";
        String data = null;
        try {
            Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            data = scanner.nextLine();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(data.replace('T', 'U'));
    }
}
