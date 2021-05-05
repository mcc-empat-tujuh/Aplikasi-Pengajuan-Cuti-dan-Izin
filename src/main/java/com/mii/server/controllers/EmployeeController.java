/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.EmployeeDto;
import com.mii.server.entities.User;
import com.mii.server.services.EmployeeService;
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
@RequestMapping("/api/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping
    public @ResponseBody List<EmployeeDto> getAllEmployee(){
        return employeeService.listAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody EmployeeDto getOneEmployee(@PathVariable Integer id){
        return employeeService.getOneById(id);
    }
    
    @PostMapping("/by-username")
    public @ResponseBody EmployeeDto getOneEmployeeUsername(@RequestBody User user){
        return employeeService.getOneByUsername(user.getUsername());
    }
    
    @PostMapping
    public @ResponseBody EmployeeDto createEmployee(@RequestBody EmployeeDto emp){
        return employeeService.create(emp);
    }
    
    @PutMapping("/{id}")
    public @ResponseBody EmployeeDto updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto emp){
        return employeeService.update(id, emp);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.delete(id);
    }
}