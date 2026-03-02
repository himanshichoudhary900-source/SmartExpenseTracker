package com.MCA.SmartExpenseTracker.controller;
import com.MCA.SmartExpenseTracker.dto.LoginRequest;
import com.MCA.SmartExpenseTracker.dto.LoginResponse;
import com.MCA.SmartExpenseTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private  final UserService userService;
    @PostMapping("/login")
    public  LoginResponse login(@RequestBody LoginRequest request){
        return userService.login(request);
    }
}
