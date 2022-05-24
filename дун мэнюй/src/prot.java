import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class prot {
    public static void main(String[] args) throws FileNotFoundException {
        File rnaCodons = new File("resources/rosalind_rnacodons.txt");
        Scanner scanner = new Scanner(rnaCodons);
        Hashtable<String, String> rnaCodons_dict = new Hashtable<>();
        while (scanner.hasNext()){
            rnaCodons_dict.put(scanner.nextLine(), scanner.nextLine());
        }
        File rnaString = new File("resources/rosalind_prot.txt");
        scanner = new Scanner(rnaString);
        String rnaStringS = scanner.nextLine();

        StringBuilder proteinString = new StringBuilder();
        for (int i = 0; i < rnaStringS.length(); i+=3){
            String codon = rnaStringS.substring(i, i+3);
            if (rnaCodons_dict.get(codon).equals("Stop")){
                break;
            } else {
                proteinString.append(rnaCodons_dict.get(codon));
            }
        }
        System.out.println(proteinString);
    }
}
