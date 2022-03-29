package com.company;

import java.util.Scanner;

public class RNAsplicing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dna = in.nextLine();
        String s = in.nextLine();
        String[] introns = s.split(" ");
        boolean f = false;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) != 'A' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G' && dna.charAt(i) != 'T') {
                f = true;
                break;
            }
        }
        for (String intron: introns) {
            for (int i = 0; i < intron.length(); i++) {
                if (intron.charAt(i) != 'A' && intron.charAt(i) != 'C' && intron.charAt(i) != 'G' && intron.charAt(i) != 'T') {
                    f = true;
                    break;
                }
            }
        }
        if (!f) {
            String dnaWithoutIntrons = dna;
            for (String intron: introns) {
                dnaWithoutIntrons = dnaWithoutIntrons.replaceAll(intron, "");
            }
            String rna = dnaWithoutIntrons.replaceAll("T", "U");
            StringBuilder protein = new StringBuilder();
            for (int i = 0; i < rna.length(); i+=3) {
                String codon = rna.substring(i, i+3);
                switch (codon) {
                    case "UUU", "UUC" -> protein.append("F");
                    case "UUA", "UUG", "CUU", "CUC", "CUA", "CUG" -> protein.append("L");
                    case "AUU", "AUC", "AUA" -> protein.append("I");
                    case "AUG" -> protein.append("M");
                    case "GUU", "GUC", "GUA", "GUG" -> protein.append("V");
                    case "UCU", "UCC", "UCA", "UCG", "AGU", "AGC" -> protein.append("S");
                    case "CCU", "CCC", "CCA", "CCG" -> protein.append("P");
                    case "ACU", "ACC", "ACA", "ACG" -> protein.append("T");
                    case "GCU", "GCC", "GCA", "GCG" -> protein.append("A");
                    case "UAU", "UAC" -> protein.append("Y");
                    case "CAU", "CAC" -> protein.append("H");
                    case "CAA", "CAG" -> protein.append("Q");
                    case "AAU", "AAC" -> protein.append("N");
                    case "AAA", "AAG" -> protein.append("K");
                    case "GAU", "GAC" -> protein.append("D");
                    case "GAA", "GAG" -> protein.append("E");
                    case "UGU", "UGC" -> protein.append("C");
                    case "UGG" -> protein.append("W");
                    case "CGU", "CGC", "CGA", "CGG", "AGA", "AGG" -> protein.append("R");
                    case "GGU", "GGC", "GGA", "GGG" -> protein.append("G");
                }
            }
            System.out.println(protein);
        }
        else {
            System.out.println("DNA strings is wrong");
        }
    }
}
