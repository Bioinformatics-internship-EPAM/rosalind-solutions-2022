import task.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Counting DNA Nucleotides:");
        CountingDNANucleotides.countNucleotides("resources/rosalind_dna.txt");
		
	System.out.println("Transcribing DNA into RNA:");
        TranscribingDNAintoRNA.transcribeDNA("resources/rosalind_rna.txt");
		
	System.out.println("Complementing a Strand of DNA:");
        ComplementingaStrandofDNA.complementDNA("resources/rosalind_revc.txt");
		
	System.out.println("Calculating Rabbit Pairs:");
        RabbitsandRecurrenceRelations.calculateRabbitPairs("resources/rosalind_fib.txt");
		
	System.out.println("Counting Point Mutations:");
        CountingPointMutations.countMutations("resources/rosalind_hamm.txt");
		
	System.out.println("Mendel's First Law:");
        MendelsFirstLaw.calculateProbability ("resources/rosalind_iprb.txt");
		
	System.out.println("Finding a Motif in DNA:");
        FindingaMotifinDNA.findMotif("resources/rosalind_subs.txt");
        
        System.out.println("Mortal Fibonacci Rabbits:");
        MortalFibonacciRabbits.calculateRabbitPairs("resources/rosalind_fibd.txt");
	}

}
