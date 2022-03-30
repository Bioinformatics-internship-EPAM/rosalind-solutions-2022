import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
/*
Solution for the task https://rosalind.info/problems/iprb/
Sample input: 2 2 2
Sample output: 0.78333
*/

public class IPRB {

    public static void main(String[] args) throws Exception {
        String[] input = new String(Files.readAllBytes(Paths.get("src/main/resources/IPRB.txt"))).split(" ");
        System.out.println(getResult(input));
    }

    private static String getResult(String[] input) {

        Map<String, Object> counts = Map.of(
                "AA", Integer.parseInt(input[0]),
                "Aa", Integer.parseInt(input[1]),
                "aa", Integer.parseInt(input[2])
        );

        int count = (int) counts.get("AA") + (int) counts.get("Aa") + (int) counts.get("aa");

        float allVariants = count*(count - 1)/2;

        float probability = 0;
        probability += 1 * (((int) counts.get("AA") * ((int) counts.get("AA") - 1)) / 2) / allVariants; //AA+AA
        probability += 1 * (int) counts.get("AA") * (int) counts.get("Aa") /allVariants; //AA+Aa
        probability += 1 * (int) counts.get("AA") * (int) counts.get("aa") /allVariants; //AA+aa
        probability += 0.75f * ((int) counts.get("Aa") * ((int) counts.get("Aa") - 1) / 2) / allVariants; //Aa+Aa
        probability += 0.5f *(int) counts.get("Aa")*(int) counts.get("aa")/allVariants; //Aa+aa

        final String result = String.format("%.5f", probability);
        return result.replace(',', '.');
    }
}
