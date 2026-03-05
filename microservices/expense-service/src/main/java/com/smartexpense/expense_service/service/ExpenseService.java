package com.smartexpense.expense_service.service;
import com.smartexpense.expense_service.entity.Expense;
import com.smartexpense.expense_service.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(String email) {
        return expenseRepository.findByUserEmail(email);
    }
}
