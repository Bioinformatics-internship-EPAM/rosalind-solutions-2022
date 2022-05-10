package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsensusAndProfile {

    /*
    Computes profile matrix for DNA
    Matrix is indexed like this:
        [0] A: X X ... X
        [1] C: X X ... X
        [2] G: X X ... X
        [3] T: X X ... X
     */
    public static int[][] computeProfile(List<String> strings){

        int h = strings.size();
        int w = strings.get(0).length();

        String[] matrix = strings.toArray(new String[0]);

        /*
        [0] A: X X ... X
        [1] C: X X ... X
        [2] G: X X ... X
        [3] T: X X ... X
         */
        int[][] profile = new int[4][w];

        for (int col = 0; col < w; col++){
            for (int row = 0; row < h; row++){
                switch (matrix[row].charAt(col)) {
                    case 'A' -> profile[0][col]++;
                    case 'C' -> profile[1][col]++;
                    case 'G' -> profile[2][col]++;
                    case 'T' -> profile[3][col]++;
                }
            }
        }

        return profile;
    }

    public static String computeConsensusString(int[][] profile){

        char[] consensus = new char[profile[0].length];

        for (int col = 0; col < profile[0].length; col++){
            int maxVal = 0;
            int maxIdx = -1;

            for (int row = 0; row < 4; row++){
                if (profile[row][col] > maxVal){
                    maxIdx = row;
                    maxVal = profile[row][col];
                }
            }

            switch (maxIdx){
                case 0 -> consensus[col] = 'A';
                case 1 -> consensus[col] = 'C';
                case 2 -> consensus[col] = 'G';
                case 3 -> consensus[col] = 'T';
            }
        }

        return String.copyValueOf(consensus);
    }

    public static void printProfileMatrix(int[][] profile){
        char[] nucleotydes = {'A', 'C', 'G', 'T'};

        for (int row = 0; row < 4; row++){
            System.out.printf("%s: ", nucleotydes[row]);
            for (int col = 0; col < profile[0].length; col++){
                System.out.printf("%d ", profile[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> data = Files.readAllLines(Paths.get("Jegor_Rusakow/src/resources/rosalind_cons.txt"));
        List<String> dnas = new ArrayList<>();


        // making list of only DNAs
        Iterator<String> iter = data.listIterator(1);
        StringBuilder dnaBuilder = new StringBuilder();

        while (iter.hasNext()){
            String line = iter.next();
            if (line.matches(">Rosalind_[0-9]{4}")){
                dnas.add(dnaBuilder.toString());
                dnaBuilder.setLength(0);
            } else {
                dnaBuilder.append(line);
            }
        }
        dnas.add(dnaBuilder.toString());

        int[][] profile = computeProfile(dnas);
        String consensusString = computeConsensusString(profile);

        System.out.println(consensusString);
        printProfileMatrix(profile);
    }
}
