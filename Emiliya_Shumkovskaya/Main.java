import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Task 1
        System.out.println("Counting DNA Nucleotides");
        System.out.println("Enter DNA string");
        String dna = in.nextLine();
        DNA dnaTask = new DNA();
        dnaTask.setDNA(dna);
        dnaTask.printResult();
        //Task 2
        System.out.println("Transcribing DNA into RNA ");
        System.out.println("Enter DNA string");
        dna = in.nextLine();
        RNA rnaTask = new RNA();
        String rna = rnaTask.getRNA(dna);
        System.out.println(rna);
        //Task 3
        System.out.println("Complementing a Strand of DNA");
        System.out.println("Enter DNA string");
        dna = in.nextLine();
        REVC revcTask = new REVC();
        String strand = revcTask.getStrand(dna);
        System.out.println(strand);
        //Task 4
        System.out.println("Finding a Motif in DNA");
        System.out.println("Enter 2 DNA strings");
        dna = in.nextLine();
        String part = in.nextLine();
        SUBS subsTask = new SUBS();
        List<Integer> locations = subsTask.getLocations(dna, part);
        for(int i = 0; i < locations.size(); i++) {
            System.out.print(locations.get(i).toString() + " ");
        }
        System.out.println();
        //Task 5
        System.out.println("Mendel's First Law");
        System.out.println("k individuals are homozygous dominant for a factor, m are heterozygous," +
                " and n are homozygous recessive");
        int k = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        IPRB iprbTask = new IPRB();
        double prop = iprbTask.countDominantProperty(k, m, n);
        System.out.println(prop);
        //Task 6
        System.out.println("Enter data for task 6");
        String dna1 = in.nextLine();
        String dna2 = in.nextLine();
        HAMM hammTask = new HAMM();
        int diff = hammTask.getDifference(dna1, dna2);
        System.out.println(diff);
        //Task 7
        System.out.println("Enter data for task 7");
        rna = in.nextLine();
        PROT protTask = new PROT();
        String protein = protTask.getProtein(rna);
        System.out.println(protein);
        //Task 8
        System.out.println("Inferring mRNA from Protein");
        System.out.println("Enter protein string");
        protein = in.nextLine();
        MRNA mrnaTask = new MRNA();
        int count = mrnaTask.countRNAnum(protein);
        System.out.println(count);
        //Task 9
        System.out.println("Independent Alleles");
        System.out.println("Enter num of generations and num of childs AaBb");
        k = in.nextInt();
        int N = in.nextInt();
        LIA liaTask = new LIA();
        prop = liaTask.countProp(k, N);
        System.out.println(prop);
        //Task 10
        System.out.println("Rabbits and Recurrence Relations");
        System.out.println("Enter months and litter number");
        n = in.nextInt();
        k = in.nextInt();
        FIB fibTask = new FIB();
        int num = fibTask.reproduce(n, k);
        System.out.println(num);
    }
}
