package bioinformatic.labs;

import java.util.stream.Collectors;

/* https://rosalind.info/problems/rna/ */
public class RNA {
    public static String solution(String DNA) {
        return DNA
                .chars()
                .mapToObj(i -> (char) i)
                .map(RNA::replace)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private static char replace(char c) {
        return c == 'T' ? 'U' : c;
    }
}
