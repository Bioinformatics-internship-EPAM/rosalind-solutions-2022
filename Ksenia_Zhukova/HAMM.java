import java.util.List;

public class HAMM {

    public static int task() {
        List<String> src = ReadFile.resFileToStringList("rosalind_hamm.txt");
        String first = src.get(0);
        String second = src.get(1);

        int counter = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                counter++;
        }

        return counter;
    }
}
