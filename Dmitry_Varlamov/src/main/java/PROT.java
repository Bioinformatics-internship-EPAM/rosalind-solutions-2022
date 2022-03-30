import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
/*
Solution for the task https://rosalind.info/problems/prot/
Sample input: AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA
Sample output: MAMAPRTEINSTRING
*/

public class PROT {
    public static void main(String[] args) throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/PROT.txt")));
        System.out.println(getResult(input));
    }

    private static String getResult(String input){
        HashMap<String, String> map = new HashMap<String, String>() {{
            put("UUU", "F");
            put("UUC", "F");
            put("UUA", "L");
            put("UUG", "L");
            put("UCU", "S");
            put("UCC", "S");
            put("UCA", "S");
            put("UCG", "S");
            put("UAU", "Y");
            put("UAC", "Y");
            put("UAA", "Stop");
            put("UAG", "Stop");
            put("UGU", "C");
            put("UGC", "C");
            put("UGA", "Stop");
            put("UGG", "W");
            put("CUU", "L");
            put("CUC", "L");
            put("CUA", "L");
            put("CUG", "L");
            put("CCU", "P");
            put("CCC", "P");
            put("CCA", "P");
            put("CCG", "P");
            put("CAU", "H");
            put("CAC", "H");
            put("CAA", "Q");
            put("CAG", "Q");
            put("CGU", "R");
            put("CGC", "R");
            put("CGA", "R");
            put("CGG", "R");
            put("AUU", "I");
            put("AUC", "I");
            put("AUA", "I");
            put("AUG", "M");
            put("ACU", "T");
            put("ACC", "T");
            put("ACA", "T");
            put("ACG", "T");
            put("AAU", "N");
            put("AAC", "N");
            put("AAA", "K");
            put("AAG", "K");
            put("AGU", "S");
            put("AGC", "S");
            put("AGA", "R");
            put("AGG", "R");
            put("GUU", "V");
            put("GUC", "V");
            put("GUA", "V");
            put("GUG", "V");
            put("GCU", "A");
            put("GCC", "A");
            put("GCA", "A");
            put("GCG", "A");
            put("GAU", "D");
            put("GAC", "D");
            put("GAA", "E");
            put("GAG", "E");
            put("GGU", "G");
            put("GGC", "G");
            put("GGA", "G");
            put("GGG", "G");
         }};
        String res = "";
        for(int i=0; i < input.length(); i = i + 3) {
            String code = map.get(input.substring(i, i+3));
            if (code == "Stop") {return res;}
            res = res + code;
        }
        return res;
    }
}
