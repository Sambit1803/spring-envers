package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).get();
        user.setUsername(updatedUser.getUsername());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @GetMapping("/revision/{id}")
    public void findRevision(@PathVariable("id") Long id) {
        System.out.println(userRepository.findLastChangeRevision(id));
    }
}