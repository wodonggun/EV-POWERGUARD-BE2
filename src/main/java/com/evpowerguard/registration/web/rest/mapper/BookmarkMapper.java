package com.evpowerguard.registration.web.rest.mapper;

import com.evpowerguard.registration.domain.Bookmark;
import com.evpowerguard.registration.web.rest.dto.BookmarkDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Bookmark} and its DTO {@link BookmarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookmarkMapper extends EntityMapper<BookmarkDTO, Bookmark> {


    // @Mapping(source = "chargingStation.id", target = "stationId")
    // @Mapping(source = "chargingStation.stationName", target = "stationName")
    // @Mapping(source = "chargingStation.stationAddress", target = "stationAddress")
    // @Mapping(source = "chargingStation.isFreeParking", target = "isFreeParking")
    // @Mapping(source = "chargingStation.availableTime", target = "availableTime")
    // @Mapping(source = "chargingStation.adminId", target = "adminId")
    // @Mapping(source = "chargingStation.repairCompanyVo.repairCompanyName", target = "repairCompanyName")
    // @Mapping(source = "chargingStation.repairCompanyVo.repairCompanyTel", target = "repairCompanyTel")
    // BookmarkDTO toDto(Bookmark bookmark);

    // @Mapping(source = "stationId", target = "chargingStation.id")
    // @Mapping(source = "stationName", target = "chargingStation.stationName")
    // @Mapping(source = "stationAddress", target = "chargingStation.stationAddress")
    // @Mapping(source = "isFreeParking", target = "chargingStation.isFreeParking")
    // @Mapping(source = "availableTime", target = "chargingStation.availableTime")
    // @Mapping(source = "adminId", target = "chargingStation.adminId")
    // @Mapping(source = "repairCompanyName", target = "chargingStation.repairCompanyVo.repairCompanyName")
    // @Mapping(source = "repairCompanyTel", target = "chargingStation.repairCompanyVo.repairCompanyTel")
    // Bookmark toEntity(BookmarkDTO bookmarkDTO);

}
