import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;

/*
Counting DNA Nucleotides
https://rosalind.info/problems/dna/

Sample Dataset: AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC
Sample Output: 20 12 17 21
(в файле rosalind_ini.txt лежит другой датасет, скаченный с rosalind)
*/

public class DNA {

    public static void main(String[] args) {
        Scanner scanner = null;
	String dnaStr = "";
        
        try {
            File txtFile = new File("data/rosalind_dna.txt");
            scanner = new Scanner(txtFile);
	    dnaStr = scanner.nextLine() + " ";

        } catch (Exception e) {
        }

        int a = dnaStr.split("A").length-1;
        int c = dnaStr.split("C").length-1;
        int g = dnaStr.split("G").length-1;
        int t = dnaStr.split("T").length-1;

        System.out.printf("%d %d %d %d", a, c, g, t);
    }
}
