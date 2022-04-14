package Tasks.AdditionalUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/*
This class constructs codons map.
Codon-Protein pairs are stored in 'filepath' argument.
 */
public class ProteinCodonsMap extends HashMap<String, String> {

    public ProteinCodonsMap(String filePath) throws IOException {
        super();
        String nucleotides, protein;
        String[] pair;

        List<String> codons = Files.readAllLines(Paths.get(filePath));

        for (String codon: codons){
            pair = codon.split(" ");
            nucleotides = pair[0];
            protein = pair[1];
            this.put(nucleotides, protein);
        }
    }



}
