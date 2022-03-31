import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIATest {
    @Test
    void countingTest() throws Exception {
        double expected = 0.684;
        double actual = LIA.solve(2, 1);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void incorrectParametersTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> LIA.solve(-2, 1)
        );
        assertTrue(thrown.getMessage().equals("k should not be bigger than 0 and less than 8: k=-2"));

        thrown = assertThrows(
                Exception.class,
                () -> LIA.solve(2, -1)
        );
        assertTrue(thrown.getMessage().equals("N should not be bigger than 2**k: N=-1"));

        thrown = assertThrows(
                Exception.class,
                () -> LIA.solve(2, 5)
        );
        assertTrue(thrown.getMessage().equals("N should not be bigger than 2**k: N=5"));
    }
}
