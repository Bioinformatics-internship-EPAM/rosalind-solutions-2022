package testofbioinfo;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TranscribingDNAintoRNA {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("D:\\project.java\\bioinformatics\\resources\\DNATORNA.txt"),
                StandardCharsets.UTF_8);
        String DNA = lines.get(0);
        System.out.println("Transcribing DNA into RNA");
        System.out.println(DNA);
        System.out.println(Transcribing(DNA));
    }

    public static String Transcribing(String DNA){
        String RNA= DNA.replace('T','U');
        return RNA;

    }
}
