import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Prot
 */
public class Prot {
    static private String INPUT_FILE_NAME = "rosalind_prot.txt";

    public static void main(String[] args) {
        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> rnaTable = new HashMap<String, String>();

        rnaTable.put("UUU", "F");
        rnaTable.put("UUC", "F");
        rnaTable.put("UUA", "L");
        rnaTable.put("UUG", "L");
        rnaTable.put("UCU", "S");
        rnaTable.put("UCC", "S");
        rnaTable.put("UCA", "S");
        rnaTable.put("UCG", "S");
        rnaTable.put("UAU", "Y");
        rnaTable.put("UAC", "Y");
        rnaTable.put("UAA", "\0");
        rnaTable.put("UAG", "\0");
        rnaTable.put("UGU", "C");
        rnaTable.put("UGC", "C");
        rnaTable.put("UGA", "\0");
        rnaTable.put("UGG", "W");

        rnaTable.put("CUU", "L");
        rnaTable.put("CUC", "L");
        rnaTable.put("CUA", "L");
        rnaTable.put("CUG", "L");
        rnaTable.put("CCU", "P");
        rnaTable.put("CCC", "P");
        rnaTable.put("CCA", "P");
        rnaTable.put("CCG", "P");
        rnaTable.put("CAU", "H");
        rnaTable.put("CAC", "H");
        rnaTable.put("CAA", "Q");
        rnaTable.put("CAG", "Q");
        rnaTable.put("CGU", "R");
        rnaTable.put("CGC", "R");
        rnaTable.put("CGA", "R");
        rnaTable.put("CGG", "R");

        rnaTable.put("AUU", "I");
        rnaTable.put("AUC", "I");
        rnaTable.put("AUA", "I");
        rnaTable.put("AUG", "M");
        rnaTable.put("ACU", "T");
        rnaTable.put("ACC", "T");
        rnaTable.put("ACA", "T");
        rnaTable.put("ACG", "T");
        rnaTable.put("AAU", "N");
        rnaTable.put("AAC", "N");
        rnaTable.put("AAA", "K");
        rnaTable.put("AAG", "K");
        rnaTable.put("AGU", "S");
        rnaTable.put("AGC", "S");
        rnaTable.put("AGA", "R");
        rnaTable.put("AGG", "R");

        rnaTable.put("GUU", "V");
        rnaTable.put("GUC", "V");
        rnaTable.put("GUA", "V");
        rnaTable.put("GUG", "V");
        rnaTable.put("GCU", "A");
        rnaTable.put("GCC", "A");
        rnaTable.put("GCA", "A");
        rnaTable.put("GCG", "A");
        rnaTable.put("GAU", "D");
        rnaTable.put("GAC", "D");
        rnaTable.put("GAA", "E");
        rnaTable.put("GAG", "E");
        rnaTable.put("GGU", "G");
        rnaTable.put("GGC", "G");
        rnaTable.put("GGA", "G");
        rnaTable.put("GGG", "G");

        String dnaStr = scanner.nextLine();
        StringBuilder dnaSubStr = new StringBuilder();
        StringBuilder proteinBuilder = new StringBuilder();
        for (char token : dnaStr.toCharArray())
        {
            dnaSubStr.append(token);
            if (dnaSubStr.length() == 3)
            {
                proteinBuilder.append(rnaTable.get(dnaSubStr.toString()));
                dnaSubStr = new StringBuilder();
            }

            if (proteinBuilder.charAt(proteinBuilder.length() - 1) == '\0')
            {
                break;
            }
        }

        System.out.println();
        System.out.println(proteinBuilder.toString());
    }
}
