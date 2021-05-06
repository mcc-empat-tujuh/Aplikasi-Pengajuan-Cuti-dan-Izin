/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.client.Models;

import lombok.Data;

/**
 *
 * @author jakab
 */
@Data
public class LeaveType {
    
    private Integer leaveId;
    private String leaveName;

    public LeaveType() {
    }

    public LeaveType(Integer leaveId, String leaveName) {
        this.leaveId = leaveId;
        this.leaveName = leaveName;
    }
    
}
