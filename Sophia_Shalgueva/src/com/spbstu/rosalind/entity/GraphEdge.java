package com.spbstu.rosalind.entity;

public class GraphEdge {
    String begining;
    String ending;

    public GraphEdge(String ending, String begining) {
        this.begining = begining;
        this.ending = ending;
    }

    @Override
    public String toString() {
        return ending + " " + begining;
    }
}
