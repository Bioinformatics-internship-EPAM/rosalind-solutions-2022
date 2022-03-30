package testofbioinfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//https://rosalind.info/problems/fibd/

//Given: Positive integers n≤100 and m≤20.
//Return: The total number of pairs of rabbits that will remain after the n-th month if all rabbits live for m months.

public class MortalFibonacciRabbits{
    public static void main(String[] args) throws IOException {
        List<String>lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\FIBD.txt"),
                StandardCharsets.UTF_8);
        String data = lines.get(0);
        System.out.println("Mortal Fibonacci Rabbits");
        System.out.println(data);
        System.out.println(MortalFR(data));
    }
    public static long MortalFR(String database){
        String[] data = database.split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        List<Long> s =new ArrayList<>();
        for(int i =0;i<n;i++){
            if(i<2){
                s.add(1L);
            }else if(i<m){
                s.add(s.get(i-1)+s.get(i-2));
            }else if(i==m){
                s.add(s.get(i-1)+s.get(i-2)-1);
            }else{
                s.add(s.get(i-1)+s.get(i-2)-s.get(i-m-1));
            }
        }
        return s.get(s.size()-1);
    }
}
