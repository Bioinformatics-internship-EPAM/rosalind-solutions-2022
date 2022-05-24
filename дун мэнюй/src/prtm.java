import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class prtm {
    public static void main (String[] args) throws FileNotFoundException {
        Hashtable<String, Double> monoisotopicMasses = new Hashtable<>();
        File rosalind_monoisoMasses = new File("resources/rosalind_monoisotopicMasses.txt");
        Scanner scanner = new Scanner(rosalind_monoisoMasses);
        while (scanner.hasNext()){
            monoisotopicMasses.put(scanner.next(), Double.valueOf(scanner.next()));
        }

        File rosalind_prtm = new File("resources/rosalind_prtm.txt");
        scanner = new Scanner(rosalind_prtm);
        String proteinString = scanner.next();

        double weightedSum = 0.0;
        for (int i = 0; i < proteinString.length(); i++){
            weightedSum += monoisotopicMasses.get(proteinString.substring(i, i+1));
        }

        System.out.printf("%.3f", weightedSum);
    }
}
