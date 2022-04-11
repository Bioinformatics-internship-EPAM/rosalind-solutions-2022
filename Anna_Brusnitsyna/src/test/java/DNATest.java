import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DNATest {
    final String dna = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";

    @Test
    void countingTest() throws Exception {
        String expected = "20 12 17 21";
        String actual = DNA.count(dna);
        assertTrue(actual.equals(expected));

        actual = DNA.count(dna.toLowerCase());
        assertTrue(actual.equals(expected));
    }

    @Test
    void incorrectSymbolTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> DNA.count(new StringBuilder(dna).insert(10, "M").toString())
        );
        assertTrue(thrown.getMessage().equals("Incorrect nucleotide symbol: M"));
    }

    @Test
    void nullDnaStringTest() {
        Exception thrown = assertThrows(Exception.class, () -> DNA.count(null));
        assertTrue(thrown.getMessage().equals("DNA string is null"));
    }
}
