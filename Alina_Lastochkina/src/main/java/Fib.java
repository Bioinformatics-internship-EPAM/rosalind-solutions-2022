public class Fib {
    public static void main(String[] args) {
        long n = 31;
        long k = 3;
        long m = 1;
        long r = 0;
        long tmp = 0;

        for (int i = 1; i < n; i++) {
            tmp = r * k;
            r = r + m;
            m = tmp;

            }
        long sum = m  + r;
        System.out.printf(Long.toString (sum));
        }
    }
