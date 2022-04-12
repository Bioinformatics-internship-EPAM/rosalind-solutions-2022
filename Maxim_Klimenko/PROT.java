import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/prot/
Sample Input - AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA
Sample Output - MAMAPRTEINSTRING
*/

public class PROT {

    static private String INPUT_FILE = "src/resources/rosalind_prot.txt";
    static private String CODON_TABLE_FILE = "src/resources/rna_codon_table.txt";

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner( Paths.get( INPUT_FILE ) );
        String proteinStr = "";
        String proteinValue = "";

        String rnaStr = scanner.nextLine();
        scanner.close();

        scanner = new Scanner( Paths.get( CODON_TABLE_FILE ) );

        HashMap<String, String> proteinTable = new HashMap<>();
        while ( scanner.hasNext() ) {
            String[] pair = scanner.nextLine().split(" ");
            proteinTable.put( pair[0], pair[1] );
        }

        while (!proteinValue.equals("Stop")) {
            proteinStr = proteinStr + proteinValue;
            proteinValue = proteinTable.get( rnaStr.substring( 0, 3 ) );
            rnaStr = rnaStr.substring(3);
        }

        System.out.println( proteinStr );
    }

}
