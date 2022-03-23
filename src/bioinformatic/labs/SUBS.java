package bioinformatic.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* https://rosalind.info/problems/subs/ */
public class SUBS {

    public static List<Integer> solution(String str, String substr) {
        List<Integer> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?=(" + substr + "))");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            result.add(matcher.start() + 1);
        }

        return result;
    }
}
