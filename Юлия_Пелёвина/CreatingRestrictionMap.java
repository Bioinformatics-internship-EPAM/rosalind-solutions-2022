package com.company;

import java.util.*;

public class CreatingRestrictionMap {

    public static boolean isSortedAndUnique(int[] a) {
        for (int i=0; i<a.length-1; i++)
            if (a[i] >= a[i+1])
                return false;
        return true;
    }

    public static boolean notContainElement(int[] a, int b) {
        for (int j : a)
            if (j == b)
                return false;
        return true;
    }

    public static int[] differencesBetweenElementsOfSet(int[] a) {
        int[] r = new int[a.length*(a.length-1)/2];
        int k = 0;
        for (int i=0; i<a.length; i++)
            for (int j=i+1; j<a.length; j++) {
                r[k] = a[j] - a[i];
                k+=1;
            }
        return r;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            String[] sarr = s.split(" ");
            int[] L = new int[sarr.length];
            for (int i = 0; i < L.length; i++)
                L[i] = Integer.parseInt(sarr[i]);
            HashSet<Integer> set = new HashSet<>();
            for (int k : L) set.add(k);
            double len = (1+Math.sqrt(1+8*L.length))/2;
            boolean isPositive = true;
            for (int k : L)
                if (k <= 0) {
                    isPositive = false;
                    break;
                }
            if (len - Math.floor(len) == 0 && isPositive) {
                int lenWord = (int) len - 2;
                Integer[] alphabet = set.toArray(new Integer[0]);
                int[] seq = new int[(int) Math.pow(alphabet.length, lenWord)];
                for (int i = 0; i < seq.length; i++)
                    seq[i] = i;
                int[][] iWords = new int[seq.length][lenWord];
                for (int i = 0; i < iWords.length; i++) {
                    int p = lenWord - 1;
                    int n = seq[i];
                    for (int j = 0; j < iWords[i].length; j++) {
                        iWords[i][j] = n / (int) Math.pow(alphabet.length, p);
                        n %= (int) Math.pow(alphabet.length, p);
                        p -= 1;
                    }
                }
                ArrayList<int[]> arrayList = new ArrayList<>();
                for (int[] iWord : iWords)
                    if (isSortedAndUnique(iWord) && notContainElement(iWord, alphabet.length-1))
                        arrayList.add(iWord);
                int[][] results = new int[arrayList.size()][lenWord+2];
                for (int i=0; i<results.length; i++) {
                    results[i][0] = 0;
                    results[i][results[i].length-1] = Collections.max(set);
                    for (int j=1; j<results[i].length-1; j++)
                        results[i][j] = alphabet[arrayList.get(i)[j-1]];
                }
                for (int[] result : results) {
                    int[] a = differencesBetweenElementsOfSet(result);
                    Arrays.sort(a);
                    if (Arrays.equals(L, a)) {
                        StringBuilder str = new StringBuilder();
                        for (int i : result) str.append(i).append(" ");
                        System.out.println(str);
                        break;
                    }
                }
            }
            else
                System.out.println("Not positive number was entered or multiset has wrong length");
        }
        catch (NumberFormatException e) {
            System.err.println("Not integer number was entered");
        }
    }
}
