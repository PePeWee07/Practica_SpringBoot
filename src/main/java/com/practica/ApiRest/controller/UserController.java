package com.practica.ApiRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ApiRest.model.entity.UserEntity;
import com.practica.ApiRest.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> findAllUsers(){
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        try {
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findUserById(Long id){
        try {
            return ResponseEntity.ok(userService.findByID(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user, Long id){
        try {
            return ResponseEntity.ok(userService.update(user, id));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    
}
