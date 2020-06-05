package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();

    User findOne(Long id);

}
