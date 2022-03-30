package testofbioinfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//https://rosalind.info/problems/revc/

//Given: A DNA string s of length at most 1000 bp.
//Return: The reverse complement sc of s.

public class ComplementingaStrandofDNA {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\REVC.txt"),
                StandardCharsets.UTF_8);
        String dna = lines.get(0);
        System.out.println("Complementing a Strand of DNA");
        System.out.println(dna);
        System.out.println(Complement(dna));
    }

    public static String Complement(String data) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(data.length() - i - 1);
            switch (ch) {
                case 'A': {
                    s.append('T');
                    continue;
                }
                case 'T': {
                    s.append('A');
                    continue;
                }
                case 'G': {
                    s.append('C');
                    continue;
                }
                case 'C': {
                    s.append('G');
                }
            }
        }
        return s.toString();
    }
}
