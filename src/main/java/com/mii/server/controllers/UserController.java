/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.AuthDto;
import com.mii.server.dto.LoginDto;
import com.mii.server.dto.UserDto;
import com.mii.server.entities.User;
import com.mii.server.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jakab
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/login")
    public @ResponseBody AuthDto loginUser(@RequestBody LoginDto loginDto) throws Exception{
        return userService.loginUserByPassword(loginDto);
    }
    
//    CRUD MAPING
    @GetMapping
    public @ResponseBody List<User> getAllUser(){
        return userService.listAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody User getOneUser(@PathVariable Integer id){
        return userService.getOne(id);
    }
    
    @PostMapping
    public @ResponseBody UserDto createUser(@RequestBody UserDto user){
        return userService.create(user);
    }
    
    @PutMapping("/{id}")
    public @ResponseBody UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto user){
        return userService.update(id, user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
    
}