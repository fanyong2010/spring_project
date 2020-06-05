package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/")
    public List<User> add(@RequestBody User user) {
        userService.add(user);
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public List<User> del(@PathVariable("id")Long id) {
        userService.delete(id);
        return userService.findAll();
    }


    @PutMapping("/")
    public List<User> del(@RequestBody User user) {
        userService.update(user);
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

}
