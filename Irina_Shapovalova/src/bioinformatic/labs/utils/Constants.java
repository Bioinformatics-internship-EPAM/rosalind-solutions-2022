package bioinformatic.labs.utils;

public class Constants {
    private static String resourcesPath = ".\\src\\bioinformatic\\labs\\resources\\";

    public static String resourceFilePath(String filename) {
        return resourcesPath + filename;
    }
}
