import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.*;  

/*
Translating RNA into Protein
https://rosalind.info/problems/prot/

Sample Dataset: AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA
Sample Output: MAMAPRTEINSTRING
7
*/


public class PROT {

    public static void main(String[] args) {

	Map<String, String> map = new HashMap<>();
    map.put("UUU", "F");      map.put("CUU", "L");   map.put("AUU", "I");   map.put("GUU", "V");
    map.put("UUC", "F");      map.put("CUC", "L");   map.put("AUC", "I");   map.put("GUC", "V");
    map.put("UUA", "L");      map.put("CUA", "L");   map.put("AUA", "I");   map.put("GUA", "V");
    map.put("UUG", "L");      map.put("CUG", "L");   map.put("AUG", "M");   map.put("GUG", "V");
    map.put("UCU", "S");      map.put("CCU", "P");   map.put("ACU", "T");   map.put("GCU", "A");
    map.put("UCC", "S");      map.put("CCC", "P");   map.put("ACC", "T");   map.put("GCC", "A");
    map.put("UCA", "S");      map.put("CCA", "P");   map.put("ACA", "T");   map.put("GCA", "A");
    map.put("UCG", "S");      map.put("CCG", "P");   map.put("ACG", "T");   map.put("GCG", "A");
    map.put("UAU", "Y");      map.put("CAU", "H");   map.put("AAU", "N");   map.put("GAU", "D");
    map.put("UAC", "Y");      map.put("CAC", "H");   map.put("AAC", "N");   map.put("GAC", "D");
    map.put("UAA", "Stop");   map.put("CAA", "Q");   map.put("AAA", "K");   map.put("GAA", "E");
    map.put("UAG", "Stop");   map.put("CAG", "Q");   map.put("AAG", "K");   map.put("GAG", "E");
    map.put("UGU", "C");      map.put("CGU", "R");   map.put("AGU", "S");   map.put("GGU", "G");
    map.put("UGC", "C");      map.put("CGC", "R");   map.put("AGC", "S");   map.put("GGC", "G");
    map.put("UGA", "Stop");   map.put("CGA", "R");   map.put("AGA", "R");   map.put("GGA", "G");
    map.put("UGG", "W");      map.put("CGG", "R");   map.put("AGG", "R");   map.put("GGG", "G"); 


        Scanner scanner = null;
	char[] data;
        
        try {
            File txtFile = new File("data/rosalind_prot.txt");
            scanner = new Scanner(txtFile);
	    data = (scanner.nextLine()).toCharArray();

        } catch (Exception e) {
	    data = null;
        }

	String res = "";	
	for (int i=0; i<data.length-2; i+=3){
	    
	    String check_val = String.valueOf(data[i])+ String.valueOf(data[i+1]) + String.valueOf(data[i+2]);
	    if(map.get(check_val)=="Stop"){
		break;
	    }
	    res += map.get(check_val);
	}

        System.out.println(res);
    }
}
