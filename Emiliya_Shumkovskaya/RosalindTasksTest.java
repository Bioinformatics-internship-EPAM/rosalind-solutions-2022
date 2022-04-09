import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RosalindTasksTest {

    DecimalFormat decimalFormat = new DecimalFormat("#.#####");

    @Test
    void testDNA(){
        DNA dnaTask = new DNA();
        dnaTask.setDNA("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");
        assertEquals(20, dnaTask.getCountA());
        assertEquals(12, dnaTask.getCountC());
        assertEquals(17, dnaTask.getCountG());
        assertEquals(21, dnaTask.getCountT());
        dnaTask.setDNA("GCTTGTTATGATGCATATAAGCATGGTTAGGCATCAGGAGCCGGAGGACTCCGCACGACGTGTGAGTTATTTCA" +
                "TACATTAACGGACGTAGCCGGTTTTCAAGGCAGTTCATCCACCGCTTTTGTCGTCGCTATGAGGGCAACGTGTAACGCGAGGA" +
                "GCATAGTTCAAAAGATAGCCAACCTAAATAGAGCTGGGTGGCGAAGATACAAACTATCAACCCATGGTGGGGGAGCTGATCCTA" +
                "ATAACGGACCAAAGGATCATCGTTTGACGGATGTAACAAGCGGCAATGCGATCTCAGGCGTCGATTAATAACCACAAGGCCCTTACTC" +
                "TGGGTTATGCAGCTAATAAGCCATCCGAGCATATCTCTACTTCCAGTTCCCCGCGCAACAGTGGTGGGGTCCCCCCCCACGTCCTAGCC" +
                "ATTCATCTGCAGAACCATCTAGTGCACCTCTGGCGCCTTAAAGTCCTGGGGATCGCCTATAATGTTATTTTGAATGTGTCAAATGAGTCTAA" +
                "CCTGCCGACATATTTGACGTAGCCGAAGCGCAATTCGCTGGAACGGGTGGTGTGGCAATACCAAAAGTTTTCACGCACTATCAGACCAGATTGCC" +
                "TGTTTAATCGCAGAGTGTCTTCTGTGTGCAAAGACCCGTGTATGAATCTACCAATATTAAACCTAACTTAATAACTGTGCGTATATATTCC" +
                "TGTGCTATTGGTATGGTATTACCAGACGCGGCAAAGGGTACTAAAGGTTCCTAGCCAGTCTTATTTAATTGTAACAGACGTCGTTGCTCATTAG" +
                "TCTTCTCACATAGGAGAGGTGGATAGGTCGAGGAGTCAGGACAACGGGAAGCTGATTTATAGCGGTCTTGAATGCAGCGGAGTCAGAGTGTACCT" +
                "AATGTGGGACTGGACAGTTGGACTGTATGAGGTGTC");
        assertEquals(244, dnaTask.getCountA());
        assertEquals(205, dnaTask.getCountC());
        assertEquals(234, dnaTask.getCountG());
        assertEquals(238, dnaTask.getCountT());
    }

    @Test
    void testRNA() {
        RNA rnaTask = new RNA();
        assertEquals("GAUGGAACUUGACUACGUAAAUU",
                rnaTask.getRNA("GATGGAACTTGACTACGTAAATT"));
    }

    @Test
    void testREVC() {
        REVC revcTask = new REVC();
        assertEquals("ACCGGGTTTT",revcTask.getStrand("AAAACCCGGT"));
    }

    @Test
    void testFIB() {
        FIB fibTask = new FIB();
        assertEquals(19, fibTask.reproduce(5, 3));
        assertEquals(1251830246, fibTask.reproduce(27, 5));
    }

    @Test
    void testHAMM() {
        HAMM hammTask = new HAMM();
        assertEquals(7, hammTask.getDifference("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT"));

    }

    @Test
    void testIPRB() {
        IPRB iprbTask = new IPRB();
        assertEquals(0.78333, iprbTask.countDominantProperty(2, 2, 2),
        0.00001);
        assertEquals(0.79119, iprbTask.countDominantProperty(28, 24, 22),
                0.00001);

    }

    @Test
    void testPROT() {
        PROT protTask = new PROT();
        assertEquals("MAMAPRTEINSTRING",
                protTask.getProtein("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"));
    }

    @Test
    void testSUBS() {
        SUBS subsTask = new SUBS();
        List<Integer> locations = Arrays.asList(2, 4, 10);
        assertEquals(locations, subsTask.getLocations("GATATATGCATATACTT", "ATAT"));
    }

    @Test
    void testLIA() {
        LIA liaTask = new LIA();
        assertEquals(0.684, liaTask.countProp(2, 1), 0.001);
        assertEquals(0.232, liaTask.countProp(6, 19), 0.001);
    }

    @Test
    void testMRNA() {
        MRNA mrnaTask = new MRNA();
        assertEquals(12, mrnaTask.countRNAnum("MA"));
    }
}
