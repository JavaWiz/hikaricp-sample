package com.javawiz.dao;

import java.util.List;

import com.javawiz.entity.User;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
}