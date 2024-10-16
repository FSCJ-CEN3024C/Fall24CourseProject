package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.BudgetDTO;
import edu.fscj.cen3024c.financialclarity.entity.Budget;
import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> findAll() { return budgetRepository.findAll(); }
    public Budget findByBudgetName(String budgetName) { return budgetRepository.findByBudgetName(budgetName);}

    @Transactional
    public void deleteByBudgetName(String budgetName) { budgetRepository.deleteByBudgetName(budgetName);}

    public Budget save(Budget budget) { return budgetRepository.save(budget); }
    public BudgetDTO save(BudgetDTO budgetDTO) {
        Budget budget = new Budget();
        budget.setBudgetName(budgetDTO.getBudgetName());
        budget.setUserId(budgetDTO.getUserId());
        budget.setTimeCreate(new Date());
        Budget savedBudget = budgetRepository.save(budget);
        return convertToDTO(savedBudget);
    }

    private BudgetDTO convertToDTO(Budget budget) {
        return new BudgetDTO(budget.getId(), budget.getUserId(), budget.getBudgetName(), budget.getTimeCreate());
    }
}
