package edu.fscj.cen3024c.financialclarity.controller;

import edu.fscj.cen3024c.financialclarity.dto.BudgetDTO;
import edu.fscj.cen3024c.financialclarity.entity.Budget;
import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.service.BudgetService;

import edu.fscj.cen3024c.financialclarity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;
    @Autowired
    private UserService userService;

    private BudgetDTO convertToDTO(Budget budget) {
        return new BudgetDTO(budget.getId(), budget.getUserId(), budget.getBudgetName(), budget.getTimeCreate());
    }

    @GetMapping
    public List<BudgetDTO> getAllBudgets() {
        List<Budget> budgets = budgetService.findAll();
        return budgets.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{budgetName}")
    public ResponseEntity<BudgetDTO> getBudgetById(@PathVariable String budgetName) {
        Budget budget = budgetService.findByBudgetName(budgetName);
        BudgetDTO budgetDTO = convertToDTO(budget);
        return ResponseEntity.ok(budgetDTO);
    }

    @PostMapping()
    public ResponseEntity<BudgetDTO> createBudget(@RequestBody BudgetDTO budgetDTO) {
        BudgetDTO savedBudget = budgetService.save(budgetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBudget);
    }

    @PutMapping("/{budgetName}")
    public ResponseEntity<BudgetDTO> updateBudget(@PathVariable String budgetName, @RequestBody BudgetDTO budgetDTO) {
        Budget budget = budgetService.findByBudgetName(budgetName);
        if (budget != null) {
            budget.setBudgetName(budgetDTO.getBudgetName());
            budget.setUserId(budgetDTO.getUserId());
            Budget updatedBudget = budgetService.save(budget);
            return new ResponseEntity<>(convertToDTO(updatedBudget), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{budgetName}")
    public ResponseEntity<BudgetDTO> deleteBudget(@PathVariable String budgetName) {
        budgetService.deleteByBudgetName(budgetName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
