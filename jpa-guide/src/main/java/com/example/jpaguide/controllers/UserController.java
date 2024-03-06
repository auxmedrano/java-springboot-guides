package com.example.jpaguide.controllers;

import com.example.jpaguide.model.User;
import com.example.jpaguide.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return  "hello world";
    }

    @GetMapping("/all")
    public List<User> getAll(){
    return userRepository.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return  userRepository.save(user);
    }


}
