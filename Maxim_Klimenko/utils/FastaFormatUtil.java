package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FastaFormatUtil {

    public static HashMap<String, String> readFastaFile( Scanner scanner ) {
        HashMap<String, String> fastaMap = new HashMap<>();

        while ( scanner.hasNextLine() ) {
            StringBuilder dnaStr = new StringBuilder();
            String label = scanner.nextLine().replaceAll(">", "");

            while ( !scanner.hasNext(">.*") && scanner.hasNextLine() ) {
                dnaStr.append( scanner.nextLine() );
            }

            fastaMap.put( label, dnaStr.toString() );
        }

        return fastaMap;
    }

    public static String getLabelByValue(HashMap<String, String> map, String dnaStr) {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        String label = "";

        for (Map.Entry<String, String> pair : entrySet) {
            if ( dnaStr.equals( pair.getValue() ) ) {
                label = pair.getKey();
            }
        }

        return label;
    }
}
