import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class lcsm {
    public static void main(String[] args) throws FileNotFoundException {

        File dataset = new File("resources/rosalind_lcsm.txt");
        Scanner scanner = new Scanner(dataset);
        ArrayList<String> DNAstrings = new ArrayList<>();

        scanner.useDelimiter(Pattern.compile("(\\n)")).nextLine();
        String firstDNA = scanner.useDelimiter(">").next().replaceAll("\\n", "");

        while (scanner.useDelimiter(Pattern.compile("(\\n)")).hasNext()){
            scanner.useDelimiter(Pattern.compile("(\\n)")).nextLine();
            DNAstrings.add(scanner.useDelimiter(">").next().replaceAll("\\n", ""));
        }

        String longestCommonDNA = "";

        for (int i = 0; i < firstDNA.length(); i++){
            for (int j = i+1; j < firstDNA.length(); j++){
                String common = firstDNA.substring(i, j);
                boolean allInclude = true;
                for (int k = 0; k < DNAstrings.size(); k++){
                    if (DNAstrings.get(k).contains(common) == false){
                        allInclude = false;
                        break;
                    }
                }
                if (allInclude == true && common.length() > longestCommonDNA.length()){
                    longestCommonDNA = common;
                }
            }
        }

        System.out.println(longestCommonDNA);
    }
}
