package com.practica.ApiRest.model.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20, message = "The name must be between 3 and 20 characters")
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @NotNull
    @Size(min = 3, max = 20, message = "The last name must be between 3 and 20 characters")
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @NotNull
    @Email(message = "Must be a valid email")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @Size(min = 5, max = 10, message = "The password must be between 5 and 10 characters")
    @Column(name = "password", length = 10, nullable = false)
    private String password;

    @NotNull
    @Past(message = "The birthdate must be in the past")
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

}
