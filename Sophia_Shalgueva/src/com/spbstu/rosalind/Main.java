package com.spbstu.rosalind;

import com.spbstu.rosalind.entity.GraphEdge;
import com.spbstu.rosalind.entity.REVPPair;
import com.spbstu.rosalind.tasks.*;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // 1
        System.out.println("********Computing GC Content************");
        System.out.println(GCTask.countHighestGCContent());
        System.out.println();

        //2
        System.out.println("********Translating RNA into Protein************");
        System.out.println(PROTTask.translateRNAIntoProtein());
        System.out.println();

        //3
        System.out.println("********RNA Splicing************");
        System.out.println(SPLCTask.transcribeAndTranslate());
        System.out.println();

        // 4
        System.out.println("********Open Reading Frames************");
        System.out.println(ORFTask.readODFs());
        System.out.println();

        // 5
        System.out.println("********Overlap Graphs************");
        List<GraphEdge> edges = GRPHTask.findAllEdges();
        for (GraphEdge e : edges) {
            System.out.println(e);
        }
        System.out.println();

        // 6
        System.out.println("********Locating Restriction Sites************");
        List<REVPPair> pairs = REVPTask.collectAllPairs();
        for (REVPPair p : pairs) {
            System.out.println(p);
        }
        System.out.println();

        // 7
        System.out.println("********Consensus and Profile************");
        CONSTask.createProfileAndConsensus();
        System.out.println();

        // 8
        System.out.println("********Transitions and Transversions************");
        System.out.println(TRANTask.transversionsKoeff());
        System.out.println();

        // 9
        System.out.println("********Introduction to Random Strings************");
        double[] logs = PROBTask.findProbability();
        for (double log : logs) {
            System.out.printf(Locale.US, "%.03f ", log);
        }
        System.out.println();

        System.out.println("********Speeding Up Motif Finding************");
        Arrays.stream(KMPTask.findFailureArray()).forEach(i -> System.out.print(i + " "));
        System.out.println();

    }


}
