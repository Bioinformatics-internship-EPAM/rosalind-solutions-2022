import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Finding a Motif in DNA
 * https://rosalind.info/problems/subs/
 */
public class SUBS {
    private static final String FILE_NAME = "resources/rosalind_subs.txt";

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of(FILE_NAME));

        String s = input.get(0);
        String t = input.get(1);

        List<Integer> indexes = new ArrayList<>();

        int currentIndex = s.indexOf(t);
        while (currentIndex >= 0) {
            indexes.add(currentIndex + 1);
            currentIndex = s.indexOf(t, currentIndex + 1);
        }

        System.out.println(indexes
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
