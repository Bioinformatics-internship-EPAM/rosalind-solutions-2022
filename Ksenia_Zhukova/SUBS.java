import java.util.ArrayList;
import java.util.List;

public class SUBS {

    public static String task() {
        List<String> src = ReadFile.resFileToStringList("rosalind_subs.txt");
        String dna = src.get(0);
        String pattern = src.get(1);

        List<String> list = new ArrayList<>();
        int index = dna.indexOf(pattern);
        while (index != -1) {
            list.add(Integer.toString(index + 1));
            index = dna.indexOf(pattern, index + 1);
        }

        return String.join(" ", list);
    }
}
