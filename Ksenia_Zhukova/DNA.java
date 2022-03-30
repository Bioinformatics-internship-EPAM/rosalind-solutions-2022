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
