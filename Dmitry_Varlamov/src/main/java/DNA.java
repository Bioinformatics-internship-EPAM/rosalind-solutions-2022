import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class DNA {
    public static void main(String[] args) throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/DNA.txt")));
        System.out.println(getResult(input));
    }

    private static String getResult(String input){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(Map.of(
                'A', 0,
                'C', 0,
                'G', 0,
                'T', 0
        ));
        char[] chars = input.toCharArray();
        IntStream.range(0, chars.length).forEach(i -> {
            if (!map.containsKey(chars[i])) {
                System.out.println("Error");
            }
            map.merge(chars[i], 1, Integer::sum);
        });
        return String.format("%d %d %d %d", map.get('A'), map.get('C'), map.get('G'), map.get('T'));
    }
}
