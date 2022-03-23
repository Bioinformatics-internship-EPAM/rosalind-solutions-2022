package bioinformatic.labs;

import bioinformatic.labs.utils.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Tests {
    private final String testDataPath = ".\\test\\bioinformatic\\labs\\data\\";

    @Test
    public void DNATest1() {
        String DNAStr = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        Assertions.assertEquals("20 12 17 21", DNA.solution(DNAStr));
    }

    @Test
    public void DNATest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_dna.txt"));
        String DNAStr = file.get(0);
        Assertions.assertEquals("258 224 232 248", DNA.solution(DNAStr));
    }

    @Test
    public void RNATest1() {
        String DNA = "GATGGAACTTGACTACGTAAATT";
        Assertions.assertEquals("GAUGGAACUUGACUACGUAAAUU", RNA.solution(DNA));
    }

    @Test
    public void RNATest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_rna.txt"));
        String DNA = file.get(0);
        String expected = "" +
                "CCCAGAACGCUCAAGACGGAGUAGCACGACUUACAGGUGAUUGGCUGGGAUUGCGGAGUC" +
                "GGUCAGCGAACAUCCGCCGCUCCUCUGUCCGCAGCAUGGGUGUAUAUAUCACAAAACAGA" +
                "UCUAACCCUUCGCCGAUAAUCCUGUCACUGGCGUCCUGUUUAUCGUGGAACCCAUUAUAG" +
                "AGAGGUGCGGUAGCAAGAGACAUAGGUUUCAUACCGGGGGCGAUGCGAUCGUACCAAAAA" +
                "AAUCCACUUGUAAUGAUCCUGCUGUGCUAGGCUCGGAUCGGCGCAAAACGAUCUUAGACA" +
                "GACGAACCAGUUUUUAAUGGCAUACUCCCCGCUUUCGGUGGGCCACCAACGAGACUGCAU" +
                "AGGUAGGGUUUAUAAAAUGGUGCAGCCUAAAGGGCCGCGCUCACCGCUGGACUCUUAGUA" +
                "GGUAACCUAUCCUUACGACUGAGUUCGACCACGUUCUUUGGUAUUGGAUAAUAUGGCUCC" +
                "AGUAAGCGAGAGGCGCUCUGACCGUGGUGGUCAGGGCCGGCAAAUAUCGAGGCCGCAAUC" +
                "UUUAUCCCCGAGAUAAGCACCUUCAUAGAUACGGACAGAAAUACACUGACAUGAUUGGCC" +
                "GUACGCCGUGUAGUCCGCCGACUUCCUCUACAUAGAGUGCUAAGAGCUCGCGUAGCAAAG" +
                "GAGGAACACGUCCAAGCAUCAAGUGCCAACGGAAGGGACAUGACUGACGCGCUCGGCCGC" +
                "AGUGAAUAUAAUGCUAACGAACGUGAGUGUUUCGCGUCCGCCCACCGGUAUUCGGUCCGG" +
                "GAAUCCCGCCUGACUAACAUAGAGCGAAUGACUCGGAUAUUCUCUACCCAUGGCGUUGGU" +
                "ACGGCUUGCUGCUCGGUCAUUUGGCGCAUGAUACUUACAUCCUGUAAAGUCGCCGCUCGG" +
                "CCUUAAUCCUCAAUA";
        Assertions.assertEquals(expected, RNA.solution(DNA));
    }

    @Test
    public void REVCTest1() {
        String DNA = "AAAACCCGGT";
        Assertions.assertEquals("ACCGGGTTTT", REVC.solution(DNA));
    }

    @Test
    public void REVCTest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_revc.txt"));
        String DNA = file.get(0);
        String expected = "" +
                "TGGGGTTCTCTCGATAAGTAGTTGCAAGTAGAATCGAAGCCCTTCAACATTATAAACTCA" +
                "TGGTGGGCACAGATTGGGGAGTTCCGTCGGCGTCCAGTCGATAACCTGTCACTTGCTTCA" +
                "ACGGAGGGCATTTACTCCTGTTTCGGACCCTCCGATTGTTTCACCAGGTGAAGGGGCTTG" +
                "CACCAGGAGGCGTGAAGTGGTAGCGCAGAGACCGGATAAGCGGTGCAGTCGTTTAGGACA" +
                "GTTCGCTTGAAGGAATGTATTTCTACTTTTCGGACGAGGGATCATAGAAGTGTGACGTCA" +
                "GGACTTAGAGTCCCTCCAGTGAATTCAGCATCGTGACAACTGTGTACAGTAAGGTGACTA" +
                "GCAGACAAATCCCGGTCCCTTCGGTGTTACGGTGGTGTCGTGCATAACGAGGACCTGAAA" +
                "CCCCTGCATGGTGCCTAAGGGGCCCCAATAACAAAATGTAGCAAGAAAAGTTCCCGGGCT" +
                "TCACAGCGTCCCAAGGGTGATATAACATATGTGAGTCCGCCACTAAGTTGACAAAGAGAT" +
                "GCGCGGGTCCTACGCCTTGAAGACACGTGCGTGCCGATATCATTAATACGGCACCAGGCT" +
                "CACACAGCTACTGTAACGATCTAATAGAGTCCCCACACCGACACGGCTAGTCGGGGTACT" +
                "CAATTCACGCTTATTTTACTTCCGGATCGCTACCATGACGGCTAGTATTACTACGAGTGG" +
                "GTCCGGTGCAAAATATACATGAAGGAGCCCAGTTTAACGGCAATATATGGGTAACTCGTA" +
                "CCCCACCGTCGAGACGGGCTCCCCTTAGCCGAAAAATTGAAATCACAATGCGTTATCGTG" +
                "CGAATAG";
        Assertions.assertEquals(expected, REVC.solution(DNA));
    }

    @Test
    public void HAMMTest1() {
        String str1 = "GAGCCTACTAACGGGAT";
        String str2 = "CATCGTAATGACGGCCT";
        Assertions.assertEquals(7, HAMM.solution(str1, str2));
    }

    @Test
    public void HAMMTest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_hamm.txt"));
        String str1 = file.get(0);
        String str2 = file.get(1);
        Assertions.assertEquals(498, HAMM.solution(str1, str2));
    }

    @Test
    public void PROTTest1() {
        String str = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
        Assertions.assertEquals("MAMAPRTEINSTRING", PROT.solution(str));
    }

    @Test
    public void PROTTest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_prot.txt"));
        String str = file.get(0);
        String expected = "" + 
                "MVYLLNSRPDHKTDGPQSNVHPQDAWIRLVAVASRSSLCIIGAEQVFEARCRLICGFALV" +
                "NTTNIVGCFEIDCLTFTWDLQLAHQGRVSVPTGVTQNPFSLCILCGDRPAPVSIGLVSSI" +
                "LTKFASAQSDATQAPVEMQIVKRKQIEFMHQNAHVKKEGTDANRGCDVSLYRGILRYRHR" +
                "SCHRPSTCIQVSEQSMSRSLAVLFFRREFIQCPPIILVKPPRESSLIHVIRPLQIATTLK" +
                "RAAQTFRSQTTDVPITVNVSTLDSSPAATLVDMFLRVYAAIWCLVSGVSRCRSYFMDLTI" +
                "FRLSLEPTVRPCGDALGLHAVRLYIARIDPSPAYRLQERLGYCRDLQGPSQAVATQSQAS" +
                "RTNVRAYLRLPYIEAIFNTVLRPLHSALGTLPILYGEGAPPSIERRPSIKRDLREQERGI" +
                "CGWLLNRLEYTETAASRNVAHPLFSPIPVLAAMRQHLIPMDRVLEYRIDAASSATCCLSI" +
                "CRPLRNPLPRLLLPRVTEPITECHGSRREHCLLARGFGFVTNEVMEVSGKRGAAGPDRTS" +
                "ACFTVLLAHRRPSAERRRCVNITYAETPVKETENPLFGHYGPCSIKVIAYRLARPIVEMV" +
                "CRAAPLYDGCRSAKCCRKASYNTSGCAMEPCGVSLVGLRRPETFKHGHLNGVLPVSNTAF" +
                "DPESFIGMAIPCRCSTSRGQFWCRNAQWTAPGSDMSKFRLHHGNSGGHPLIFLKRAPKEE" +
                "LDAIECGAQPVRVPPVTASIIMFLAPFIFILSNNQSRRQLRYGIETRPQQSLNSNSHYRQ" +
                "CVCALGHPLTLLKVVWHRCPSSCDSYPVLTSTPCSTCSSCEPNTHGRIRYDSTRVCRNPD" +
                "NGSTVASRLTRPLTLTVPFRSTRSMGRLWVPVEGAGHGTRVLNLMTVANGPRSDCSLLQI" +
                "GVVPPSRREKVTCIIGQLWRFAMSLKNSYYERLHGLNLRSCRLRIVLGESASDCAHQDPF" +
                "KLVILGCGLEASCNSGGNHMTSRTFTNRCCPTHHLVPRAELKVILCYVNGYPLLHHGSIL" +
                "LDNPTRRRSIELAASAFDNCLLRKCQHRSNHGAGNSHGYLDDQVDLQDPFKTYRRCGRAL" +
                "LCHPRDVSQGLMCGVARSTFQFRPLYNSHRQPIDVGHRLKGRSKTGSMHIRLNCCCLSWS" +
                "DFWCYRNHAPYHQRLRTKNSHLIKGSDPTYIPVLRALSLSPIWRTESNQWAWVCRFCHSD" +
                "SLRLHIRLRREYAVFLLWERGDFANERAPKADIVVPRKECMTCQRKSCDLELLLLYLCTV" +
                "HFRLVRASAKEQVFDLRPSTAFHPATKTFNHISRLCPIRNLEFSVNVVHKQFGTTEKYQA" +
                "VPSIDGRRRRLTVSSTFHPCSLRHRVGEPHSLHQSSRGYGPIAGVSGGASPPPALKSGPT" +
                "QDSITAPRNSCDRPCVARSRNTYSIKLDNSMLPYVNLPNHHSAVSRLSGTLALINVNAMA" +
                "SCFYDSLRFHDMPGHNGLLIHRVSNVASLQNGDYGYATSSSHLSSYGSLNLEACCGEVRL" +
                "LEPLLCLQFTWVSHLLRPQMDRSATLETRGICLRISPTNSPGPSRHGIGHLSLRSRQLGQ" +
                "VRHSHGSPSGGKYRRVSNSLDPSVEHMLSRESMRTTRGYLTTKRISKLPSLIGVLACRLT" +
                "PIHMTPASTKCESHICTQPYGVHKILAGHSLCTGSLTARAVLFRVPRVVGSSPRVGGTPP" +
                "QYVVYVKICFVFGNYNVGPDVVSSAKTCVIIPSIRHRPVKFSGYLGHCYSDRGPVSILVE" +
                "IRVSGGRYPLAPGVTQAGNVALCQGERLLWDAAPVTYGDAFLGDINPSCKKKSLISTAVV" +
                "ENKNDVEGADHTQSPRTLCATYLVLVGSNKDWKCCLDRFHFVLSCARTIQSSGAQSQTTG" +
                "HTLRRYNITCIDYPKNRAVPVAVLDFTLIGIEHCQSWDGVTIPFIAPVDNQPLRRIQATG" +
                "HPSEPYEKNDVQTTPKVTPVLVSNKGILYCCDKGTTVPPPECNAKTMGVMFGLKINTDKE" +
                "LSGPAYEGLRAPRQCDPSFPMIEAPHRIITITSAQFGWSLIAGGAVTLPKCVAHYLLYSS" +
                "YRCLLHNERWFTQRIDLVRADDHRRCGCSSTVTTEHAGVFPVINLPMVIRGSQDNMFSVA" +
                "GKLEKADKLFHAKDVNNVPYCSISSMHRLRSLSVCVRDRFDSAKTIRHHIDSTRGSCPRA" +
                "FSSTSDVVLNILIKGSRLAMLGIGPINDVLVSDLYQRKSGPKFGVVPYSQRDLRRFQVAR" +
                "MLTNCGFRLRGCRDSSMPLNGLACTRLKVNEAECSLPYSTLPYRSDWKLIRSEKSINGVQ" +
                "RWLRHLVMCDCSIARFVAVSDEKPDAVALAHRCDKTLGISLGCMLTSVIKVSSQEFLTKL" +
                "GTVCTIDAEGQGARLPDQSSGYLLQSPKVDGCTCDAEQQARPDPLFLSGAYQHRCRFELL" +
                "LSAMVVVSRGSVYCNGSSCRSLLPAKEHVPRLSIYLTLGMNRIDPIHKTRGTVWRRATTD" +
                "INPYFCFGGILCQKECGSHIDDPESPRLLFRSVDEGLSVPASPFNTRNVRVGFLERTLLY" +
                "GWTHFLSTFPHATATHVRIKSDYYMVLPLKPHSHINDSRARGLVWSKLIHVAPRRGRTGL" +
                "ICIFLLVSRTRAQVRGFPVLRTSLTPPCRDKPSIAYAESSVEHGCCPTILLLRLVSVDTD" +
                "YPDVQSMLHSHPLRPSWRFVAFLKERDAPGLDRPSHDVWAAGCRTARSPTQSPSTLVEGR" +
                "RSSVKESGSRGSSVDLQHVFLFFGGLQFCIYWTGLRRCLIVKLEFTPGLPCCRASKESGW" +
                "VAPRHTRTSTPLRGQSIVKCVPGGIIGLMWISNPRRAQTPTECENDSTTIKSLIYTVTLS" +
                "LKTWLIYVLKTVLRFCPTSSGVPQRARASDSTATGLLTVALPMFNRNKVARGHRYCAGTV" +
                "LHRIVVFCGSSLRVVMPSSLKLASGLKLGGATVRIKYNIANFRLTLSSAVPLILSERIFL" +
                "RTYRLNLHTFPKPVRSRNAAGSTFAQMCHTLQSLNLAYCLTSTKLRVTRISSTNVRAQRI" +
                "QHNSYVFRALVSSGASRLPIRRILKDLKAGEAVTRYSTNLHLQTRSNTVSTRQTSVISLL" +
                "KELDANAAVLGWCNYFLKIFGPYRPW";
        Assertions.assertEquals(expected, PROT.solution(str));
    }

    @Test
    public void GCTest1() {
        String filename = testFilePath("rosalind_gc_1.txt");
        Map.Entry<String, Double> result = GC.solution(filename);

        Assertions.assertEquals("Rosalind_0808", result.getKey());
        Assertions.assertEquals(60.919540, result.getValue(), 0.001);
    }

    @Test
    public void GCTest2() {
        String filename = testFilePath("rosalind_gc_2.txt");
        Map.Entry<String, Double> result = GC.solution(filename);

        Assertions.assertEquals("Rosalind_8025", result.getKey());
        Assertions.assertEquals(51.64609053497943, result.getValue(), 0.001);
    }

    @Test
    public void SUBSTest1() {
        String str = "GATATATGCATATACTT";
        String substr = "ATAT";
        List<Integer> expected = List.of(2, 4, 10);
        Assertions.assertEquals(expected, SUBS.solution(str, substr));
    }

    @Test
    public void SUBSTest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_subs.txt"));
        String str = file.get(0);
        String substr = file.get(1);
        List<Integer> expected = List.of(
                72, 79, 128, 135, 158, 165, 191, 198, 205, 212,
                219, 279, 296, 339, 346, 361, 405, 472, 479, 497,
                572, 598, 605, 629, 672, 699, 706, 721, 763, 778, 795
        );
        Assertions.assertEquals(expected, SUBS.solution(str, substr));
    }

    @Test
    public void PRTMTest1() {
        String str = "SKADYEK";
        Assertions.assertEquals(821.392, PRTM.solution(str), 0.0001);
    }

    @Test
    public void PRTMTest2() throws IOException {
        List<String> file = FileReader.readLinesFromFile(testFilePath("rosalind_prtm.txt"));
        String str = file.get(0);
        Assertions.assertEquals(103027.62514000038, PRTM.solution(str), 0.0001);
    }

    @Test
    public void CONSTest() {
        String filename = testFilePath("rosalind_cons_1.txt");
        CONS lab = new CONS();
        lab.solution(filename);

        String expected = "" +
                "A: 5 1 0 0 5 5 0 0" + "\n" +
                "C: 0 0 1 4 2 0 6 1" + "\n" +
                "G: 1 1 6 3 0 1 0 0" + "\n" +
                "T: 1 5 0 0 0 1 1 6" + "\n";
        Assertions.assertEquals(expected, lab.getProfileMatrix());
        Assertions.assertEquals("ATGCAACT", lab.getConsensus());
    }

    @Test
    public void PERMTest() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        expected.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        expected.add(new ArrayList<>(Arrays.asList(2, 1, 3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        expected.add(new ArrayList<>(Arrays.asList(3, 2, 1)));
        expected.add(new ArrayList<>(Arrays.asList(3, 1, 2)));

        Assertions.assertEquals(expected, new PERM().solution(3));
    }

    private String testFilePath(String filename) {
        return testDataPath + filename;
    }
}
