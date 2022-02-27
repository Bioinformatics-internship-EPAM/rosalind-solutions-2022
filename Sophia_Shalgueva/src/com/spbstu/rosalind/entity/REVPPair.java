package com.spbstu.rosalind.entity;

public class REVPPair {
    int position;
    int len;

    public REVPPair(int position, int len) {
        this.position = position;
        this.len = len;
    }

    @Override
    public String toString() {
        return position + " " + len;
    }
}
