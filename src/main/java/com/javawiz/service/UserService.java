package com.javawiz.service;

import java.util.List;

import com.javawiz.entity.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}