package edu.fscj.cen3024c.financialclarity;

// Entity and repostirory imports
import edu.fscj.cen3024c.financialclarity.entity.Expenses;
import edu.fscj.cen3024c.financialclarity.entity.Income;
import edu.fscj.cen3024c.financialclarity.entity.Users;
import edu.fscj.cen3024c.financialclarity.repository.ExpensesRepository;
import edu.fscj.cen3024c.financialclarity.repository.IncomeRepository;
import edu.fscj.cen3024c.financialclarity.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("edu.fscj.cen3024c.financialclarity.repository")
public class FinancialClarityApplication implements CommandLineRunner {


	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private IncomeRepository incomeRepository;
	@Autowired
	private ExpensesRepository expensesRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinancialClarityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Users user1 = new Users();
		user1.setUsername("Cole");
		user1.setAge(20);
		user1.setEmail("test@example.com");
		user1.setPassword("pass");
		user1.setTotalIncome("1000");
		user1.setTotalExpences("1000");
		usersRepository.save(user1);

		Income income1 = new Income();
		income1.setName("Paycheck 1");
		income1.setAmount(1200.00f);
		incomeRepository.save(income1);

		Expenses expense1 = new Expenses();
		expense1.setName("Netflix");
		expense1.setAmount(7.99f);
		expensesRepository.save(expense1);



		// Call the findAll() method to test it
		List<Users> users = usersRepository.findAll();
		List<Expenses> expenses = expensesRepository.findAll();
		List<Income> incomes = incomeRepository.findAll();

		// Print the results to verify
		System.out.println("All users in the database:");
		users.forEach(user -> System.out.println(user.getUsername()));

		System.out.println("All expenses in the database:");
		expenses.forEach(expense -> System.out.println(expense.getName() + " " + expense.getAmount()));

		System.out.println("All incomes in the database:");
		incomes.forEach(income -> System.out.println(income.getName() + " " + income.getAmount()));
	}
}
