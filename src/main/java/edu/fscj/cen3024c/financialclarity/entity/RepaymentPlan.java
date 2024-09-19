package edu.fscj.cen3024c.financialclarity.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "repayment plan")
public class RepaymentPlan {
    //Defining the columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column(nullable = false, unique = true)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private Float totalExpense;

    @Column(nullable = false, unique = true)
    private Float payment;

    @Column(nullable = false, unique = true)
    private String timeLine;

    @Column(nullable = false, unique = true)
    private String category;

    @Column(nullable = false, unique = true)
    private Long description;


    // Getters and Setters
    //ExpenseId
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    //UserID
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //Amount
    public Float getPayment() {
        return payment;
    }

    public void setPayment(Float payment) {
        this.payment = payment;
    }

    //Category
    public String getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(String timeLine) {
        this.timeLine= timeLine;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

}