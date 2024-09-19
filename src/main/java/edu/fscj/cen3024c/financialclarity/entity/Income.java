package edu.fscj.cen3024c.financialclarity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "income")
public class Income {
    //Defining the columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incomeId;

    @Column(nullable = false, unique = true)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private Float amount;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String category;


    // Getters and Setters
    //IncomeId
    public Integer getIncomeId() {return incomeId;}
    public void setIncomeId(Integer incomeId) {this.incomeId = incomeId;}
    //UserID
    public Integer getUserId() {return userId;}
    public void setUserId(Integer userId) {this.userId = userId;}
    //Amount
    public Float getAmount() {return amount;}
    public void setAmount(Float amount) {this.amount = amount;}
    //Name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    //Category
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

}