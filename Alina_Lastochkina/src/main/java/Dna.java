import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class Dna {
    static private String path = "src/main/resources/rosalind_dna.txt";
    public static void main(String[] args) {

        int aCount = 0;
        int cCount = 0;
        int gCount = 0;
        int tCount = 0;
        String dnaStr = null;
        try {
            dnaStr = Files.readAllLines(Path.of(path)).get(0);
        }
        catch (Exception e) { System.out.printf("Error"); }
        for (char C : dnaStr.toCharArray()) {
            switch (C) {
                case 'A':
                    aCount++;
                    break;
                case 'C':
                    cCount++;
                    break;
                case 'G':
                    gCount++;
                    break;
                case 'T':
                    tCount++;
                    break;
                default:
                    System.out.println("Unrecognized token " + C);
                    break;
            }
        }

        System.out.printf("%d %d %d %d",  aCount, cCount, gCount, tCount);
    }
}

