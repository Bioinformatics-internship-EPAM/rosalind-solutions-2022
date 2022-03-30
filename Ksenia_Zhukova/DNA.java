// Counting DNA Nucleotides
// https://rosalind.info/problems/dna/

// Given: A DNA string s of length at most 1000 nt.
// Return: Four integers (separated by spaces) counting the respective number of times
// that the symbols 'A', 'C', 'G', and 'T' occur in s.


import java.util.*;

public class DNA {

    public static String task() {
        String str = ReadFile.resFileToStringList("rosalind_dna.txt").get(0);
        char[] ntLine = str.toCharArray();

        Map<Character, Integer> map = new TreeMap<>();
        for (char nt: ntLine) {
            map.merge(nt, 1, Integer::sum);
        }

        List<String> list = new ArrayList<>();
        map.keySet().forEach(key -> list.add(map.get(key).toString()));
        return String.join(" ", list);
    }
}
