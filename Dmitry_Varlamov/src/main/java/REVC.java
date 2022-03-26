import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.IntStream;

public class REVC {

    public static void main(String[] args) throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/REVC.txt")));
        System.out.println(getResult(input));
    }

    private static String getResult(String input) {
        StringBuilder reverseComplement = new StringBuilder();
        Map<Character, Character> map = Map.of(
                'A', 'T',
                'C', 'G',
                'G', 'C',
                'T', 'A'
        );
        IntStream.range(0, input.length()).mapToObj(i -> map.get(input.charAt(i))).forEach(reverseComplement::append);
        final String result = reverseComplement.reverse().toString();
        return result;
    }
}
