import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class dna {

    private static int countChar(String string, char character){
        int count = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == character){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File dataset = new File("resources/rosalind_dna.txt");
        Scanner scanner = new Scanner(dataset);
        while (scanner.hasNextLine()){
            String nucleotides = scanner.nextLine();
            int A = countChar(nucleotides, 'A');
            int C = countChar(nucleotides, 'C');
            int G = countChar(nucleotides, 'G');
            int T = countChar(nucleotides, 'T');
            System.out.println(A + " " + C + " " + G + " " + T);
        }
    }
}
