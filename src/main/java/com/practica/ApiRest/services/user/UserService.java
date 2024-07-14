package com.practica.ApiRest.services.user;

import java.util.List;

import com.practica.ApiRest.model.entity.UserEntity;

public interface UserService {
    
    public UserEntity save(UserEntity user);

    public List<UserEntity> findAll();

    public UserEntity findUserById(Long id);

    public UserEntity updateUserById(Long id, UserEntity user);

    public void deleteUserById(Long id);

}
