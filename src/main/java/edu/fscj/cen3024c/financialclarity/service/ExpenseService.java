package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.ExpensesDTO;
import edu.fscj.cen3024c.financialclarity.dto.UserDTO;
import edu.fscj.cen3024c.financialclarity.entity.Expenses;

import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpensesRepository expensesRepository;
    public Expenses findByExpencesId(Integer expensesId) {return expensesRepository.findByExpenseId(expensesId);}
    public List<Expenses> findAll() {return expensesRepository.findAll();}
    public Expenses save(Expenses expenses ) { return expensesRepository.save(expenses); }
    public ExpensesDTO save(ExpensesDTO expensesDTO) {
        // Convert ExpenseDTO to Expense entity
        Expenses expenses = new Expenses();
        expenses.setExpenseId(ExpensesDTO.getExpenseId());
        expenses.setUserId(ExpensesDTO.getUserId());
        expenses.setAmount(ExpensesDTO.getAmount());
        expenses.setName(ExpensesDTO.getName());

        // Save the User entity
        Expenses savedExpenses = expensesRepository.save(expenses);

        // Convert saved User entity back to UserDTO and return
        return convertToDTO(savedExpenses);
    }
}

