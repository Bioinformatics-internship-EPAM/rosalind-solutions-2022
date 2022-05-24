import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


/**
 * Counting DNA Nucleotides
 * https://rosalind.info/problems/dna/
 */
public class DNA {
    private static final String FILE_NAME = "resources/rosalind_dna.txt";

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of(FILE_NAME));

        HashMap<Character, Integer> result = count(input);

        System.out.printf(
                "%d %d %d %d%n",
                result.get('A'),
                result.get('C'),
                result.get('G'),
                result.get('T')
        );
    }

    private static HashMap<Character, Integer> count(String dna) {
        HashMap<Character, Integer> counter = new HashMap<>(Map.of(
                'A', 0,
                'C', 0,
                'G', 0,
                'T', 0
        ));

        for (Character c: dna.toCharArray()) {
            if (counter.containsKey(c)) {
                counter.replace(c, counter.get(c) + 1);
            }
        }

        return counter;
    }
}