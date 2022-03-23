package bioinformatic.labs;

import java.util.stream.Collectors;

/* https://rosalind.info/problems/revc/ */
public class REVC {
    public static String solution(String DNA) {
        return new StringBuilder(DNA)
                .reverse()
                .toString()
                .chars()
                .mapToObj(i -> (char) i)
                .map(REVC::replace)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private static char replace(char c) {
        switch (c) {
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
            default:  return c;
        }
    }
}
