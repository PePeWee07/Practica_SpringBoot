package com.practica.ApiRest.service.user;
import java.util.*;
import com.practica.ApiRest.model.entity.UserEntity;

public interface UserService {

    List<UserEntity> ListAllUsers();
    UserEntity getUserById(Long id);

    UserEntity createUser(UserEntity user);
    UserEntity updateUser(UserEntity user, Long id);

    void deleteUser(Long id);

}
