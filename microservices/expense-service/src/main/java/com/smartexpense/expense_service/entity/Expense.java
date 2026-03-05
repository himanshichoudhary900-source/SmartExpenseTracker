package com.smartexpense.expense_service.entity;
import jakarta.persistence.*;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String category;
    private String userEmail;

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
