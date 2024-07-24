package com.practica.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.ApiRest.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
