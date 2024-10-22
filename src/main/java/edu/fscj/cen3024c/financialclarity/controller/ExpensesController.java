package edu.fscj.cen3024c.financialclarity.controller;


import edu.fscj.cen3024c.financialclarity.entity.Expenses;
import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.service.ExpenseService;


import edu.fscj.cen3024c.financialclarity.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    @Autowired
    private ExpenseService expenseService;

    @CrossOrigin(origins = {"http://example.com", "http://localhost"})
    @GetMapping("/{expensesId}")
    public ResponseEntity<Expenses> getIncome(@PathVariable Integer expensesId) {

        Expenses expenses = expenseService.findByExpencesId(expensesId);
        return ResponseEntity.ok(expenses);
    }

}
