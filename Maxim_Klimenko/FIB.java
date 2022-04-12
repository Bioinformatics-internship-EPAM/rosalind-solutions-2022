import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Rosalind task - https://rosalind.info/problems/fib/
Sample Input - 5 3
Sample Output - 19
*/

public class FIB {

    static private String INPUT_FILE = "src/resources/rosalind_fib.txt";

    public static void main( String[] args ) throws Exception {
        Path filePath = Paths.get( INPUT_FILE );
        Scanner scanner = new Scanner( filePath );

        final int months = scanner.nextInt();
        final int offspring = scanner.nextInt();

        System.out.println(fib( months, offspring ));

    }

    public static long fib( int n, int k ) {
        if ( n == 1 || n == 2 ) {
            return 1;
        } else {
            return fib( n-1, k ) + fib( n-2, k ) * k;
        }
    }
}
