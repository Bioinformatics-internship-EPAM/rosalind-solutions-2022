import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class EDTATest {
    @Test
    void solveTest() {
        final String expected = "4\nPRETTY--\nPR-TTEIN";
        try {
            String path = Paths.get(getClass().getClassLoader().getResource("EDTA.fasta").toURI()).toString();
            assertTrue(EDTA.solve(path).equals(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}