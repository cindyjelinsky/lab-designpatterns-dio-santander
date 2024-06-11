package com.lab_dio_santander.design_patterns.services;

import com.lab_dio_santander.design_patterns.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void create(User user);

    void update(Long id, User user);

    void delete(Long id);

}
