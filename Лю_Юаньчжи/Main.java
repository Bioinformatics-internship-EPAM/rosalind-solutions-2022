import task.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Counting DNA Nucleotides:");
        CountingDNANucleotides.countNucleotides("resources/rosalind_dna.txt");
		
	System.out.println("Transcribing DNA into RNA:");
        TranscribingDNAintoRNA.transcribeDNA("resources/rosalind_rna.txt");
	}

}
