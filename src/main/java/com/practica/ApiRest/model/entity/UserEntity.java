package com.practica.ApiRest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(name = "name",nullable = false, length = 50)
    private String name;

    @NotNull
    @Email(message = "El email debe ser válido")
    @Column(name = "email",nullable = false, length = 50, unique = true)
    private String email;

    @NotNull
    @Size(min = 3, max = 50, message = "El password debe tener entre 3 y 50 caracteres")
    @Column(name = "password",nullable = false, length = 50)
    private String password;

}
