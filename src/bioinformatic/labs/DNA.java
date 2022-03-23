package bioinformatic.labs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://rosalind.info/problems/dna/ */
public class DNA {
    public static String solution(String DNA) {
        Map<Character, Integer> counters = new HashMap<>(Map.of(
                'A', 0,
                'C', 0,
                'G', 0,
                'T', 0
        ));

        for (char c : DNA.toUpperCase().toCharArray()) {
            if (!counters.containsKey(c)) {
                continue;
            }

            counters.compute(c, (k, value) -> ++value);
        }
        return outputString(counters.get('A'), counters.get('C'), counters.get('G'), counters.get('T'));
    }

    private static String outputString(int... counts) {
        List<String> list = new ArrayList<>();
        for (int c : counts) list.add(Integer.toString(c));
        return String.join(" ", list);
    }
}
