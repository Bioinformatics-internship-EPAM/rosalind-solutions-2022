package testofbioinfo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://rosalind.info/problems/dna/

//Given: A DNA string s of length at most 1000 nt.
//Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s.

public class DnaNucleotidesCounter {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\DNA.txt"),
                StandardCharsets.UTF_8);
        String dna = lines.get(0);
        System.out.println("Dna Nucleotides Counter");
        countFromString(dna);
    }
    public static void countFromString(String dna) {
        if (dna.isEmpty()) return;

        Map<Character, Long> frequencies = dna.chars().boxed().collect(Collectors.groupingBy(
                c -> (char) c.intValue(), Collectors.counting()));
        for(char c : new char[]{'A','C','G','T'}){
            System.out.print(frequencies.getOrDefault(c,0L)+" ");
        }
        System.out.println();
    }
}
