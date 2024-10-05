package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.entity.Savings;

import edu.fscj.cen3024c.financialclarity.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;
    public Savings findBySavingsById(Integer savingsId) {return savingsRepository.findBySavingsId(savingsId);}
}
