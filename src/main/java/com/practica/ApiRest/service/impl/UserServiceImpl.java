package com.practica.ApiRest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.ApiRest.model.entity.UserEntity;
import com.practica.ApiRest.repository.UserRepository;
import com.practica.ApiRest.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findByID(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no econtrado"));
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity update(UserEntity user, Long id) {
        UserEntity userUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no econtrado"));
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        return userRepository.save(userUpdate);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    
}
