package testofbioinfo;

import java.util.Scanner;

//https://rosalind.info/problems/fib/

//Given: Positive integers n≤40 and k≤5.
//Return: The total number of rabbit pairs that will be present after n months, 
//if we begin with 1 pair and in each generation, every pair of reproduction-age rabbits produces a litter of k rabbit pairs (instead of only 1 pair).

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
