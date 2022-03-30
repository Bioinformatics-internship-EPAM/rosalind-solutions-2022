import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
/*
Solution for the task https://rosalind.info/problems/iev/
Sample input: 1 0 0 1 0 1
Sample output: 3.5
*/

public class IEV {

    public static void main(String[] args) throws Exception {
        String[] input = new String(Files.readAllBytes(Paths.get("src/main/resources/IEV.txt"))).split(" ");
        System.out.println(getResult(input));
    }

    private static String getResult(String[] input) {
        double[] chances = new double [] {1, 1, 1, 0.75, 0.5, 0};
        final double result = IntStream.range(0, chances.length).mapToDouble(i ->
                chances[i] * Integer.parseInt(input[i])).sum();
        return String.format("%.1f", 2*result).replace(',', '.');
    }
}
