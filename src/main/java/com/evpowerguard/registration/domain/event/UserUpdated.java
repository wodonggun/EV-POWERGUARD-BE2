package com.evpowerguard.registration.domain.event;
import com.evpowerguard.registration.config.AbstractEvent;

import com.evpowerguard.registration.domain.enumeration.ChargerType;
import com.evpowerguard.registration.domain.enumeration.LoginType;
import com.evpowerguard.registration.domain.enumeration.MemberType;
import com.evpowerguard.registration.domain.vo.CarInfo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdated extends AbstractEvent {
    
    //수정되는 정보만
    // User Entity
    private String id;
    private String password; 
    private String email;
    private String name;
    private String phoneNumber;
    private MemberType memberType; 
    private Date CreateTime;
    private Date UpdateTime;

    //private CarInfo carInfo = new CarInfo();
    private String carNumber;
    private String carName;
    private String chargerType;
    private String batteryCapacity;


}