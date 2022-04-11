// https://rosalind.info/problems/rna/

//Given: A DNA string t having length at most 1000 nt.
//Return: The transcribed RNA string of t.

public class RNA {
    public String getRNA(String dna){
        return dna.replace('T', 'U');
    }
}
