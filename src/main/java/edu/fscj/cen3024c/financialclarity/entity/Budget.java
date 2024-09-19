package edu.fscj.cen3024c.financialclarity.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "budget")
public class Budget {
    //Defining the columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer budgetId;

    @Column(nullable = false, unique = true)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String budgetName;

    @Column(nullable = false, unique = true)
    private Date timeCreate;


    // Getters and Setters
    //ExpenseId
    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer budgetId) {
        this.budgetId = budgetId;
    }

    //UserID
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //Amount
    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    //Category
    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }
}