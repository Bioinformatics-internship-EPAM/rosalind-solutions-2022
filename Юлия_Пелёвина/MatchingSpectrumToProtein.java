package com.company;

import java.util.*;
import java.util.regex.Pattern;

public class MatchingSpectrumToProtein {

    public static float countStringWeight(String s) {
        float w=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='A')
                w+=71.03711;
            else if (s.charAt(i)=='C')
                w+=103.00919;
            else if (s.charAt(i)=='D')
                w+=115.02694;
            else if (s.charAt(i)=='E')
                w+=129.04259;
            else if (s.charAt(i)=='F')
                w+=147.06841;
            else if (s.charAt(i)=='G')
                w+=57.02146;
            else if (s.charAt(i)=='H')
                w+=137.05891;
            else if (s.charAt(i)=='I')
                w+=113.08406;
            else if (s.charAt(i)=='K')
                w+=128.09496;
            else if (s.charAt(i)=='L')
                w+=113.08406;
            else if (s.charAt(i)=='M')
                w+=131.04049;
            else if (s.charAt(i)=='N')
                w+=114.04293;
            else if (s.charAt(i)=='P')
                w+=97.05276;
            else if (s.charAt(i)=='Q')
                w+=128.05858;
            else if (s.charAt(i)=='R')
                w+=156.10111;
            else if (s.charAt(i)=='S')
                w+=87.03203;
            else if (s.charAt(i)=='T')
                w+=101.04768;
            else if (s.charAt(i)=='V')
                w+=99.06841;
            else if (s.charAt(i)=='W')
                w+=186.07931;
            else if (s.charAt(i)=='Y')
                w+=163.06333;
        }
        return w;
    }

    public static ArrayList<Float> prefixAndSuffix(String s) {
        ArrayList<String> ps = new ArrayList<>();
        for (int i=1; i<s.length(); i++)
            ps.add(s.substring(0,i));
        for (int i=1; i<s.length(); i++)
            ps.add(s.substring(i));
        ps.add(s);
        ArrayList<Float> wps = new ArrayList<>();
        for (String p : ps) wps.add(countStringWeight(p));
        return wps;
    }

    public static ArrayList<Float> differenceMinkowski(ArrayList<Float> R, ArrayList<Float> w) {
        ArrayList<Float> md = new ArrayList<>();
        for (Float v : R)
            for (Float v1 : w)
                md.add(v-v1);
        return md;
    }

    public static int getMax(int[] a) {
        int m=a[0];
        for (int i=1; i<a.length; i++)
            if (a[i] > m)
                m=a[i];
        return m;
    }



    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            String[] s = new String[n];
            for (int i = 0; i < n; i++)
                s[i] = in.nextLine();
            String f = in.nextLine();
            String[] farr = f.split(" ");
            ArrayList<Float> R = new ArrayList<>();
            for (String value : farr) R.add(Float.parseFloat(value));
            String regexProtein = "[ACDEFGHIKLMNPQRSTVWY]+";
            boolean isProtein = true;
            for (String value : s)
                if (!Pattern.matches(regexProtein, value)) {
                    isProtein = false;
                    break;
                }
            if (isProtein) {
                ArrayList<Float>[] weightedSubstrings = new ArrayList[n];
                for (int i = 0; i < n; i++)
                    weightedSubstrings[i] = new ArrayList<Float>(prefixAndSuffix(s[i]));
                ArrayList<Float>[] md = new ArrayList[n];
                for (int i = 0; i < n; i++)
                    md[i] = new ArrayList<Float>(differenceMinkowski(R, weightedSubstrings[i]));
                HashMap<Float, Integer>[] maps = new HashMap[n];
                for (int i = 0; i < n; i++)
                    maps[i] = new HashMap<Float, Integer>();
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < md[i].size(); j++)
                        maps[i].put(md[i].get(j), 0);
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < md[i].size(); j++)
                        maps[i].replace(md[i].get(j), maps[i].get(md[i].get(j)) + 1);
                int[] localMax = new int[n];
                for (int i = 0; i < n; i++)
                    localMax[i] = Collections.max(maps[i].values());
                System.out.println(getMax(localMax));
                for (int i = 0; i < n; i++)
                    if (localMax[i] == getMax(localMax)) {
                        System.out.println(s[i]);
                        break;
                    }
            }
            else
                System.out.println("Protein strings are wrong");
        }
        catch (InputMismatchException e) {
            System.err.println("Вводилось не целое число");
        }
        catch (NumberFormatException e) {
            System.err.println("Вводилось не число");
        }
    }
}
