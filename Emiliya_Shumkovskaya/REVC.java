// https://rosalind.info/problems/revc/

//Given: A DNA string s of length at most 1000 bp.
//Return: The reverse complement of s.

public class REVC {
    public String getStrand(String dna){
        String strand = "";
       for(int i = dna.length() - 1; i >= 0; i--) {
           char c = dna.charAt(i);
           switch (c) {
               case 'A' -> strand += 'T';
               case 'T' -> strand += 'A';
               case 'C' -> strand += 'G';
               case 'G' -> strand += 'C';
               default -> System.out.println("Wrong DNA");
           }
       }
        return strand;
    }
}
