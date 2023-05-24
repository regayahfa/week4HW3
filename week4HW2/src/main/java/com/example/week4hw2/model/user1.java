package com.example.week4hw2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class user1 {
    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @NotEmpty(message = "name cannot be Empty")
    @Column(columnDefinition = "varchar(4)not null")
    private String name;
    @NotEmpty(message = "username cannot be null")
    @Min(4)
    @Column(columnDefinition = "varchar(20) unique")
    private String username;
    @NotEmpty(message = "pass cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String passowrd;
    @NotEmpty(message = "cannot be Empty")
    @Column(columnDefinition = "varchar(20) unique")
    @Email(message = "must be valid email")
    private String email;
    @NotEmpty(message = "role connot be null")
    @Column(columnDefinition = "varchar(20) not null check(role='user' or role='admin")
    private  String role;
    @NotEmpty(message = "age must be valid email")
    @Positive
    @Column(columnDefinition = "varchar(20) not null")
    private int age;
}
