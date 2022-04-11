import java.io.File;
import java.util.Scanner;

// https://rosalind.info/problems/splc/
public class SPLC {
    public static String solve(String inputPath) throws Exception {
        File inputFile = new File(inputPath);
        Scanner sc = new Scanner(inputFile);
        sc.nextLine();
        String dna = sc.nextLine();
        while (sc.hasNextLine()) {
            sc.nextLine();
            String intron = sc.nextLine();
            dna = dna.replace(intron, "");
        }
        return PROT.solve(dna.replace('T', 'U'));
    }
}
