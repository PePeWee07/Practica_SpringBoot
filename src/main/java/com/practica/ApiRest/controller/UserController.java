package com.practica.ApiRest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ApiRest.model.entity.UserEntity;
import com.practica.ApiRest.services.user.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/hello")
    public String greet() {
        return "Hello, Jose!";
    }

    // Save user
    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        return ResponseEntity.ok(userService.save(user));
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    // Update user by id
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUserById(id, user));
    }

    // Delete user by id
    
}
