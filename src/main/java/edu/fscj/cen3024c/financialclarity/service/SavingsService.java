package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.SavingsDTO;
import edu.fscj.cen3024c.financialclarity.entity.Savings;

import edu.fscj.cen3024c.financialclarity.repository.SavingsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;

    public List<Savings> findAll() {return savingsRepository.findAll();}
    public Savings findBySavingsById(Integer savingsId) {return savingsRepository.findBySavingsId(savingsId);}

    @Transactional
    public void deleteBySavingsId(Integer savingsId) {savingsRepository.deleteBySavingsId(savingsId);}
    public Savings save(Savings savings) {return savingsRepository.save(savings);}

    public SavingsDTO save(SavingsDTO savingsDTO){
        Savings savings = new Savings();
        savings.setSavingsId(savingsDTO.getSavingsId());
        savings.setSavingsamount(savingsDTO.getSavingsAmount());
        savings.setDescription(savingsDTO.getDescription());
        savings.setUserid(savingsDTO.getUserid());

        Savings savedSavings = savingsRepository.save(savings);
        return convertToDTO(savedSavings);
    }

    private SavingsDTO convertToDTO(Savings savings) {
        return new SavingsDTO(savings.getSavingsId(), savings.getSavingsamount(), savings.getUserid(), savings.getDescription());
    }
}
