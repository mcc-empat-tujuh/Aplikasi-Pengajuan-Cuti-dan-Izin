/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.ManagerFill;
import com.mii.server.repositories.ManagerFillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class ManagerFillService {
    
    @Autowired
    ManagerFillRepository managerFillRepository;
    
//    CRUD
    public List<ManagerFill> listAll(){
        return managerFillRepository.findAll();
    }
    
    public ManagerFill getOne(Integer id){
        return managerFillRepository.findById(id).get();
    }
    
    public ManagerFill create(ManagerFill managerFill){
        return managerFillRepository.save(managerFill);
    }
    
    public ManagerFill update(Integer id, ManagerFill managerFill){
        ManagerFill oldManagerFill = managerFillRepository.getOne(id);
        oldManagerFill.setNote(managerFill.getNote());
        oldManagerFill.setStatusId(managerFill.getStatusId());
        oldManagerFill.setApprovementDate(managerFill.getApprovementDate());
        return managerFillRepository.save(oldManagerFill);
    }
    
    public void delete(Integer id){
        managerFillRepository.deleteById(id);
        System.out.println("is deleted?");
    }
    
}