package bioinformatic.labs.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReader {

    public static List<String> readLinesFromFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    public static Map<String, String> parseFASTAFormat(List<String> lines) {
        Map<String, String> DNAStrings = new HashMap<>();

        boolean newDNA = false;
        String currentDNA = "";
        StringBuilder builder = new StringBuilder();

        for (String line: lines) {
            newDNA = line.startsWith(">");

            if (newDNA && currentDNA.isEmpty()) {
                currentDNA = line.replace(">", "");
            } else if (newDNA) {
                DNAStrings.put(currentDNA, builder.toString());
                builder.setLength(0);

                currentDNA = line.replace(">", "");
            } else {
                builder.append(line);
            }
        }
        // tha last string
        DNAStrings.put(currentDNA, builder.toString());

        return DNAStrings;
    }
}
