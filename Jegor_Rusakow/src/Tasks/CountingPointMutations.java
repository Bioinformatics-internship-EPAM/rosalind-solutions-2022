package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class CountingPointMutations {

    public static long countPointMutations(String dna1, String dna2){
        return IntStream.range(0, dna1.length()).map(idx -> dna1.charAt(idx) == dna2.charAt(idx) ? 0 : 1).sum();
    }

    public static void main(String[] args) throws IOException {
        List<String> dnas = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_hamm.txt"));
        System.out.println(countPointMutations(dnas.get(0), dnas.get(1)));
    }

}
