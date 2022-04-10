package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
Given a DNA string t corresponding to a coding strand, its transcribed RNA string u is formed by replacing all
occurrences of 'T' in t with 'U' in u.

Given: A DNA string t having length at most 1000 nt.
Return: The transcribed RNA string of t.
 */
public class TranslatingDnaToRna {
    public static String translatedDnaToRna(String dna){

        return dna.chars().
                map(ch -> ch == 'T' ? 'U' : ch).
                mapToObj(ch -> (char) ch).
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                toString();
    }

    public static void main(String[] args) throws IOException {
        String dna = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_rna.txt")).get(0);
        String res = translatedDnaToRna(dna);
        System.out.println(res);
    }
}
