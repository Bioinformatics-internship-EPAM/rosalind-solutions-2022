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
