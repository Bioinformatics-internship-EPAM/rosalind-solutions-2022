import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class REVCTest {
    @Test
    void solveTest() throws Exception {
        String expected = "ACCGGGTTTT";
        String actual = REVC.solve("AAAACCCGGT");
        assertTrue(actual.equals(expected));
    }

    @Test
    void nullTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> REVC.solve(null)
        );
        assertTrue(thrown.getMessage().equals("DNA string is null"));
    }
}