package org.example.meliexam.service;

import org.example.meliexam.api.model.Dna;
import org.example.meliexam.api.repository.DnaRepository;
import org.example.meliexam.api.service.MutantService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class MutantServiceTest {
	@Autowired
	private MutantService mutantService;

	@MockBean
	private DnaRepository dnaRepository;

	@Test
	public void testIsMutant() {
		// Arrange
		String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		Mockito.when(dnaRepository.findBySequence(dna)).thenReturn(null);
		// Act
		boolean res = mutantService.isMutant(dna);
		// Assert
		assertTrue(res);
		verify(dnaRepository, times(1)).findBySequence(dna);
		verify(dnaRepository, times(1)).save(Mockito.any(Dna.class));
	}

	@Test
	public void testIsNotMutant() {
		// Arrange
		String[] dna = {"ATGCGA", "CCGTGC", "TTATGT", "AGATGG", "CTCCTA", "TCACTG"};
		Dna mockDna = new Dna(dna, false);
		Mockito.when(dnaRepository.findBySequence(dna)).thenReturn(mockDna);
		// Act
		boolean res = mutantService.isMutant(dna);
		// Assert
		assertFalse(res);
		verify(dnaRepository, times(1)).findBySequence(dna);
		verify(dnaRepository, times(0)).save(Mockito.any(Dna.class));
	}
}

