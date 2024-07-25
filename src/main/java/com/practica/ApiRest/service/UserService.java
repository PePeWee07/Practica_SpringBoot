package com.practica.ApiRest.service;

import java.util.List;

import com.practica.ApiRest.model.entity.UserEntity;

public interface UserService {

    //listar
    List<UserEntity> findAll();
    
    //Obtener by ID
    UserEntity findByID(Long id);

    //Guardar
    UserEntity save(UserEntity user);

    //Actualizar
    UserEntity update(UserEntity user, Long id);

    //Eliminar
    void delete(Long id);
}