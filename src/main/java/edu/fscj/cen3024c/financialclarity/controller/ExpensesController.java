package edu.fscj.cen3024c.financialclarity.controller;


import edu.fscj.cen3024c.financialclarity.dto.ExpensesDTO;
import edu.fscj.cen3024c.financialclarity.dto.UserDTO;
import edu.fscj.cen3024c.financialclarity.entity.Expenses;
import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.service.ExpenseService;


import edu.fscj.cen3024c.financialclarity.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpenseService expenseService;

    private ExpensesDTO convertToDTO(Expenses expenses) {
        return new ExpensesDTO(expenses.getExpenseId(), expenses.getUserId(), expenses.getAmount(), expenses.getName());
    }
    @GetMapping
    public List<ExpensesDTO> getAllUsers() {
        List<Expenses> expenses = expenseService.findAll();
        return expenses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @CrossOrigin(origins = {"http://example.com", "http://localhost"})
    @GetMapping("/{expensesId}")
    public ResponseEntity<Expenses> getIncome(@PathVariable Integer expensesId) {

        Expenses expenses = expenseService.findByExpencesId(expensesId);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping()
    public ResponseEntity<ExpensesDTO> createUser(@RequestBody ExpensesDTO expensesDTO) {
        ExpensesDTO savedExpense = expenseService.save(ExpensesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

}
