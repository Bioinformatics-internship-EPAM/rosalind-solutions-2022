import java.io.IOException;
import java.util.Map;


public class REVC {

    public static StringBuilder REVCTask () throws IOException {
        var dataSet = Utils.readFromFile("resources/rosalind_revc.txt").get(0);
        StringBuilder complimentDNA = new StringBuilder();
        String reversed = new StringBuilder(dataSet).reverse().toString();
        var complements = Map.of(
                'A', 'T',
                'T', 'A',
                'G', 'C',
                'C', 'G'
        );
        for (int i=0; i < dataSet.length(); i++) {
            complimentDNA.append(complements.get(reversed.charAt(i)));
        }
        return complimentDNA;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(REVCTask());
    }
}
