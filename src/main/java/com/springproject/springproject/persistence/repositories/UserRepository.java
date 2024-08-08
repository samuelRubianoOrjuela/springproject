package com.springproject.springproject.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
