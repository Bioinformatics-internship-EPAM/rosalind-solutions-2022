import java.io.IOException;
import java.util.ArrayList;

/**
 * SUBS task solution: https://rosalind.info/problems/subs/
 *
 * Given: Two DNA strings s and t (each of length at most 1 kbp).
 * 
 * Return: All locations of t as a substring of s.
 */

public class SUBS {

    public static ArrayList<Integer> SUBSTask () throws IOException {
        var firstData = Utils.readFromFile("resources/rosalind_subs.txt").get(0);
        var secondData = Utils.readFromFile("resources/rosalind_subs.txt").get(1);
        ArrayList <Integer> indexes = new ArrayList<>();
        if (firstData.length() < secondData.length()) {
            System.out.println("Second DNA must be equal or smaller than first DNA");
        }
        else {
            int index = 0;
            while (index + secondData.length() != firstData.length()-1) {
                index = firstData.indexOf(secondData, index);
                if (index != -1) {
                    index += 1;
                    indexes.add(index);
                }
                else {
                    break;
                }
            }
        }
        return indexes;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(SUBSTask());
    }
}
