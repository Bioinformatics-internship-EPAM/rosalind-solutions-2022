import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/*
Rosalind task - https://rosalind.info/problems/revc/
Sample input - AAAACCCGGT
Sample output - ACCGGGTTTT
*/

public class REVC {
    static private String INPUT_FILE = "src/resources/rosalind_revc.txt";

    public static void main( String[] args ) throws Exception {
        Path filePath = Paths.get( INPUT_FILE );
        final String inputString = new String( Files.readAllBytes( filePath ) );

        System.out.println(reverseString(complementString(inputString)));
    }

    private static String complementString( String str ) {
        char[] charArray = str.toCharArray();
        String result = "";

        Map<Character,Character> charMap = new HashMap<Character, Character>(Map.of(
                'A', 'T',
                'T', 'A',
                'C', 'G',
                'G', 'C'
        ));

        for ( int i = 0; i < charArray.length; i++) {
            if (charMap.get(charArray[i]) != null) {
                result = result + charMap.get(charArray[i]);
            }
        }

        return result;
    }

    private static String reverseString(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }

        return result;
    }
}
