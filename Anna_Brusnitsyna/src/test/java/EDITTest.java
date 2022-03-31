import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class EDITTest {
    @Test
    void solveTest() {
        final int expected = 5;
        try {
            String path = Paths.get(getClass().getClassLoader().getResource("EDIT.fasta").toURI()).toString();
            assertEquals(expected, EDIT.solve(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}