import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Mendel's First Law
 * https://rosalind.info/problems/iprb/
 */
public class IPRB {
    private static final String FILE_NAME = "resources/rosalind_iprb.txt";

    public static void main(String[] args) throws IOException {
        String[] input = Files.readString(Path.of(FILE_NAME))
                .replace("\n", "")
                .split(" ");

        System.out.println(calculateProbability(
                Float.parseFloat(input[0]),
                Float.parseFloat(input[1]),
                Float.parseFloat(input[2])
        ));
    }

    private static float calculateProbability(float k, float m, float n) {
        float total = k + m + n;

        float twoRecess = (n / total) * ((n - 1) / (total - 1));
        float twoHetero = (m / total) * ((m - 1) / (total - 1));
        float heteroRecess = (n / total) * (m / (total - 1)) + (m / total) * (n / (total - 1));

        float recessProb = twoRecess + twoHetero * 1/4 + heteroRecess * 1/2;

        return 1 - recessProb;
    }
}
