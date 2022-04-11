import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// https://rosalind.info/problems/revc/
public class REVC {
    final private static HashMap<Character, Character> complements = new HashMap<>(Map.of(
            'A', 'T',
            'T', 'A',
            'C', 'G',
            'G', 'C'
    ));

    public static String solve(String dna) throws Exception {
        if (dna == null) {
            throw new Exception("DNA string is null");
        }
        return new StringBuilder(dna)
                .reverse()
                .chars()
                .map(i -> complements.get((char) i))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }
}
