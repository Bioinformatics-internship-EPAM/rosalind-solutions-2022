public class RNA {

    public static String task() {
        String str = ReadFile.resFileToStringList("rosalind_rna.txt").get(0);

        return str.replace('T', 'U');
    }
}
