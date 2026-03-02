package com.MCA.SmartExpenseTracker.controller;

import com.MCA.SmartExpenseTracker.entity.Expense;
import com.MCA.SmartExpenseTracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;
    @PostMapping("/user/{userId}")
    public Expense createExpense(
            @PathVariable Long userId,
            @RequestBody Expense expense
    ){
        return expenseService.createExpence(userId,expense);
    }
    @GetMapping("/user/{userId}")
    public List<Expense> getExpenseByUser(@PathVariable Long userId){
        return expenseService.getExpensesByUser(userId);
    }
}
