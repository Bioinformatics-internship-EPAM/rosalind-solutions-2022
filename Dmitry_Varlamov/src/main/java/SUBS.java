import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
/*
Solution for the task https://rosalind.info/problems/subs/
Sample input:
GATATATGCATATACTT
ATAT
Sample output: 2 4 10
*/

public class SUBS {

    public static void main(String[] args) throws Exception {
        String dna = new String(Files.readAllBytes(Paths.get("src/main/resources/SUBS.txt"))).split("\\r?\\n")[0];
        String dnaSub = new String(Files.readAllBytes(Paths.get("src/main/resources/SUBS.txt"))).split("\\r?\\n")[1];
        System.out.println(getResult(dna, dnaSub));
    }

    private static StringJoiner getResult(String dna, String dnaSub) {
        final StringJoiner result = new StringJoiner(" ");
        Integer index = dna.indexOf(dnaSub);
        while (index >= 0) {
            result.add(Integer.toString(index + 1));
            index = dna.indexOf(dnaSub, index + 1);
        }
        return result;
    }
}
