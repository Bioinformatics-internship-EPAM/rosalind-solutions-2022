import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CONSTest {
    @Test
    void solveTest() {
        final String expected = "ATGCAACT\n" +
                "A: 5 1 0 0 5 5 0 0\n" +
                "C: 0 0 1 4 2 0 6 1\n" +
                "G: 1 1 6 3 0 1 0 0\n" +
                "T: 1 5 0 0 0 1 1 6";
        try {
            String path = Paths.get(getClass().getClassLoader().getResource("CONS.fasta").toURI()).toString();
            assertTrue(CONS.solve(path).equals(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void incorrectSymbolTest() {
        try {
            String path = Paths.get(getClass().getClassLoader().getResource("CONS_inc_symbol.fasta").toURI()).toString();
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> CONS.solve(path)
            );
            assertTrue(thrown.getMessage().equals("Incorrect nucleotide symbol: Y (>Rosalind_5)"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void incorrectLengthTest() {
        try {
            String path = Paths.get(getClass().getClassLoader().getResource("CONS_inc_length.fasta").toURI()).toString();
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> CONS.solve(path)
            );
            assertTrue(thrown.getMessage().equals("Sequence >Rosalind_5 has incorrect length"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}