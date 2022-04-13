import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/prot/
Sample Input - GATATATGCATATACTT
               ATAT
Sample Output - 2 4 10
*/

public class SUBS {

    static private String INPUT_FILE = "src/resources/rosalind_subs.txt";

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));

        final String dnaStr = scanner.nextLine();
        final String dnaSubStr = scanner.nextLine();

        ArrayList<Integer> locationsInDna = new ArrayList<>();
        int subStrLocation = 0;

        while ( true ){
            subStrLocation = dnaStr.indexOf(dnaSubStr, subStrLocation );
            if ( subStrLocation != -1 ) {
                subStrLocation++;                       // +1 for convert into 1-based numbering and
                locationsInDna.add(subStrLocation);     // starting .indexOf method from the next index
            } else {
                break;
            }
        }

        System.out.print(locationsInDna.toString().replaceAll("[\\[.\\].\\,.]", ""));
    }
}
