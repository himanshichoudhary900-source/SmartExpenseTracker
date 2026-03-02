package com.MCA.SmartExpenseTracker.service;
import com.MCA.SmartExpenseTracker.entity.User;
import com.MCA.SmartExpenseTracker.entity.Expense;
import com.MCA.SmartExpenseTracker.repository.ExpenseRepository;
import com.MCA.SmartExpenseTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public Expense createExpence(Long userId , Expense expense){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(Long userId){
        return expenseRepository.findByUserId(userId);
    }
}
