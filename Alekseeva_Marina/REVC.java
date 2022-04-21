import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Counting Point Mutations 
https://rosalind.info/problems/revc/

Sample Dataset: AAAACCCGGT
Sample Output: ACCGGGTTTT
7
*/

public class REVC {

    public static void main(String[] args) {

	Map<String, String> map = new HashMap<>();
        Scanner scanner = null;
	String data;
        
        try {
            File txtFile = new File("data/rosalind_revc.txt");
            scanner = new Scanner(txtFile);
	    data = scanner.nextLine();

        } catch (Exception e) {
	    data = "";
        }

	data = data.replace("A", "X");
	data = data.replace("T", "A");
	data = data.replace("X", "T");

	data = data.replace("C", "X");
	data = data.replace("G", "C");
	data = data.replace("X", "G");
	
	char[] temp = data.toCharArray();
	String res = "";
	for (int i = temp.length - 1; i >= 0; i--)
		res += String.valueOf(temp[i]);

        System.out.println(res);
    }
}
