package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.entity.Income;

import edu.fscj.cen3024c.financialclarity.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    public Income findIncomeById(Integer incomeId) {return incomeRepository.findByIncomeId(incomeId);}
}
