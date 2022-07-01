package com.evpowerguard.registration.web.rest.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the {@link com.evpowerguard.bookmark.domain.Bookmark} entity.
 */
@Getter
@Setter
@ToString
public class BookmarkDTO extends RepresentationModel<BookmarkDTO> implements Serializable  {

    
    private Long id;
    private String userId;

    // ChargingStation DTO
    private Long stationId;
    private String stationName;
    private String stationAddress;
    private Boolean isFreeParking;
    private String availableTime;
    private String adminId;
    private String repairCompanyName;
    private String repairCompanyTel;

    private Long countAvailableChargerFast;
    private Long countAvailableChargerNormal;
    private Long countBrokenCharger;
}
