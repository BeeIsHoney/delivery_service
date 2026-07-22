package com.example.demo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.user.dao.UserDao;
import com.example.demo.user.entity.UserEntity;

@Service
public class UserService {

	private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    // Create
    public UserEntity saveUser(UserEntity user) {

        if (userDao.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return userDao.save(user);
    }


    // Read all
    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }


    // Read by id
    public UserEntity getUserById(Long id) {

        return userDao.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found : " + id));
    }


    // Find by username
    public UserEntity getUserByUsername(String username) {

        return userDao.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Username not found"));
    }


    // Search username
    public List<UserEntity> searchUser(String keyword) {

        return userDao.findByUsernameContaining(keyword);
    }


    // Update
    public UserEntity updateUser(Long id, UserEntity user) {

        UserEntity existingUser = getUserById(id);

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());

        return userDao.save(existingUser);
    }


    // Delete
    public void deleteUser(Long id) {

        UserEntity user = getUserById(id);

        userDao.delete(user);
    }
}
