import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Rabbits and Recurrence Relations
 * https://rosalind.info/problems/fib/
 */
public class FIB {
    private static final String FILE_NAME = "resources/rosalind_fib.txt";

    public static void main(String[] args) throws IOException {
        String[] input = Files.readString(Path.of(FILE_NAME))
                .replace("\n", "")
                .split(" ");

        int months = Integer.parseInt(input[0]);
        int offsprings = Integer.parseInt(input[1]);

        System.out.println(countPairs(months, offsprings));
    }

    private static long countPairs(int month, int offspring) {
        if (month <= 1) {
            return month;
        }

        return countPairs(month - 1, offspring) + offspring * countPairs(month - 2, offspring);
    }
}
