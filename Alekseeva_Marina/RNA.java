import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;

/*
Transcribing DNA into RNA
https://rosalind.info/problems/rna/

Sample Dataset: GATGGAACTTGACTACGTAAATT
Sample Output: GAUGGAACUUGACUACGUAAAUU
*/

public class RNA {

    public static void main(String[] args) {
        Scanner scanner = null;
	String dnaStr = "";
        
        try {
            File txtFile = new File("data/rosalind_rna.txt");
            scanner = new Scanner(txtFile);
	    dnaStr = scanner.nextLine();

        } catch (Exception e) {
        }
	String res = dnaStr.replace('T', 'U');

        System.out.println(res);
    }
}
