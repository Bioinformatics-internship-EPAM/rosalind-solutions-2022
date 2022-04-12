import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/prtm/
Sample Input - SKADYEK
Sample Output - 821.392
*/

public class PRTM {

    static private String INPUT_FILE = "src/resources/rosalind_prtm.txt";
    static private String MASS_TABLE_FILE = "src/resources/monoisotopic_mass_table.txt";

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner(Paths.get( INPUT_FILE ));
        final char[] proteinCharArray = scanner.nextLine().toCharArray();
        scanner.close();

        scanner = new Scanner(Paths.get( MASS_TABLE_FILE ));
        HashMap<Character, Double> massTable = new HashMap<>();
        while ( scanner.hasNext() ) {
            String[] pair = scanner.nextLine().split(" ");
            massTable.put( pair[0].charAt(0) , Double.parseDouble(pair[1]) );
        }

        double proteinWeight = 0.0;
        for ( char c : proteinCharArray ) {
            if (massTable.get(c) != null) {
                proteinWeight = proteinWeight + massTable.get(c);
            }
        }

        System.out.println(proteinWeight);
    }
}
