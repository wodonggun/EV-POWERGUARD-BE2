package com.evpowerguard.registration.domain.vo;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class RepairCompanyVo {
    
    private String repairCompanyName;
    private String repairCompanyTel;
    
}   
