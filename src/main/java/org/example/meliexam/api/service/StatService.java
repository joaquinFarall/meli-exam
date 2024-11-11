package org.example.meliexam.api.service;

import org.example.meliexam.api.model.Dna;
import org.example.meliexam.api.dto.StatResponse;
import org.example.meliexam.api.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService {
    private final DnaRepository dnaRepository;

    @Autowired
    public StatService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public StatResponse getStats() {
        try {
            List<Dna> dnaList = dnaRepository.findAll();
            int count_human_dna = 0;
            int count_mutant_dna = 0;
            for (Dna dna : dnaList) {
                if (dna.getIsMutant())
                    count_mutant_dna++;
                else
                    count_human_dna++;
            }
            float ratio = (float)count_mutant_dna / (float)(count_human_dna == 0 ? 1 : count_human_dna);
            return new StatResponse(count_mutant_dna, count_human_dna, ratio);
        } catch (Exception e) {
            System.out.println("Error at StatsService.getStatus -> " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
