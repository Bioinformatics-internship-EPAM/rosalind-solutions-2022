import java.io.IOException;

/**
 * HAMM task solution: https://rosalind.info/problems/hamm/
 *
 * Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
 * 
 * Return: The Hamming distance.
 */

public class HAMM {

    public static int HAMMTask () throws IOException {
        var firstData = Utils.readFromFile("resources/rosalind_hamm.txt").get(0);
        var secondData = Utils.readFromFile("resources/rosalind_hamm.txt").get(1);
        int hamDistance = 0;
        for (int i=0; i < firstData.length(); i++) {
            if (firstData.charAt(i) != secondData.charAt(i)) {
                hamDistance += 1;
            }
        }
        return hamDistance;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(HAMMTask());
    }
}
