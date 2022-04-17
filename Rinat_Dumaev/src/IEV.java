import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * Calculating Expected Offspring
 * https://rosalind.info/problems/iev/
 */
public class IEV {
    private static final String FILE_NAME = "resources/rosalind_iev.txt";

    public static void main(String[] args) throws IOException {
        List<Double> chances = Arrays.asList(1.0, 1.0, 1.0, 0.75, 0.5, 0.0);

        List<Integer> input = Arrays.stream(
                Files.readString(Path.of(FILE_NAME))
                        .replace("\n", "")
                        .split(" ")
        ).map(Integer::parseInt).toList();

        double result = IntStream
                .range(0, chances.size())
                .mapToDouble(i -> input.get(i) * chances.get(i))
                .sum();

        System.out.println(2 * result);
    }
}
