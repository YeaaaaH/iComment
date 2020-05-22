package com.fellas.usersservice.controller;

import com.fellas.usersservice.model.User;
import com.fellas.usersservice.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") long id) {
        return service.findUserById(id);
    }

    @GetMapping("all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("create")
    public User create(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PutMapping("update")
    public User update(@RequestBody User user) {
        return service.saveUser(user);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        return service.deleteUserById(id);
    }
}
