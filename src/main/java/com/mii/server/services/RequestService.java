/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.EmployeeDto;
import com.mii.server.dto.RequestDto;
import com.mii.server.entities.Employee;
import com.mii.server.entities.LeaveType;
import com.mii.server.entities.ManagerFill;
import com.mii.server.entities.Request;
import com.mii.server.entities.Status;
import com.mii.server.repositories.RequestRepository;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class RequestService {
    
    @Autowired
    RequestRepository requestRepository;
    
    @Autowired
    EmployeeService es;
    
    @Autowired
    MessageService ms;
    
//    CRUD
    public List<Request> listAll(){
        return requestRepository.findAll();
    }
    
    public Request getOne(Integer id){
        return requestRepository.findById(id).get();
    }
    
    public List<Request> getByEmployeeId(Employee employeeId){
        return requestRepository.findByEmployeeId(employeeId);
    }
    
    public Request create(RequestDto request) throws MessagingException {
        List<Request> reqs = listAll();
        int i = 0;
        for (Request req : reqs) {
            i = req.getReqId();
        }
        i = i + 1;
        EmployeeDto e = es.getOneById(request.getEmployeeId());
        ManagerFill managerFill = new ManagerFill(
                i, 
                "Give ur notes", 
                e.getManagerId(), 
                new Status(1));
        Request newRequest = new Request(
                i,
                new Employee(request.getEmployeeId()), 
                new LeaveType(request.getLeaveId()), 
                request.getLeaveDuration(),
                request.getStartDate(), 
                request.getReasons(), 
                managerFill);
        
        Request newReq = requestRepository.save(newRequest);
        if (requestRepository.existsById(i)) {
            ms.sentRequest(newReq.getEmployeeId().getManagerId().getEmployeeId());
        }
        return newReq;
    }
        
    public Request update(Integer id, RequestDto request){
        Request oldUser = requestRepository.getOne(id);
        oldUser.setLeaveId(new LeaveType(request.getLeaveId()));
        oldUser.setStartDate(request.getStartDate());
        oldUser.setReasons(request.getReasons());
        return requestRepository.save(oldUser);
    }
    
    public void delete(Integer id){
        requestRepository.deleteById(id);
    }
    
}