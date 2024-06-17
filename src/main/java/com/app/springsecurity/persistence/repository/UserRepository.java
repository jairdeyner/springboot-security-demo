package com.app.springsecurity.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.springsecurity.persistence.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
