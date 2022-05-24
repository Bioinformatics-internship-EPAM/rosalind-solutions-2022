import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class gc {
    public static void main(String[] args) throws FileNotFoundException {
        File unknownDNA = new File("resources/rosalind_gc.txt");
        Scanner scanner = new Scanner(unknownDNA);
        String stringID = "";
        double gcContent = 0;

        while (scanner.useDelimiter(Pattern.compile("(\\n)")).hasNext()){
            double gcCountCurr = 0;
            String stringIDCurr = scanner.useDelimiter(Pattern.compile("(\\n)")).nextLine().substring(1);
            String dnaStringCurr = scanner.useDelimiter(">").next().replaceAll("\\n", "");

            for (int i = 0; i < dnaStringCurr.length(); i++){
                if (dnaStringCurr.charAt(i) == 'G' || dnaStringCurr.charAt(i) == 'C'){
                    gcCountCurr++;
                }
            }

            double gcContentCurr = gcCountCurr / dnaStringCurr.length();

            if (gcContentCurr > gcContent){
                gcContent = gcContentCurr;
                stringID = stringIDCurr;
            }
        }

        System.out.println(stringID);
        System.out.printf("%.6f", gcContent*100);
    }
}
