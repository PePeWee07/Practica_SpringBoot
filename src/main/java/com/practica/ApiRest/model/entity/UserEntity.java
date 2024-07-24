package com.practica.ApiRest.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "usesr")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name is required")
    @Size(min = 3, max = 50, message = "The name must be between 3 and 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull(message = "The last name is required")
    @Size(min = 3, max = 50, message = "The last name must be between 3 and 50 characters")
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotNull(message = "The email is required")
    @Email(message = "Must be a valid email")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @NotNull(message = "The DNI is required")
    @Size(min = 10, max = 10, message = "The DNI must be 10 characters")
    @Column(name = "dni", length = 10, nullable = false, unique = true)
    private String dni;

    @NotNull(message = "The salary is required")
    @DecimalMin(value = "1.0", message = "The salary must be at least 1 dollar")
    @DecimalMax(value = "5000.0", message = "The salary must be at most 5000 dollars")
    private Float salary;
    
}
