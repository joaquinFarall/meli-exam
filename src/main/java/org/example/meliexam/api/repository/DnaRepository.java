package org.example.meliexam.api.repository;

import org.example.meliexam.api.model.Dna;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends MongoRepository<Dna, String> {
    Dna findBySequence(String[] sequence);
}
