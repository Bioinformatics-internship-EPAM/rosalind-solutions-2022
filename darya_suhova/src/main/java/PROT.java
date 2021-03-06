import com.google.common.collect.ImmutableMap;

import java.util.Scanner;

public class PROT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length()-2; i+=3) {
            String s = input.substring(i, i+3);
            String symbol = map.get(s);
            if (symbol.equals(STOP)){
                break;
            }
            builder.append(symbol);
        }
        System.out.println(builder.toString());
    }

    private final static String STOP ="Stop";

    private static final ImmutableMap<String, String> map = new ImmutableMap.Builder()
        .put("UUU", "F")
        .put("CUU", "L")
        .put("AUU", "I")
        .put("GUU", "V")
        .put("UUC", "F")
        .put("CUC", "L")
        .put("AUC", "I")
        .put("GUC", "V")
        .put("UUA", "L")
        .put("CUA", "L")
        .put("AUA", "I")
        .put("GUA", "V")
        .put("UUG", "L")
        .put("CUG", "L")
        .put("AUG", "M")
        .put("GUG", "V")
        .put("UCU", "S")
        .put("CCU", "P")
        .put("ACU", "T")
        .put("GCU", "A")
        .put("UCC", "S")
        .put("CCC", "P")
        .put("ACC", "T")
        .put("GCC", "A")
        .put("UCA", "S")
        .put("CCA", "P")
        .put("ACA", "T")
        .put("GCA", "A")
        .put("UCG", "S")
        .put("CCG", "P")
        .put("ACG", "T")
        .put("GCG", "A")
        .put("UAU", "Y")
        .put("CAU", "H")
        .put("AAU", "N")
        .put("GAU", "D")
        .put("UAC", "Y")
        .put("CAC", "H")
        .put("AAC", "N")
        .put("GAC", "D")
        .put("UAA", STOP)
        .put("CAA", "Q")
        .put("AAA", "K")
        .put("GAA", "E")
        .put("UAG", STOP)
        .put("CAG", "Q")
        .put("AAG", "K")
        .put("GAG", "E")
        .put("UGU", "C")
        .put("CGU", "R")
        .put("AGU", "S")
        .put("GGU", "G")
        .put("UGC", "C")
        .put("CGC", "R")
        .put("AGC", "S")
        .put("GGC", "G")
        .put("UGA", STOP)
        .put("CGA", "R")
        .put("AGA", "R")
        .put("GGA", "G")
        .put("UGG", "W")
        .put("CGG", "R")
        .put("AGG", "R")
        .put("GGG", "G")
        .build();
}
