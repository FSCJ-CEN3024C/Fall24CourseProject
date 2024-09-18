package edu.fscj.cen3024c.financialclarity;

// Entity and repostirory imports
import edu.fscj.cen3024c.financialclarity.entity.Users;
import edu.fscj.cen3024c.financialclarity.repository.UsersRepository;

import edu.fscj.cen3024c.financialclarity.entity.Budget;
import edu.fscj.cen3024c.financialclarity.repository.BudgetRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("edu.fscj.cen3024c.financialclarity.repository")
public class FinancialClarityApplication implements CommandLineRunner {


	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BudgetRepository budgetRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinancialClarityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create User
		Users user1 = new Users();
		user1.setUsername("Cole");
		user1.setAge(20);
		user1.setEmail("test@example.com");
		user1.setPassword("pass");
		user1.setTotalIncome("1000");
		user1.setTotalExpences("1000");
		usersRepository.save(user1);

		// Create Budget
		Budget budget = new Budget();
		budget.setUserId(user1.getId()); // Set the userId to the id of the saved user
		budget.setBudgetName("Monthly Budget");
		budget.setTimeCreate(new Date()); // Current date and time
		budgetRepository.save(budget);





		// Print all Users
		List<Users> users = usersRepository.findAll();
		System.out.println("All users in the database:");
		users.forEach(user -> System.out.println(user.getUsername()));


		// Print all Budgets
		List<Budget> budgets = budgetRepository.findAll();
		System.out.println("All Budgets in the database:");
		budgets.forEach(b -> System.out.println(b.getBudgetName()));

	}
}
