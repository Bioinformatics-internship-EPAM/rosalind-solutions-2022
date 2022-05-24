import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class revc {

    private static StringBuilder reverse (String initial){
        StringBuilder reversed = new StringBuilder(initial);
        reversed = reversed.reverse();
        return reversed;
    }

    private static StringBuilder compliment (StringBuilder reversed){
        StringBuilder complimented = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++){
            if (reversed.charAt(i) == 'A'){
                complimented.append('T');
            } else if (reversed.charAt(i) == 'T'){
                complimented.append('A');
            } else if (reversed.charAt(i) == 'C'){
                complimented.append('G');
            } else if (reversed.charAt(i) == 'G'){
                complimented.append('C');
            }
        }
        return complimented;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File dataset = new File("resources/rosalind_revc.txt");
        Scanner scanner = new Scanner(dataset);
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            StringBuilder reversed = reverse(data);
            StringBuilder complimented = compliment(reversed);
            System.out.println(complimented);
        }
    }
}
