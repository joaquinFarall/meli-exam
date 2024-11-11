package org.example.meliexam.api.controller;

import org.example.meliexam.api.dto.StatResponse;
import org.example.meliexam.api.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {
    private final StatService statService;

    @Autowired
    public StatsController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stats")
    public ResponseEntity<StatResponse> getStats() {
        try {
            StatResponse statResponse = statService.getStats();
            return ResponseEntity.ok(statResponse);
        } catch (Exception e) {
            System.out.println("Error at StatsController.getStatus -> " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
