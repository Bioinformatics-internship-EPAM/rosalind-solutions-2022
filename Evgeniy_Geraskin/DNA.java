import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class DNA {

    public static List<Integer> DNATask () throws IOException {
        var data = Utils.readFromFile("resources/rosalind_dna.txt").get(0);
        Map <Character, Integer> map = new HashMap<>();
        for (int i=0; i < data.length(); i++) {
            map.merge(data.charAt(i), 1, Integer::sum);
        }
        return List.of(map.get('A'), map.get('C'), map.get('G'), map.get('T'));
    }
    public static void main(String[] args) throws IOException {
        System.out.println(DNATask());
    }
}
