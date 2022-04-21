import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Finding a Motif in DNA
https://rosalind.info/problems/subs/

Sample Dataset: 
GATATATGCATATACTT
ATAT

Sample Output: 2 4 10
7
*/


public class SUBS {

    public static void main(String[] args) {
        Scanner scanner = null;
	String str;
	String substr;
        
        try {
            File txtFile = new File("data/rosalind_subs.txt");
            scanner = new Scanner(txtFile);
	    str = scanner.nextLine();
	    substr = scanner.nextLine();

        } catch (Exception e) {
	    str = "";
	    substr = "";
        }

	ArrayList<Integer> res = new ArrayList<Integer>();
	int index = str.indexOf(substr);
	while(index!=-1){
	    res.add(index+1);
	    index = str.indexOf(substr, index+1);
	}

        System.out.println(res);
    }
}
