package testofbioinfo;

import java.util.Scanner;

public class MendelsFirstLaw {
    public static void main(String[] args) {
        System.out.println("MendelsFristLaw");
        System.out.println("please enter numbers");
        Scanner s = new Scanner(System.in);
        double k =s.nextInt();
        double m = s.nextInt();
        double n = s.nextInt();
        System.out.println(mendel_first_law(k,m,n));
    }
    public static double mendel_first_law(double k,double m,double n){
        double t =k+m+n;
        return 1
                - m / t * (m - 1) / (t - 1) * 0.25
                - n / t * (n - 1) / (t - 1)
                - m / t * n / (t - 1);
    }
}
