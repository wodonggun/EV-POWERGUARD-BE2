package com.evpowerguard.registration.domain.event;

import com.evpowerguard.registration.config.AbstractEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDeleted extends AbstractEvent {
    
    private String id;
    private Date deleteTime= new Date(); // = 현재시간
    

}