package edu.fscj.cen3024c.financialclarity.controller;


import edu.fscj.cen3024c.financialclarity.entity.Expenses;
import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.service.ExpenseService;


import edu.fscj.cen3024c.financialclarity.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expences")
public class ExpensesController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/{expencesId}")
    public ResponseEntity<Expenses> getIncome(@PathVariable Integer expencesId) {

        Expenses expenses = expenseService.findByExpencesId(expencesId);
        return ResponseEntity.ok(expenses);
    }

}
