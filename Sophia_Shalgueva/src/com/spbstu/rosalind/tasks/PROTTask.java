package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.utils.FileUtils;

import java.util.Map;

import static com.spbstu.rosalind.utils.Constants.*;

/**
 * Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).
 *<p>
 * Return: The protein string encoded by s.
 */
public class PROTTask {


    public static String translateRNAIntoProtein() {
        String input = FileUtils.readLines(PROT_TASK_PATH).get(0);
        return buildProteinString(input);
    }

    static String buildProteinString(String input) {
        Map<String, String> aminoValues = FileUtils.readAminosTableFile(AMINOS_FILE_PATH);
        StringBuilder proteinString = new StringBuilder();
        for (int i = 0; i < input.length(); i += CODON_LENGTH) {
            if (!aminoValues.get(input.substring(i, i + CODON_LENGTH)).equals("Stop")) {
                proteinString.append(aminoValues.get(input.substring(i, i + CODON_LENGTH)));
            } else {
                break;
            }
        }
        return proteinString.toString();
    }

}
