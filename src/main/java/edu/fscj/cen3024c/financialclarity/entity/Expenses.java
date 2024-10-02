package edu.fscj.cen3024c.financialclarity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expenses {
    //Defining the columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;

    @Column(nullable = false, unique = true)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private Float amount;

    @Column(nullable = false, unique = true)
    private String name;



    // Getters and Setters
    //ExpenseId
    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    //UserID
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //Amount
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    //Category
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}