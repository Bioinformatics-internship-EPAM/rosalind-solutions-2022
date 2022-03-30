// Transcribing DNA into RNA
// https://rosalind.info/problems/rna/

// Given: A DNA string t having length at most 1000 nt.
// Return: The transcribed RNA string of t.


public class RNA {

    public static String task() {
        String str = ReadFile.resFileToStringList("rosalind_rna.txt").get(0);

        return str.replace('T', 'U');
    }
}
