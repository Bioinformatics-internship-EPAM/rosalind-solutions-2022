package testofbioinfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://rosalind.info/problems/prot/

public class TranslatingRNAintoProtein {
    public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\prot.txt"),
            StandardCharsets.UTF_8);
            String data = lines.get(0);
        System.out.println("Translating RNA into Protein");
        System.out.println(data);
        System.out.println(translate(data));


    }
    static final int Codon_Length =3;
    public static String translate(String data){
        StringBuilder s = new StringBuilder();
        for(int i =0;i<data.length();i+=Codon_Length){
            String key = data.substring(i,i+Codon_Length);
            String str = condonTable.get(key);
            if(str.equals("Stop")) break;
            s.append(str);
        }
        return s.toString();
    }
    public static Map<String,String> condonTable = new HashMap<String,String>(){{
        put("UUU", "F");
        put("CUU", "L");
        put("AUU", "I");
        put("GUU", "V");
        put("UUC", "F");
        put("CUC", "L");
        put("AUC", "I");
        put("GUC", "V");
        put("UUA", "L");
        put("CUA", "L");
        put("AUA", "I");
        put("GUA", "V");
        put("UUG", "L");
        put("CUG", "L");
        put("AUG", "M");
        put("GUG", "V");
        put("UCU", "S");
        put("CCU", "P");
        put("ACU", "T");
        put("GCU", "A");
        put("UCC", "S");
        put("CCC", "P");
        put("ACC", "T");
        put("GCC", "A");
        put("UCA", "S");
        put("CCA", "P");
        put("ACA", "T");
        put("GCA", "A");
        put("UCG", "S");
        put("CCG", "P");
        put("ACG", "T");
        put("GCG", "A");
        put("UAU", "Y");
        put("CAU", "H");
        put("AAU", "N");
        put("GAU", "D");
        put("UAC", "Y");
        put("CAC", "H");
        put("AAC", "N");
        put("GAC", "D");
        put("UAA", "Stop");
        put("CAA", "Q");
        put("AAA", "K");
        put("GAA", "E");
        put("UAG", "Stop");
        put("CAG", "Q");
        put("AAG", "K");
        put("GAG", "E");
        put("UGU", "C");
        put("CGU", "R");
        put("AGU", "S");
        put("GGU", "G");
        put("UGC", "C");
        put("CGC", "R");
        put("AGC", "S");
        put("GGC", "G");
        put("UGA", "Stop");
        put("CGA", "R");
        put("AGA", "R");
        put("GGA", "G");
        put("UGG", "W");
        put("CGG", "R");
        put("AGG", "R");
        put("GGG", "G");
    }};
}
