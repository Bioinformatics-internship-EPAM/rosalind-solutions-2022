import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class fib {

    private static long calculatePairs(int months, int litterSize){
        LinkedList<Long> pairs = new LinkedList<>();
        pairs.add((long) 1);
        pairs.add((long) 1);
        if (months <= 2){
            return pairs.get(months - 1);
        } else {
            for (int i = 3; i <= months; i++){
                pairs.add(pairs.get(i - 3)*litterSize + pairs.get(i - 2));
            }
            return pairs.get(months - 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File dataset = new File("resources/rosalind_fib.txt");
        Scanner scanner = new Scanner(dataset);
        int month = scanner.nextInt();
        int litterSize = scanner.nextInt();
        System.out.println(calculatePairs(month, litterSize));
    }
}
