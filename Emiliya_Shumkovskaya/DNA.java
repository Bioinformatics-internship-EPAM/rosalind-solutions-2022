//https://rosalind.info/problems/dna/

//Given: A DNA string s of length at most 1000 nt.

//Return: Four integers (separated by spaces) counting the respective number
// of times that the symbols 'A', 'C', 'G', and 'T' occur in s.

public class DNA {
    private int countA = 0;
    private int countC = 0;
    private int countG = 0;
    private int countT = 0;

    public void setDNA(String str)
    {
        countA = 0;
        countC = 0;
        countG = 0;
        countT = 0;
        for (char element : str.toCharArray()){
            switch(element) {
                case 'A' -> countA++;
                case 'C' -> countC++;
                case 'G' -> countG++;
                case 'T' -> countT++;
                default -> throw new IllegalStateException("Unexpected value: " + element);
            }
        }
    }
    public void printResult()
    {
        System.out.printf("%d %d %d %d\n", countA, countC, countG, countT);
    }

    public int getCountA() {
        return countA;
    }

    public int getCountC() {
        return countC;
    }

    public int getCountG() {
        return countG;
    }

    public int getCountT() {
        return countT;
    }
}
