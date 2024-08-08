package com.springproject.springproject.domain.services.User;

import java.util.List;

import com.springproject.springproject.persistence.entities.User;

public interface UserService {
    
    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);

}
