package com.spbstu.rosalind.tasks;

import com.spbstu.rosalind.entity.FASTA;
import com.spbstu.rosalind.entity.GraphEdge;
import com.spbstu.rosalind.utils.FileUtils;

import java.util.*;

import static com.spbstu.rosalind.utils.Constants.GRPH_TASK_PATH;

/**
 * Given: A collection of DNA strings in FASTA format having total length at most 10 kbp.
 *<p>
 * Return: The adjacency list corresponding to O3. You may return edges in any order.
 */
public class GRPHTask {
    private static final int O_K = 3;

    public static List<GraphEdge> findAllEdges() {
        List<FASTA> files = FileUtils.readFASTAFile(GRPH_TASK_PATH);
        Map<String, ArrayList<String>> mapOfBeginnings = new HashMap<>();
        Map<String, ArrayList<String>> mapOfEndings = new HashMap<>();
        for (FASTA file : files) {
            String content = file.getContent();
            String beginning = content.substring(0, O_K);
            String ending = content.substring(content.length() - O_K);
            mapOfBeginnings.put(beginning, fillMapOf(mapOfBeginnings, file, beginning));
            mapOfEndings.put(ending, fillMapOf(mapOfEndings, file, ending));
        }
        List<GraphEdge> edges = new ArrayList<>();
        for (String key : mapOfEndings.keySet()) {
            if (mapOfBeginnings.containsKey(key)) {
                List<GraphEdge> combinations = findAllNameCombinations(mapOfEndings.get(key), mapOfBeginnings.get(key));
                edges.addAll(combinations);
            }
        }
        return edges;
    }

    private static List<GraphEdge> findAllNameCombinations(List<String> endings, List<String> beginnings) {
        List<GraphEdge> result = new ArrayList<>();
        for (String e : endings) {
            for (String b : beginnings) {
                if (!e.equals(b)) {
                    result.add(new GraphEdge(e, b));
                }
            }
        }
        return result;
    }

    private static ArrayList<String> fillMapOf(Map<String, ArrayList<String>> map, FASTA file, String pattern) {
        if (map.get(pattern) != null) {
            ArrayList<String> currentFiles = map.get(pattern);
            currentFiles.add(file.getLabel());
            return currentFiles;
        } else {
            return new ArrayList<>(Collections.singleton(file.getLabel()));
        }
    }
}
