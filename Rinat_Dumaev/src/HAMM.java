import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


/**
 * Counting Point Mutations
 * https://rosalind.info/problems/hamm/
 */
public class HAMM {
    private static final String FILE_NAME = "resources/rosalind_hamm.txt";

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of(FILE_NAME));

        System.out.println(hammingDistance(
                input.get(0).toCharArray(),
                input.get(1).toCharArray()
        ));
    }

    private static int hammingDistance(char[] s1, char[] s2) {
        int distance = 0;

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                distance++;
            }
        }

        return distance;
    }

}
