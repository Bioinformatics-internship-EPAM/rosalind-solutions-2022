import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subs {

    static private String INPUT_FILE_NAME = "rosalind_subs.txt";

    public static void main(String[] args) {

        Scanner scanner = null;
        
        try {
            File txtFile = new File(INPUT_FILE_NAME);
            scanner = new Scanner(txtFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String dnaStr = scanner.nextLine();
        String dnaSubStr = scanner.nextLine();

        List<Integer> subStrLoc = new ArrayList<Integer>();
        Integer searchPos = 0;

        while (dnaStr.indexOf(dnaSubStr, searchPos) != -1)
        {
            searchPos = dnaStr.indexOf(dnaSubStr, searchPos) + 1;
            subStrLoc.add(searchPos);
        }

        for (Integer val : subStrLoc)
        {
            System.out.printf("%d ", val);
        }
    }
}
