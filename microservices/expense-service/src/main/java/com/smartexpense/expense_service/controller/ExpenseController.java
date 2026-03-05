package com.smartexpense.expense_service.controller;
import com.smartexpense.expense_service.entity.Expense;
import com.smartexpense.expense_service.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.smartexpense.expense_service.security.JWTService;
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final JWTService jwtService;
    public ExpenseController(ExpenseService expenseService , JWTService jwtService) {
        this.expenseService = expenseService;
        this.jwtService = jwtService;
    }

    @PostMapping
    public Expense createExpense(
            @RequestHeader("Authorization") String token,
            @RequestBody Expense expense) {

        token = token.substring(7);

        String email = jwtService.extractEmail(token);

        expense.setUserEmail(email);

        return expenseService.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getExpenses(
            @RequestHeader("Authorization") String token) {

        token = token.substring(7);

        String email = jwtService.extractEmail(token);

        return expenseService.getExpensesByUser(email);
    }
}
