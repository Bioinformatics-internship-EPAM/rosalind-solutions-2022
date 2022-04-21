import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Counting Point Mutations 
https://rosalind.info/problems/prtm/

Sample Dataset: SKADYEK
Sample Output: 821.392
7
*/

public class PRTM {

    public static void main(String[] args) {

	Map<String, String> map = new HashMap<>();
	map.put("A", "71.03711"); 
	map.put("C", "103.00919");
	map.put("D", "115.02694");
	map.put("E", "129.04259");
	map.put("F", "147.06841");
	map.put("G", "57.02146");
	map.put("H", "137.05891");
	map.put("I", "113.08406");
	map.put("K", "128.09496");
	map.put("L", "113.08406");
	map.put("M", "131.04049");
	map.put("N", "114.04293");
	map.put("P", "97.05276");
	map.put("Q", "128.05858");
	map.put("R", "156.10111");
	map.put("S", "87.03203");
	map.put("T", "101.04768");
	map.put("V", "99.06841");
	map.put("W", "186.07931");
	map.put("Y", "163.06333");

        Scanner scanner = null;
	char[] data;
        
        try {
            File txtFile = new File("data/rosalind_prtm.txt");
            scanner = new Scanner(txtFile);
	    data = (scanner.nextLine()).toCharArray();

        } catch (Exception e) {
	    data = null;
        }

	float count = 0;
	for (int i=0; i<data.length; i++){
	    count += Float.parseFloat(map.get(String.valueOf(data[i])));
	}

        System.out.println(count);
    }
}
