package testofbioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

 // https://rosalind.info/problems/prtm/


//Given: A protein string P of length at most 1000 aa.
//Return: The total weight of P. Consult the monoisotopic mass table.


public class CalculatingProteinMass {
    public static void main(String[] args) {
        List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\PRTM.txt"),
                StandardCharsets.UTF_8);
        String pro = lines.get(0);
        System.out.println("Calculating Protein Mass");
        System.out.println(SumMass(pro));
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static float SumMass(String pro) {
        float sum = 0;
        for (int i = 0; i < pro.length(); i++) {
            String AA = pro.substring(i, i + 1);
            switch (AA) {
                case "A":
                    sum += 71.03711;
                    break;
                case "C":
                    sum += 103.00919;
                    break;
                case "D":
                    sum += 115.02694;
                    break;
                case "E":
                    sum += 129.04259;
                    break;
                case "F":
                    sum += 147.06841;
                    break;
                case "G":
                    sum += 57.02146;
                    break;
                case "H":
                    sum += 137.05891;
                    break;
                case "I":
                    sum += 113.08406;
                    break;
                case "K":
                    sum += 128.09496;
                    break;
                case "L":
                    sum += 113.08406;
                    break;
                case "M":
                    sum += 131.04049;
                    break;
                case "N":
                    sum += 114.04293;
                    break;
                case "P":
                    sum += 97.05276;
                    break;
                case "Q":
                    sum += 128.05858;
                    break;
                case "R":
                    sum += 156.10111;
                    break;
                case "S":
                    sum += 87.03203;
                    break;
                case "T":
                    sum += 101.04768;
                    break;
                case "V":
                    sum += 99.06841;
                    break;
                case "W":
                    sum += 186.07931;
                    break;
                case "Y":
                    sum += 163.06333;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }
}


