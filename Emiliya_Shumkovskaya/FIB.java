public class FIB {
    int reproduce(int n, int k) {
        if(n==1) {
            return 1;
        } else
        if(n==2) {
            return 1;
        } else {
            return reproduce(n-1, k) + reproduce(n-2, k) * k;
        }
    }
}
