import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hamm {
    private static int mismatched (String s1, String s2){
        int mismatchedCounter = 0;
        for (int i = 0; i < s1.length(); i ++){
            if (s1.charAt(i) != s2.charAt(i)){
                mismatchedCounter++;
            }
        }
        return mismatchedCounter;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File dataset = new File("resources/rosalind_hamm.txt");
        Scanner scanner = new Scanner(dataset);
        String primary = scanner.nextLine();
        String secondary = scanner.nextLine();
        System.out.println(mismatched(primary, secondary));
    }
}
