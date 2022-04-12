import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/hamm/
Sample Input - GAGCCTACTAACGGGAT
               CATCGTAATGACGGCCT
Sample Output - 7
*/

public class HAMM {

    static private String INPUT_FILE = "src/resources/rosalind_hamm.txt";

    public static void main( String[] args ) throws Exception {
        Path filePath = Paths.get( INPUT_FILE );
        Scanner scanner = new Scanner( filePath );

        String firstDnaStr = scanner.nextLine();
        String secondDnaString = scanner.nextLine();

        System.out.println(compareString( firstDnaStr, secondDnaString ));
    }

    private static int compareString( String str1, String str2 ) {
        int result = 0;

        for ( int i = 0; i < str1.length(); i++ ) {
            if ( str1.charAt(i) != str2.charAt(i) ) {
                result++;
            }
        }

        return result;
    }
}
