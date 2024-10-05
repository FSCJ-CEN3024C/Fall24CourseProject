package edu.fscj.cen3024c.financialclarity.repository;

import edu.fscj.cen3024c.financialclarity.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    // Find all Incomes
    List<Income> findAll();

    // Update this line to match the property name in the Income entity
    Income findByIncomeId(Integer incomeId);
}
