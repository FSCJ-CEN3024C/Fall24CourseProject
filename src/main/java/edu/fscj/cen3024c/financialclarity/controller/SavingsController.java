package edu.fscj.cen3024c.financialclarity.controller;

import edu.fscj.cen3024c.financialclarity.entity.Savings;
import edu.fscj.cen3024c.financialclarity.service.SavingsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savings")
public class SavingsController {
    @Autowired
    private SavingsService savingsService;

    @CrossOrigin(origins = {"http://example.com", "http://localhost"})
    @GetMapping("/{savingsId}")
    public ResponseEntity<Savings> getSavingsBySavingsId(@PathVariable Integer savingsId) {
        Savings savings = savingsService.findBySavingsById(savingsId);
        return ResponseEntity.ok(savings);
    }
}
