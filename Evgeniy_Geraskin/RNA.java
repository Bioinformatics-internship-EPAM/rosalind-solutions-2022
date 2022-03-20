import java.io.IOException;

public class RNA {

    public static String solveRNATask () throws IOException {
        var dataSet = Utils.readFromFile("resources/rosalind_rna.txt").get(0);
        return dataSet.replace('T', 'U');
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solveRNATask());
    }
}
