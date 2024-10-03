package edu.fscj.cen3024c.financialclarity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    //Defining the columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false, unique = true)
    private String totalIncome;

    @Column(nullable = false, unique = true)
    private String totalExpences;



    // Getters and Setters
    //ID
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    //Username
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    //Age
    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}
    //Email
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    //Password
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    //TotalIncome
    public String getTotalIncome() {return totalIncome;}
    public void setTotalIncome(String totalIncome) {this.totalIncome = totalIncome;}
    //TotalExpences
    public String getTotalExpences() {return totalExpences;}
    public void setTotalExpences(String totalExpences) {this.totalExpences = totalExpences;}


}