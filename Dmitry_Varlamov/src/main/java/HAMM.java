import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;



public class HAMM {
    public static void main(String[] args) throws Exception {
        String dnas[] = new String(Files.readAllBytes(Paths.get("src/main/resources/HAMM.txt"))).split("\\r?\\n");
        System.out.println(getResult(dnas[0], dnas[1]));
    }

    private static String getResult(String dna1, String dna2) {
        long hammingDistance = IntStream.range(0, dna1.length()).filter(i -> dna1.charAt(i) != dna2.charAt(i)).count();
        final String result = Integer.toString((int) hammingDistance);
        return result;
    }
}
