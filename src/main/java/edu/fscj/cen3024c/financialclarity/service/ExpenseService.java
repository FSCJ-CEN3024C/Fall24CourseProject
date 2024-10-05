package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.entity.Expenses;

import edu.fscj.cen3024c.financialclarity.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpensesRepository expensesRepository;
    public Expenses findByExpencesId(Integer expensesId) {return expensesRepository.findByExpenseId(expensesId);}
}
