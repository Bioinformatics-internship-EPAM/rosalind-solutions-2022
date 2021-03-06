package testofbioinfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//https://rosalind.info/problems/hamm/

//Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
//Return: The Hamming distance dH(s,t).

public class CountingPointMutations {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\hamm.txt"),
                StandardCharsets.UTF_8);
        String dna1 =lines.get(0);
        String dna2 = lines.get(1);
        System.out.println("Counting Point Mutations");
        System.out.println(dna1);
        System.out.println(dna2);

        int N = Math.min(dna1.length(),dna2.length());
        int count =0;
        for (int i =0;i<N;i++){
            if(dna1.charAt(i)!=dna2.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }
