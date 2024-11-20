package edu.fscj.cen3024c.financialclarity.repository;

import edu.fscj.cen3024c.financialclarity.entity.Budget;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class BudgetRepositoryInMemoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveBudget_ShouldPersistBudgetInDatabase() {
        Budget budget = new Budget();
        budget.setBudgetName("test");
        budget.setUserId(1);
        budget.setTimeCreate(new Date());

        Budget savedBudget = budgetRepository.save(budget);

        Budget foundBudget = entityManager.find(Budget.class, savedBudget.getId());
        assertThat(foundBudget).isEqualTo(budget);
    }

    @Test
    public void findByBudgetName_ShouldReturnBudget_WhenBudgetExists() {

        Budget budget = new Budget();
        budget.setBudgetName("test2");
        budget.setUserId(1);
        budget.setTimeCreate(new Date());

        entityManager.persist(budget);

        Budget foundBudget = budgetRepository.findByBudgetName("test2");

        assertThat(foundBudget).isNotNull();
        assertThat(foundBudget).isEqualTo(budget);

    }


    @Test
    public void findByBudgetName_ShouldReturnEmpty_WhenBudgetDoesNotExist() {
        Integer nonExistentBudgetId = 1000;
        Optional<Budget> foundBudget = budgetRepository.findById(nonExistentBudgetId);
        assertThat(foundBudget).isEmpty();

    }


}
