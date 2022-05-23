import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class subs {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Integer> indicesOfTarget = new LinkedList<>();

         File dataset = new File("resources/rosalind_subs.txt");
         Scanner scanner = new Scanner(dataset);
         String initialString = scanner.nextLine();
         String targetString = scanner.nextLine();

        int previousIndex = 0;
        while (initialString.substring(previousIndex, initialString.length()-1).contains(targetString)){
            int currentIndex = initialString.indexOf(targetString, previousIndex);
            if (currentIndex == 0){
                indicesOfTarget.add(currentIndex);
                previousIndex++;
            } else if (currentIndex != previousIndex){
                indicesOfTarget.add(currentIndex);
                previousIndex = currentIndex;
            } else {
                previousIndex++;
            }
        }

        if (!indicesOfTarget.isEmpty()){
            for (Integer x: indicesOfTarget){
                System.out.print(x + 1 + " ");
            }
        }
    }
}
