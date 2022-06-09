package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/*
Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).

Return: The ID of the string having the highest GC-content, followed by the GC-content of that string. Rosalind
        allows for a default error of 0.001 in all decimal answers unless otherwise stated; please see the note
        on absolute error below.
 */
public class GcContent {

    /*
    Computes DNA GC-score. DNA is stored as multiline string list.
     */
    public static double computeGcCount(List<String> dna){
        long gcCount = 0;
        long dnaLength = 0;

        for (String subDna: dna) {
            gcCount += subDna.chars().filter(ch -> ch == 'G' || ch == 'C').count();
            dnaLength += subDna.length();
        }

        return (double) gcCount / (double) dnaLength * 100.;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_gc.txt"));

        double hignestScore = 0;
        String highestScoreName = "None";
        String currScoreName = "None";
        double currScore;
        String listElem;
        List<String> dna = new ArrayList<>();
        boolean assemblingDna = false;

        for (String line : lines) {
            listElem = line;

            if (listElem.matches(">Rosalind_[0-9]{4}")) {
                // checking GC-score
                if (assemblingDna) {
                    currScore = computeGcCount(dna);
                    if (currScore > hignestScore) {
                        hignestScore = currScore;
                        highestScoreName = currScoreName.replace(">", "");
                    }
                }
                currScoreName = listElem;
                dna.clear();

                assemblingDna = true;

            } else {
                dna.add(listElem);
            }

        }
        currScore = computeGcCount(dna);
        if (currScore > hignestScore){
            hignestScore = currScore;
            highestScoreName = currScoreName.replace(">", "");
        }

        Locale.setDefault(Locale.ENGLISH);
        System.out.printf("%s\n%f", highestScoreName, hignestScore);
    }

}
