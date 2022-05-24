import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


/**
 * Complementing a Strand of DNA
 * https://rosalind.info/problems/revc/
 */
public class REVC {
    private static final String FILE_NAME = "resources/rosalind_revc.txt";

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of(FILE_NAME));

        System.out.println(complementReverse(input));
    }

    private static String complementReverse(String dna) {
        Map<Character, Character> complementSymbols = Map.of(
                'A', 'T',
                'C', 'G',
                'G', 'C',
                'T', 'A'
        );

        StringBuilder complement = dna
                .chars()
                .mapToObj(c -> (char) c)
                .map(complementSymbols::get)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                );
        return complement.reverse().toString();
    }
}
