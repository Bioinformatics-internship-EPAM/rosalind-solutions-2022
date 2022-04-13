import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/*
Rosalind task - https://rosalind.info/problems/dna/
*/

public class DNA {

    static private String INPUT_FILE = "src/resources/rosalind_dna.txt";


    public static void main( String[] args ) throws Exception {
        Path filePath = Paths.get(INPUT_FILE);
        final String inputString = new String( Files.readAllBytes(filePath) );

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for ( char c : inputString.toCharArray() ) {
            Integer n = map.get(c);
            if ( n == null ) map.put( c, 1 );
            else map.put( c, ++n );
        }

        System.out.println(map.values().toString().replaceAll("[\\[.\\].\\,.]", ""));

    }

}
