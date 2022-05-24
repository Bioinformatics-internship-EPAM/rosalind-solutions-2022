import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Enumerating Gene Orders
https://rosalind.info/problems/perm/
Given: A positive integer n≤7

Sample Dataset: 3
Sample Output: 
6
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
*/

public class PERM {
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
	int n;
        
        try {
            File txtFile = new File("data/rosalind_perm.txt");
            scanner = new Scanner(txtFile);
	    n = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
	    n = 0;
        }
	String temp_data = "";
	for (int i = 1; i <= n; i++)
		temp_data+=String.valueOf(i);

	ArrayList<String> res =help (temp_data.toCharArray(), n);
	ArrayList<String> dublic_res =help (temp_data.toCharArray(), n);
	
	for (int i = res.size()-1; i >=0 ; i --){
		for  (int j=n; j>0; j--)
			if ((res.get(i) + " ").split(String.valueOf(j)).length -1 > 1) 
				dublic_res.remove(i); }

	dublic_res.sort(Comparator.naturalOrder());

	System.out.println(dublic_res.size());
	for  (int i=0; i<dublic_res.size(); i++)
		System.out.println(dublic_res.get(i).replace("", " "));
    }
}
