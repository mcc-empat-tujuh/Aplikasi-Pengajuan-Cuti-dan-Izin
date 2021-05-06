/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.client.Models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author jakab
 */
@Data
public class Request {
    
    private Integer reqId;
    private Date startDate;
    private Date endDate;
    private String reasons;
    private Integer leaveDuration;
    
    private Employee employeeId;
    private LeaveType leaveId;
    private ManagerFill managerFill;
    
}
