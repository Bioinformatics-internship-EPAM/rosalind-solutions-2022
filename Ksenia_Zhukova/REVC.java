// Complementing a Strand of DNA
// https://rosalind.info/problems/revc/

// Given: A DNA string s of length at most 1000 bp.
// Return: The reverse complement s^c of s.


import java.util.*;

public class REVC {

    public static String task() {
        String str = ReadFile.resFileToStringList("rosalind_revc.txt").get(0);

        Map<String, String> map = Map.of("A","T","C","G", "T","A", "G","C");

        List<String> list = new ArrayList<>();
        Arrays.asList(str.split("")).forEach(ch ->
                list.add(0, map.get(ch)));

        return String.join("", list);
    }
}
