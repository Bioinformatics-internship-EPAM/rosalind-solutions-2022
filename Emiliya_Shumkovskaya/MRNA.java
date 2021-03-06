// https://rosalind.info/problems/mrna/
//Given: A protein string of length at most 1000 aa.
//Return: The total number of different RNA strings from which the protein could have been translated,
// modulo 1,000,000. (Don't neglect the importance of the stop codon in protein translation.)


public class MRNA {

    private final int modulo = 1000000;

    int countRNAnum(String protein) {
        int counter = 1;
        for(int i = protein.length() - 1; i >= 0; i--) {
            char c = protein.charAt(i);
            switch (c) {
                case 'M', 'W' -> counter *= 1;
                case 'H', 'Q', 'D', 'E', 'Y', 'C', 'F', 'N', 'K' -> counter *= 2;
                case 'I' -> counter*=3;
                case  'P', 'A', 'G', 'V', 'T' -> counter *= 4;
                case 'R', 'L', 'S' -> counter *= 6;
                default -> throw new IllegalStateException("Unexpected value: " + protein.toString());
            }
            if(counter>modulo){
                counter%=modulo;
            }
        }
        counter *= 3;
        counter %= modulo;
        return counter;
    }
}
