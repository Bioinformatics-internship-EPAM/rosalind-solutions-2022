import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/*
Link to Rosalind task: https://rosalind.info/problems/dna/

Problem
A string is simply an ordered collection of symbols selected from some alphabet
 and formed into a word; the length of a string is the number of symbols that it contains.

An example of a length 21 DNA string (whose alphabet contains the symbols 'A', 'C', 'G', and 'T')
 is "ATGCTTCAGAAAGGTCTTACG."

Given: A DNA string s of length at most 1000 nt.

Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s.

Sample Dataset
AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC
Sample Output
20 12 17 21
 */
 
public class DNA {
    public static void main(String[] args){
        String fileName = "data/rosalind_dna.txt";
        String data = null;
        try{
            Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            data = scanner.nextLine();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < data.length(); i++){
            map.merge(data.charAt(i), 1, Integer::sum);
        }

        System.out.println(map.get('A'));
        System.out.println(map.get('C'));
        System.out.println(map.get('G'));
        System.out.println(map.get('T'));
    }
}