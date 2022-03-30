import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static final String resourcePath = "./resources/";
    public static List<String> resFileToStringList(String fileName) {
        try {
            Path path = Path.of(resourcePath + fileName);
            return Files.readAllLines(path);
        }
        catch (IOException exc) {
            System.err.println("Unable to read file " + fileName);
            exc.printStackTrace();
        }
        return new ArrayList<>();
    }
}
