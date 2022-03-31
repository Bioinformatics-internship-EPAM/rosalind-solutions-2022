package models;

import java.util.Scanner;

/**
 * Fast
 * This class used to contain data in FASTA format 
 * (@see https://en.wikipedia.org/wiki/FASTA_format)
 * In addition class calculates GC score 
 * (percentege of 'G' and 'C' presence)
 */
public class Fasta {

    public Fasta(Scanner scanner)
    {
        header = scanner.nextLine();
        StringBuilder tempStr = new StringBuilder();
        while(scanner.hasNextLine() && !scanner.hasNext(">.*"))
        {
            tempStr.append(scanner.nextLine());
        }
        dnaStr = tempStr.toString();

        calculateGcScore();
    }

    public Fasta(String header, String dnaStr)
    {
        this.header = header;
        this.dnaStr = dnaStr;
    }

    public String getHeader()
    {
        return header;
    }

    public String getDnaStr()
    {
        return dnaStr;
    }

    public double getGcScore()
    {
        return gcScore;
    }

    private void calculateGcScore()
    {
        int gcAmount = 0;
        for (char i : dnaStr.toCharArray()) {
            if (i == 'G' || i == 'C')
            {
                gcAmount++;
            }
        }
        gcScore = 100. * gcAmount / dnaStr.length();
    }

    private String header;
    private String dnaStr;
    private double gcScore = -1;
}
