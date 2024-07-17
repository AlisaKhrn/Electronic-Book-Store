package com.example.ElectronicBookStore1.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "username")
    private String username;


    @NotEmpty(message = "Пароль не должен быть пустым")
    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role = "ROLE_USER";
}