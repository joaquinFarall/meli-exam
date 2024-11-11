package org.example.meliexam.service;

import org.example.meliexam.api.dto.StatResponse;
import org.example.meliexam.api.model.Dna;
import org.example.meliexam.api.repository.DnaRepository;
import org.example.meliexam.api.service.MutantService;
import org.example.meliexam.api.service.StatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StatServiceTest {
	@Autowired
	private StatService statService;

	@MockBean
	private DnaRepository dnaRepository;

	@Test
	public void testGetStats() {
		// Arrange
		List<Dna> mockDnaList = List.of(
				new Dna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true),
				new Dna(new String[]{"ATGCGA", "CCGTGC", "TTATGT", "AGATGG", "CTCCTA", "TCACTG"}, false),
				new Dna(new String[]{"ATGCGT", "CCGTGC", "TTATGT", "AGATGG", "CTCCTA", "TCACTG"}, false)
		);
		Mockito.when(dnaRepository.findAll()).thenReturn(mockDnaList);
		// Act
		StatResponse res = statService.getStats();
		// Assert
		verify(dnaRepository, times(1)).findAll();
		assertEquals(res.getCount_human_dna(), 2);
		assertEquals(res.getCount_mutant_dna(), 1);
		assertEquals(res.getRatio(), 0.5);
	}
}
