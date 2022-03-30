package testofbioinfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//https://rosalind.info/problems/subs/

//Given: A DNA string t having length at most 1000 nt.
//Return: The transcribed RNA string of t.

public class FindingaMotifinDNA {
    public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\SUBS.txt"),
            StandardCharsets.UTF_8);
    String dna = lines.get(0);
    String seq = lines.get(1);
        System.out.println("Finding a Motif in DNA");
        System.out.println(dna);
        System.out.println(seq);
        String result = FindingDNA(dna,seq);
        System.out.println(result);
    }

    public static String FindingDNA(String dna, String seq){
        int seq_Length = seq.length();
        int dna_Length =dna.length();
        StringBuilder s = new StringBuilder();
        for(int i =0; i<dna_Length-seq_Length;i++) {
            String substring = dna.substring(i, i + seq_Length);
            if (substring.equals(seq)) {
                s.append(i + 1).append(" ");
            }
        }
        return s.substring(0,s.length()-1);
    }
}
