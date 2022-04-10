package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.IntStream;

/*
Handles the first Rosalind task

Given:  A DNA string s of length at most 1000 nt.

Return: Four integers (separated by spaces) counting the respective number of times
        that the symbols 'A', 'C', 'G', and 'T' occur in s.
 */
public class CountingDnaNucleotides {

    public static String countNucleotides(String dna){
        IntStream dnaChars = dna.chars();

        long aNucleotideCount = dna.chars().filter(ch -> ch == 'A').count();
        long cNucleotideCount = dna.chars().filter(ch -> ch == 'C').count();
        long gNucleotideCount = dna.chars().filter(ch -> ch == 'G').count();
        long tNucleotideCount = dna.chars().filter(ch -> ch == 'T').count();

        return String.format("%d %d %d %d", aNucleotideCount, cNucleotideCount, gNucleotideCount, tNucleotideCount);
    }

    public static void main(String[] args) throws IOException {
        String dna = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_dna.txt")).get(0);
        String res = countNucleotides(dna);
        System.out.println(res);
    }
}
