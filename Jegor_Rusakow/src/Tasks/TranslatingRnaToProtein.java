package Tasks;

import Tasks.AdditionalUtils.ProteinCodonsMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TranslatingRnaToProtein {

    public static String codonFilepath = "Jegor_Rusakow/src/resources/codons.txt";

    public static String translateRnaToProtein(String rna) throws IOException{
        ProteinCodonsMap codonsMap = new ProteinCodonsMap(codonFilepath);

        List<String> triplets = new ArrayList<>(rna.length() / 3);
        for (int i = 0; i < rna.length() / 3; i++){
            String triplet = String.format("%s%s%s", rna.charAt(i * 3), rna.charAt(i * 3 + 1), rna.charAt(i * 3 + 2));
            triplets.add(triplet);
        }

        StringBuilder protein = new StringBuilder();
        for (String triplet: triplets){
            String amino = codonsMap.get(triplet);
            if (!amino.equals("Stop")){
                protein.append(amino);
            } else {
                break;
            }
        }

        return protein.toString();
    }

    public static void main(String[] args) throws IOException {

        String rna = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_prot.txt")).get(0);

        System.out.println(translateRnaToProtein(rna));
    }

}
