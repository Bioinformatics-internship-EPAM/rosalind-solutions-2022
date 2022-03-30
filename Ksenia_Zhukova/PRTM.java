import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRTM {

    public static double task() {
        String proteinStr = ReadFile.resFileToStringList("rosalind_prtm.txt").get(0);

        List<String> masses = ReadFile.resFileToStringList("info/monoisotopic_mass_table.txt");
        Map<Character, Double> massMap = new HashMap<>();
        masses.forEach(line -> {
            String[] pair = line.split(" {3}");
            massMap.put(pair[0].charAt(0), Double.parseDouble(pair[1]));
        });

        double proteinMass = 0;
        for (char aminoAcid: proteinStr.toCharArray()) {
            proteinMass += massMap.get(aminoAcid);
        }

        return proteinMass;
    }
}
