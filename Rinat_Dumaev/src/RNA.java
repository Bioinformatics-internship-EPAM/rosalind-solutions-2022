import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Transcribing DNA into RNA
 * https://rosalind.info/problems/rna/
 */
public class RNA {
    private static final String FILE_NAME = "resources/rosalind_rna.txt";

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of(FILE_NAME));

        System.out.println(input.replace('T', 'U'));
    }
}
