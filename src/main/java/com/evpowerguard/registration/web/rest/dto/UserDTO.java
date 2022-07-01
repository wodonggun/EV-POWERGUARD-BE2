package com.evpowerguard.registration.web.rest.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;
import com.evpowerguard.registration.domain.enumeration.LoginType;
import com.evpowerguard.registration.domain.enumeration.MemberType;
import com.evpowerguard.registration.domain.vo.CarInfo;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the {@link com.evpowerguard.registration.domain.User} entity.
 */
@Getter
@Setter
@ToString
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable  {

       // User Entity
       private String id;
       private String password; 
       private String email;
       private String name;
       private String phoneNumber;
       private MemberType memberType; 
       private Date CreateTime;
       private Date UpdateTime;
       private Date loginTime;
       private int loginFailedCount;
       private LoginType loginType;  
   
       private CarInfo carInfo = new CarInfo();
    //    private String carNumber;
    //    private String carName;
    //    private String chargerType;
    //    private String batteryCapacity;
}
