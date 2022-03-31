// https://rosalind.info/problems/prot/
//Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).
//Return: The protein string encoded by s.

public class PROT {
    String getProtein(String rna) {
        String protein = "";
        if(rna.length() % 3 != 0) {
            System.out.println("wrong RNA");
            return protein;
        }
        int index = 0;
        while(index < rna.length()) {
            String codon = rna.substring(index, index+3);
            switch(codon){
                case "CAU", "CAC" -> protein += "H";
                case "CAA", "CAG" -> protein += "Q";
                case "CCA", "CCC", "CCU", "CCG" -> protein += "P";
                case "CGA", "CGC", "CGU", "CGG", "AGA", "AGG" -> protein += "R";
                case "CUA", "CUC", "CUU", "CUG", "UUG", "UUA"  -> protein += "L";
                case "GAU", "GAC" -> protein += "D";
                case "GAA", "GAG" -> protein += "E";
                case "GCA", "GCC", "GCU", "GCG" -> protein += "A";
                case "GGA", "GGC", "GGU", "GGG" -> protein += "G";
                case "GUA", "GUC", "GUU", "GUG" -> protein += "V";
                case "UAU", "UAC" -> protein += "Y";
                case "UAA", "UAG", "UGA" -> protein += "";
                case "UCA", "UCC", "UCU", "UCG", "AGU", "AGC" -> protein += "S";
                case "UGU", "UGC" -> protein += "C";
                case "UGG"-> protein += "W";
                case "UUU", "UUC" -> protein += "F";
                case "AAU", "AAC" -> protein += "N";
                case "AAA", "AAG" -> protein += "K";
                case "ACA", "ACC", "ACU", "ACG" -> protein += "T";
                case "AUU", "AUC", "AUA" -> protein += "I";
                case "AUG" -> protein += "M";
                default -> throw new IllegalStateException("Unexpected value: " + codon);
            }
            index+=3;
        }
        return protein;
    }
}
