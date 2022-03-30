import java.nio.file.Files;
import java.nio.file.Paths;
/*
Solution for the task https://rosalind.info/problems/fib/
Sample input: 5 3
Sample output: 19
*/

public class FIB {

    public static void main(String[] args) throws Exception {
        String[] input = new String(Files.readAllBytes(Paths.get("src/main/resources/FIB.txt"))).split(" ");
        Integer months = Integer.parseInt(input[0]);
        Integer offspring = Integer.parseInt(input[1]);
        System.out.println(getResult(months, offspring));
    }

    private static long getResult(Integer months, Integer offspring) {
        return months <= 2 ?
                1 :
                getResult(months - 2, offspring) * offspring + getResult(months - 1, offspring);
    }
}
