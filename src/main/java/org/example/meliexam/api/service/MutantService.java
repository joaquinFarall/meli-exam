package org.example.meliexam.api.service;

import org.example.meliexam.api.model.Dna;
import org.example.meliexam.api.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MutantService {
    private final DnaRepository dnaRepository;

    @Autowired
    public MutantService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean isMutant(String[] dna) {
        boolean res = false;
        int sequencesFound = 0;
        for (int i = 0; i < dna.length; i++) {
            if (sequencesFound > 1) {
                res = true;
                break;
            }
            for (int j = 0; j < dna[i].length(); j++) {
                // Check vertical sequence
                if (i < dna.length - 3 && checkDirection(dna, i, j, 1, 0))
                        sequencesFound++;
                // Check horizontal sequence
                if (j < dna[i].length() - 3 && checkDirection(dna, i, j, 0, 1))
                    sequencesFound++;
                // Check diagonal sequence
                if (i < dna.length - 3 && j < dna[i].length() - 3 && checkDirection(dna, i, j, 1, 1))
                        sequencesFound++;
            }
        }
        saveDna(dna, res);
        return res;
    }

    private boolean checkDirection(String[] dna, int i, int j, int rowDir, int colDir) {
        char currentChar = dna[i].charAt(j);
        for (int k = 1; k <= 3; k++) {
            if (dna[i + k * rowDir].charAt(j + k * colDir) != currentChar) {
                return false;
            }
        }
        return true;
    }

    private void saveDna(String[] sequence, boolean isMutant) {
        try {
            Dna existingDna = dnaRepository.findBySequence(sequence);
            if (existingDna != null)
                return;
            Dna newDna = new Dna(sequence, isMutant);
            dnaRepository.save(newDna);
        } catch (Exception e) {
            System.out.println("Error at MutantService.saveDna -> " + e.getMessage());
            System.out.println("Dna sequence " + Arrays.toString(sequence) + " could not be saved");
        }
    }
}
