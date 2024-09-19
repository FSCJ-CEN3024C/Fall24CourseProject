package edu.fscj.cen3024c.financialclarity.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "saving goals")
public class SavingGoals {
    //Defining the columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer savingsGoalsId;

    @Column(nullable = false, unique = true)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String goalName;

    @Column(nullable = false, unique = true)
    private Float totalAmount;

    @Column(nullable = false, unique = true)
    private Float spentAmount;

    @Column(nullable = false, unique = true)
    private Date startDate;

    @Column(nullable = false, unique = true)
    private Date endDate;

    @Column(nullable = false, unique = true)
    private Date endGoal;

    @Column(nullable = false, unique = true)
    private Long description;

    // Getters and Setters
    //ExpenseId
    public Integer getSavingsGoalsId() {
        return savingsGoalsId;
    }

    public void setSavingsGoalsId(Integer savingsGoalsId) {
        this.savingsGoalsId = savingsGoalsId;
    }

    //UserID
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //Amount
    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    //Category
    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(Float spentAmount) {
        this.spentAmount = spentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(Date endGoal) {
        this.endGoal = endGoal;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

}