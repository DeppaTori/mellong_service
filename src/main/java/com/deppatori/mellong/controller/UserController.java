package com.deppatori.mellong.controller;

import com.deppatori.mellong.model.User;
import com.deppatori.mellong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Set<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User save(@RequestBody  User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return userService.update(id,user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
