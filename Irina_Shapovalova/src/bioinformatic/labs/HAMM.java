package bioinformatic.labs;

/* https://rosalind.info/problems/hamm/ */
public class HAMM {
    public static int solution(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count;
    }
}
