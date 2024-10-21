package edu.fscj.cen3024c.financialclarity.controller;

import edu.fscj.cen3024c.financialclarity.entity.Income;
import edu.fscj.cen3024c.financialclarity.service.IncomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @CrossOrigin(origins = {"http://example.com", "http://localhost"})
    @GetMapping("/{incomeId}")
    public ResponseEntity<Income> getIncome(@PathVariable int incomeId) {
        Income income = incomeService.findIncomeById(incomeId);
        return ResponseEntity.ok(income);
    }

}
