import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
/*
Solution for the task https://rosalind.info/problems/fibd/
Sample input: 6 3
Sample output: 4
*/

public class FIBD {

    private static final String FILEPATH = "src/resources/MortalFibonacciRabbits.txt";

    public static void main(String[] args) throws Exception {
        String[] input = new String(Files.readAllBytes(Paths.get("src/main/resources/FIBD.txt"))).split(" ");
        Integer months = Integer.parseInt(input[0]);
        Integer lifetime = Integer.parseInt(input[1]);
        System.out.println(getResult(months, lifetime));
    }

    private static BigInteger getResult(Integer months, Integer lifetime) {
        ArrayList<BigInteger> count = new ArrayList();
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < months; i++) {
            if (i < 2) {
                count.add(i, BigInteger.ONE);
            } else if (i < lifetime) {
                count.add(i, (BigInteger) count.get(i - 2).add((BigInteger) count.get(i - 1)));
            } else if (i == lifetime) {
                count.add(i, (BigInteger) count.get(i - 2).add((BigInteger) count.get(i - 1).subtract(BigInteger.ONE)));
            } else {
                count.add(i, (BigInteger) count.get(i - 2).add((BigInteger) count.get(i - 1).subtract((BigInteger) count.get(i - lifetime - 1))));
                count.set(i - lifetime - 1, BigInteger.ZERO);
            }
            result = (BigInteger) count.get(i);
        }
        return result;
    }
}
