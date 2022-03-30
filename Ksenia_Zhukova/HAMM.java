// Counting Point Mutations
// https://rosalind.info/problems/hamm/

// Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
// Return: The Hamming distance dH(s,t).


import java.util.List;

public class HAMM {

    public static int task() {
        List<String> src = ReadFile.resFileToStringList("rosalind_hamm.txt");
        String first = src.get(0);
        String second = src.get(1);

        int counter = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                counter++;
        }

        return counter;
    }
}
