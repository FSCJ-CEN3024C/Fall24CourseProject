package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.IncomeDTO;
import edu.fscj.cen3024c.financialclarity.entity.Income;

import edu.fscj.cen3024c.financialclarity.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> findAll() { return incomeRepository.findAll(); }
    public Income findIncomeById(Integer incomeId) {return incomeRepository.findByIncomeId(incomeId);}
    @Transactional
    public void deleteById(int id) {incomeRepository.deleteById(id);}
    public IncomeDTO save(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setIncomeId(incomeDTO.getIncomeId());
        income.setUserId(incomeDTO.getUserId());
        income.setName(incomeDTO.getName());
        income.setAmount(incomeDTO.getAmount());
        Income savedIncome = incomeRepository.save(income);
        return convertToDTO(savedIncome);
    }

    private IncomeDTO convertToDTO(Income income) {
        return new IncomeDTO(income.getIncomeId(), income.getUserId(), income.getAmount(), income.getName());
    }

}
