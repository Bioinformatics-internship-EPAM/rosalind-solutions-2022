import java.nio.file.Files;
import java.nio.file.Path;

public class perm {
    static private String path = "src/main/resources/rosalind_perm.txt";
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void main(String[] args) {
        Integer it = 6;
        /*try {
            it = Files.readAllLines(Path.of(path)).get(0);;
        }
        catch (Exception e) { System.out.printf("Error"); }*/

        String t = "";
        for (int i =1; i<= it.intValue(); i++)
        {
            t = t + Integer.toString(i);
        }
        permutation(t);
    }
}
