package com.example.demo.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Create user
    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user) {

        return userService.saveUser(user);
    }


    // Get all users
    @GetMapping
    public List<UserEntity> getAllUsers() {

        return userService.getAllUsers();
    }


    // Get user by id
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }


    // Find by username
    @GetMapping("/username/{username}")
    public UserEntity getByUsername(
            @PathVariable String username) {

        return userService.getUserByUsername(username);
    }


    // Search username
    @GetMapping("/search")
    public List<UserEntity> search(
            @RequestParam String keyword) {

        return userService.searchUser(keyword);
    }


    // Update
    @PutMapping("/{id}")
    public UserEntity updateUser(
            @PathVariable Long id,
            @RequestBody UserEntity user) {

        return userService.updateUser(id, user);
    }


    // Delete
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }

}