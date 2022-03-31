public class HAMM {

    public int getDifference(String dna1, String dna2) {
        int counter = 0;
        for(int i = dna1.length() - 1; i >= 0; i--) {
            if (dna1.charAt(i) != dna2.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
