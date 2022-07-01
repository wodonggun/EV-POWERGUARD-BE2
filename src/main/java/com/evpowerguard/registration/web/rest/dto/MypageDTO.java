package com.evpowerguard.registration.web.rest.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.evpowerguard.registration.domain.Bookmark} entity.
 */
@Getter
@Setter
@ToString

public class MypageDTO extends RepresentationModel<MypageDTO> implements Serializable  {

    private String id;
    private String eventType;
    private Long stationId;
    private String stationName;

    // Bookmark
    private Long bookmarkId;
    private String userId;
    private String stationAddress;
    private Boolean isFreeParking;
    private String availableTime;
    private String adminId;
    private String repairCompanyName;
    private String repairCompanyTel;

    // DriverLog
    private Long DriverLogId;
    private Long chargerId;
    private String carName;
    private Long batteryCapacity;
    private String chargerType;
    private Double chargeAmount;
    private Double chargeFee;
    private Double nowMileage;
    private Double beforeMileage;
    private Double electronicEfficiency;
    private String memo;
    private String loginId;
    private Date chargeDate;

    // BreakDownReport
    private Long breakDownReportId;
    private String reportStatus;
    private String reportDescription;
    private String reportedTime;
    private Long breakdownChargerId;
    private String breakdownChargerType;
    private String location;
    private String adminPhoneNumber;
    private String reporterId;
    private String reporterName;

    // Review
    private Long reviewId;
    private String reviewerId;
    private String contents;
    private Integer starPoint;
    private LocalDate registDate;
    private LocalDate updateDate;
}
