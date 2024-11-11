package org.example.meliexam.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.meliexam.api.validation.DnaValid;

public class MutantRequest {
    @NotEmpty
    @NotNull
    @DnaValid
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
