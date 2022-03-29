import java.util.Scanner;

public class IntroductiontotheBioinformaticsArmory{
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine().toUpperCase();
        int a, g, c, t;
        a=g=c=t=0;
        
        for (int i = 0; i < n.length(); i++)
        {
            switch(n.charAt(i))
            {
                case 'A':
                    a++;
                    break;
                case 'G':
                    g++;
                    break;
                case 'C':
                    c++;
                    break;
                case 'T':
                    t++;
                    break;
                default:
                    System.out.print("Неопознаный символ: " + n.charAt(i));
                    return;
            }
        }
        System.out.printf("%d %d %d %d\n", a, c, g, t);
    }
}
