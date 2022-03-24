package testofbioinfo;

import java.util.Scanner;

public class RabbitsandRecurrenceRelations {
    public static void main(String[] args) {
        System.out.println("Rabbit Sand Recurrence Relations");
        System.out.println("enter numbers");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m =s.nextInt();
        long amountRabbit = CountRabbitPairs(n,m);
        System.out.println(amountRabbit);

    }

    public static long CountRabbitPairs(int months, int fertility){
        if(months == 1){
            return 1;
        }
        if(months ==2 ){
            return fertility;
        }
        long firstGenarate = CountRabbitPairs(months -1 ,fertility);
        long seceondGenarate = CountRabbitPairs(months-2,fertility);

        if(months<=4){
            return(firstGenarate+seceondGenarate);
        }
        return (firstGenarate+(seceondGenarate*fertility));
    }
}
