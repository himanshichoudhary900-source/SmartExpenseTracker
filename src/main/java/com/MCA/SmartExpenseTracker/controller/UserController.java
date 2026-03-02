package com.MCA.SmartExpenseTracker.controller;
import com.MCA.SmartExpenseTracker.dto.UserResponseDTO;
import com.MCA.SmartExpenseTracker.entity.User;
import  com.MCA.SmartExpenseTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.MCA.SmartExpenseTracker.dto.UserResponseDTO;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final  UserService userService;
    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody User user){
        return  userService.createUser(user);
    }

    @GetMapping
    public  List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }
}
