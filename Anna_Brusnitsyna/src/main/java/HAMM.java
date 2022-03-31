// https://rosalind.info/problems/hamm/

public class HAMM {
    public static int solve(String dna1, String dna2) throws Exception {
        if (dna1 == null || dna2 == null) {
            throw new Exception("DNA string is null");
        }
        if (dna1.length() != dna2.length()) {
            throw new Exception("DNA strings have different length");
        }

        int distance = 0;
        for (int i = 0; i < dna1.length(); i++) {
            if (dna1.charAt(i) != dna2.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}
