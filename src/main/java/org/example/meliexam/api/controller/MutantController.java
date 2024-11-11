package org.example.meliexam.api.controller;

import jakarta.validation.Valid;
import org.example.meliexam.api.dto.MutantRequest;
import org.example.meliexam.api.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class MutantController {
    private final MutantService mutantService;

    @Autowired
    public MutantController(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    @PostMapping("/mutant")
    @Validated
    public ResponseEntity<Void> isMutant(@Valid @RequestBody MutantRequest req) {
        String[] dna = req.getDna();
        boolean res = mutantService.isMutant(dna);
        return res ? ResponseEntity.ok().build() : ResponseEntity.status(403).build();
    }
}
