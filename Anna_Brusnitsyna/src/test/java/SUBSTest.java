import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SUBSTest {
    @Test
    void solveTest() throws Exception {
        ArrayList<Integer> expected = new ArrayList<>(List.of(2, 4, 10));
        ArrayList<Integer> actual = SUBS.solve("GATATATGCATATACTT", "ATAT");
        assertIterableEquals(expected, actual);

        expected = new ArrayList<>(List.of(2, 5, 6, 15, 17, 18));
        actual = SUBS.solve("AUGCUUCAGAAAGGUCUUACG", "U");
        assertIterableEquals(expected, actual);
    }

    @Test
    void incorrectLength() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> SUBS.solve("GATATA", "ATATATA")
        );
        assertTrue(thrown.getMessage().equals("Pattern string is longer than DNA string"));
    }
}