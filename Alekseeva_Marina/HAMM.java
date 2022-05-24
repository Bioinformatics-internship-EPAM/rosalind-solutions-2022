import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;

/*
Counting Point Mutations 
https://rosalind.info/problems/hamm/

Sample Dataset: 
GAGCCTACTAACGGGAT
CATCGTAATGACGGCCT
Sample Output: 
7
*/

public class HAMM {

    public static void main(String[] args) {
        Scanner scanner = null;
	char[] first;
	char[] second;
        
        try {
            File txtFile = new File("data/rosalind_hamm.txt");
            scanner = new Scanner(txtFile);
	    first = (scanner.nextLine()).toCharArray();
	    second = (scanner.nextLine()).toCharArray();

        } catch (Exception e) {
	    first = null;
	    second = null;
        }

	int count = 0;
	for (int i=0; i<first.length; i++){
	    if(first[i]!=second[i]){
		count++;
	    }
	}

        System.out.printf("%d", count);
    }
}
