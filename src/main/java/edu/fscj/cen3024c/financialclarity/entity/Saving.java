package edu.fscj.cen3024c.financialclarity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "savings")
public class Saving {
    @Id
    @Column(name = "savingsgoalid", nullable = false)
    private Integer id;

    @Column(name = "savingsamount")
    private Integer savingsamount;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSavingsamount() {
        return savingsamount;
    }

    public void setSavingsamount(Integer savingsamount) {
        this.savingsamount = savingsamount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}