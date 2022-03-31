import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SPLCTest {
    @Test
    void solveTest() {
        final String expected = "MVYIADKQHVASREAYGHMFKVCA";
        try {
            String path = Paths.get(getClass().getClassLoader().getResource("SPLC.fasta").toURI()).toString();
            assertTrue(SPLC.solve(path).equals(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}