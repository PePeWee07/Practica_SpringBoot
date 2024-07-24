package com.practica.ApiRest.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.ApiRest.model.entity.UserEntity;
import com.practica.ApiRest.repository.UserRepository;
import com.practica.ApiRest.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> ListAllUsers() {
        return userRepository.findAll();
}

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user, Long id) {
        UserEntity dataUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            dataUser.setName(user.getName());
            dataUser.setLastName(user.getLastName());
            dataUser.setEmail(user.getEmail());
            dataUser.setDni(user.getDni());
            dataUser.setSalary(user.getSalary());
        return userRepository.save(dataUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
}
