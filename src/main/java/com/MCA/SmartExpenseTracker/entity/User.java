package com.MCA.SmartExpenseTracker.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "password is required ")
    private String password;
}
