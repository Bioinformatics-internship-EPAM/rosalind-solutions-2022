import java.io.File;
import java.util.Scanner;

/**
 * Fib
 */
public class Fib {

    static private String INPUT_FILE_NAME = "rosalind_fib.txt";

    public static void main(String[] args) {

        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long youngRabbits = 1;
        long adultRabbits = 0;

        for (int i = 1; i < n; ++i)
        {
            long bornRabbits = adultRabbits * k;
            adultRabbits = adultRabbits + youngRabbits;
            youngRabbits = bornRabbits;
        }

        System.out.println(youngRabbits + adultRabbits);
    }
}