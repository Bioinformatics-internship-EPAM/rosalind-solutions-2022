import java.nio.file.Files;
import java.nio.file.Paths;
/*
Solution for the task https://rosalind.info/problems/rna/
Sample input: GATGGAACTTGACTACGTAAATT
Sample output: GAUGGAACUUGACUACGUAAAUU
*/

public class RNA {

    public static void main(String[] args) throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/RNA.txt")));
        System.out.println(getResult(input));
    }

    private static String getResult(String input) {
        return input.replace('T', 'U');
    }
}
