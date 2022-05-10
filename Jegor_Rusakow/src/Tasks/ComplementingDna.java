package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ComplementingDna {

    public static String complementDna(String dna){
        Map<Integer, Integer> complimentMap = new HashMap<>(Map.of(
                (int) 'C', (int) 'G',
                (int) 'G', (int) 'C',
                (int) 'A', (int) 'T',
                (int) 'T', (int) 'A'
        ));

        return dna.chars().
                map(complimentMap::get).
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        String dna = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_revc.txt")).get(0);
        String res = complementDna(dna);
        System.out.println(res);
    }

}
