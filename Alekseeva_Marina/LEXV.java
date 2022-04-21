import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Ordering Strings of Varying Length Lexicographically
https://rosalind.info/problems/lexv/

Sample Dataset: 
D N A
3
Sample Output: 
D
DD
DDD
DDN
DDA
DN
DND
DNN
DNA
DA
DAD
DAN
DAA
N
ND
NDD
NDN
NDA
NN
NND
NNN
NNA
NA
NAD
NAN
NAA
A
AD
ADD
ADN
ADA
AN
AND
ANN
ANA
AA
AAD
AAN
AAA
*/

public class LEXV {

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
            File txtFile = new File("data/rosalind_lexv.txt");
            scanner = new Scanner(txtFile);
	    data = (scanner.nextLine()).replace(" ", "").toCharArray();
	    n = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
	    data = null;
	    n = 0;
        }

	ArrayList<String> res =  new ArrayList<> ();
 	for (int i=n; i>0; i--)
	    res.addAll(help (data, i));
	
	res.sort(Comparator.naturalOrder());
        System.out.println(res);
    }


}
