package org.example.meliexam.api.dto;

public class StatResponse {
    private int count_mutant_dna;
    private int count_human_dna;
    private float ratio;

    public StatResponse(int count_mutant_dna, int count_human_dna, float ratio) {
        this.count_human_dna = count_human_dna;
        this.count_mutant_dna = count_mutant_dna;
        this.ratio = ratio;
    }

    void setCount_mutant_dna(int count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }
    void setCount_human_dna(int count_human_dna) {
        this.count_human_dna = count_human_dna;
    }
    void setRatio(float ratio) {
        this.ratio = ratio;
    }
    public int getCount_mutant_dna() {
        return count_mutant_dna;
    }
    public int getCount_human_dna() {
        return count_human_dna;
    }
    public float getRatio() {
        return ratio;
    }
}
