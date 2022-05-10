package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given:  Two DNA strings s and t (each of length at most 1 kbp).

Return: All locations of t as a substring of s.
 */
public class FindingMotifInDna {

    public static int[] findAllOccurences(String str, String substr){
        List<Integer> occurences = new ArrayList<>();
        int prevPos = 0;
        while (str.contains(substr)) {
            int pos = str.indexOf(substr);
            str = str.substring(pos + 1);
            pos++;
            occurences.add(pos + prevPos);
            prevPos = pos + prevPos;
        }
        return occurences.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) throws IOException {
        List<String> rnas = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_subs.txt"));
        String rna = rnas.get(0);
        String subrna = rnas.get(1);

        int[] res = findAllOccurences(rna, subrna);
        for (int i: res){
            System.out.printf("%d ", i);
        }
    }

}
