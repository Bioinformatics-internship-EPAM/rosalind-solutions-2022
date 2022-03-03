package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class KmerComposition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dna = in.nextLine();
        boolean f = false;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) != 'A' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G' && dna.charAt(i) != 'T') {
                f = true;
                break;
            }
        }
        if (!f) {
            char[] alphabet = {'A', 'C', 'G', 'T'};
            int lenWord = 4;
            int[] seq = new int[(int) Math.pow(alphabet.length, lenWord)];
            for (int i = 0; i < seq.length; i++)
                seq[i] = i;
            int[][] iWords = new int[seq.length][lenWord];
            for (int i = 0; i < iWords.length; i++) {
                int p = lenWord - 1;
                int n = seq[i];
                for (int j = 0; j < iWords[i].length; j++) {
                    iWords[i][j] = n / (int) Math.pow(alphabet.length, p);
                    n %= (int) Math.pow(alphabet.length, p);
                    p -= 1;
                }
            }
            String[] words = new String[seq.length];
            for (int i = 0; i < iWords.length; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < iWords[i].length; j++)
                    s.append(alphabet[iWords[i][j]]);
                words[i] = s.toString();
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words) map.put(word, 0);
            for (int i = 0; i < dna.length() - 3; i++) {
                String s = dna.substring(i, i + lenWord);
                if (map.containsKey(s))
                    map.replace(s, map.get(s) + 1);
            }
            TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
            System.out.println(sortedMap.values());
        }
        else {
            System.out.println("DNA string is wrong");
        }
    }
}
