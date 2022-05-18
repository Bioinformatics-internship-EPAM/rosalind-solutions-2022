import java.util.ArrayList;
import java.util.List;

public class Fibd {
    public static void main(String[] args) {
        int n =3; // Integer.parseInt(data[0]);
        int m = 4 ;//Integer.parseInt(data[1]);
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                result.add(1L);
            } else if (i < m) {
                result.add(result.get(i - 1) + result.get(i - 2));
            } else if (i == m) {
                result.add(result.get(i - 1) + result.get(i - 2) - 1);
            } else {
                result.add(result.get(i - 1) + result.get(i - 2) - result.get(i - m - 1));
            }
        }
      //  return result.get(result.size() - 1);
    }
}
