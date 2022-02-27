package com.spbstu.rosalind.utils;

import com.spbstu.rosalind.entity.FASTA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
    public static List<FASTA> readFASTAFile(String fileName) {
        Path path = Paths.get(fileName);
        try (Stream<String> inputStream = Files.lines(path)) {
            List<String> rawLines = inputStream.collect(Collectors.toList());
            List<String> modifiedFASTALines = List.of(
                    String.join(" ", rawLines)
                            .replaceFirst(">", "")
                            .split(">"));
            return createFASTAOutOfRawLines(modifiedFASTALines);
        } catch (IOException e) {
            System.err.println("Some problems with file");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static List<FASTA> createFASTAOutOfRawLines(List<String> modifiedFASTALines) {
        List<FASTA> resultFiles = new ArrayList<>();
        for (String line : modifiedFASTALines) {
            String[] splitLine = line.split(" ");
            String header = splitLine[0];
            StringBuilder data = new StringBuilder();
            for (int i = 1; i < splitLine.length; i++) {
                data.append(splitLine[i]);
            }
            resultFiles.add(new FASTA(header, data.toString()));
        }
        return resultFiles;
    }

    public static Map<String, String> readAminosTableFile(String fileName) {
        Map<String, String> resultMap = new HashMap<>();
        List<String> lines = readLines(fileName);
        for (String line : lines) {
            String[] parts = line.split(" ");
            resultMap.put(parts[0], parts[1]);
        }
        return resultMap;
    }

    public static List<String> readLines(String fileName) {
        Path path = Paths.get(fileName);
        try (Stream<String> inputStream = Files.lines(path)) {
            return inputStream.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Some problems with file");
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
