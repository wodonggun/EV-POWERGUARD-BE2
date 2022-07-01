package com.evpowerguard.registration.domain.event;

import com.evpowerguard.registration.config.AbstractEvent;
import com.evpowerguard.registration.domain.enumeration.ChargerType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChargerBroken extends AbstractEvent {
    
    //private Long id;  //우동근 - String으로
    private String id;
    private ChargerType chargerType;
    private Long chargingStationId;
    private String chargerName;
    private String serialNumber;
    private String modelNo;
    private String connectorType;
    private String inputVoltage;
    private String outputVoltage;
    private String ratedCapacity;
    private String chargingTime;

}
