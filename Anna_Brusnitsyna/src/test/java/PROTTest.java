import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PROTTest {
    @Test
    void solveTest() throws Exception {
        final String expected = "MAMAPRTEINSTRING";
        final String actual = PROT.solve("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA");
        assertTrue(actual.equals(expected));
    }

    @Test
    void nullStringTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> PROT.solve(null)
        );
        assertTrue(thrown.getMessage().equals("RNA string is null"));
    }

    @Test
    void startCodonTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> PROT.solve("AUUGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA")
        );
        assertTrue(thrown.getMessage().equals("Incorrect start codon: AUU"));
    }

    @Test
    void lastCodonTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> PROT.solve("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGG")
        );
        assertTrue(thrown.getMessage().equals("Incorrect last codon: UGG"));
    }

    @Test
    void incorrectCodonTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> PROT.solve("AUGGCCAUAGCGCCCAGAACUGAGATCAAUAGUACCCGUAUUAACGGGUGA")
        );
        assertTrue(thrown.getMessage().equals("Incorrect codon: ATC"));
    }

    @Test
    void incorrectRNATest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> PROT.solve("AUGGCCAUGGCGCCCAGAACUGAGAUAAUAGUACCCGUAUUAACGGGUGA")
        );
        assertTrue(thrown.getMessage().equals("RNA string with incorrect length"));
    }
}