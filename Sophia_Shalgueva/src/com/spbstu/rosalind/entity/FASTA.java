package com.spbstu.rosalind.entity;

public class FASTA {
    String label;
    String content;

    public FASTA(String label, String content) {
        this.label = label;
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
