import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HAMMTest {
    @Test
    void solveTest() throws Exception {
        double expected = 7;
        double actual = HAMM.solve("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT");
        assertEquals(expected, actual);
    }

    @Test
    void incorrectLengthTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> HAMM.solve("GAGCCTACTAACGGGA", "CATCGTAATGACGGCCT")
        );
        assertTrue(thrown.getMessage().equals("DNA strings have different length"));
    }

    @Test
    void nullTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> HAMM.solve(null, "CATCGTAATGACGGCCT")
        );
        assertTrue(thrown.getMessage().equals("DNA string is null"));
    }
}