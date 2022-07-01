package com.evpowerguard.registration.domain;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bookmark")
@Data
public class Bookmark implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;


    // ChargingStation
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    //@JoinColumn(name = "charging_station_id")
    //private ChargingStation chargingStation;

}
