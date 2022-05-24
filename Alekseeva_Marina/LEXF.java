import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Enumerating k-mers Lexicographically
https://rosalind.info/problems/lexf/

Sample Dataset: 
A C G T
2
Sample Output: 
AA
AC
AG
AT
CA
CC
CG
CT
GA
GC
GG
GT
TA
TC
TG
TT
*/

public class LEXF {
     public static ArrayList<String> help(char[] data, int n_) {
	if(n_ == 0) {ArrayList<String> arr = new ArrayList<String> (); arr.add(""); return arr;}
	
	ArrayList<String> sub_res = help(data, n_ -1);
	ArrayList<String> res = new ArrayList<String>();

	for  (int i=0; i<data.length; i++)
		for  (int j=0; j<sub_res.size(); j++)
			res.add(String.valueOf(data[i] + sub_res.get(j)));	
	return res;

	}


    public static void main(String[] args) {
        Scanner scanner = null;
	char[] data;
	int n;
        
        try {
            File txtFile = new File("data/rosalind_lexf.txt");
            scanner = new Scanner(txtFile);
	    data = (scanner.nextLine()).replace(" ", "").toCharArray();
	    n = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
	    data = null;
	    n = 0;
        }
	ArrayList<String> res =help (data, n);	

	res.sort(Comparator.naturalOrder());
        System.out.println(res);
    }
}
