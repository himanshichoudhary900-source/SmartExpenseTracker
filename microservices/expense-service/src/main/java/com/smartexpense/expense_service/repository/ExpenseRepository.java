package com.smartexpense.expense_service.repository;
import com.smartexpense.expense_service.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ExpenseRepository extends  JpaRepository<Expense , Long>{
    List<Expense> findByUserEmail(String userEmail);
}
