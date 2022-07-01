package com.evpowerguard.registration.repository;


import com.evpowerguard.registration.domain.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, String>{    // Repository Pattern Interface




    String findByIdAndPassword(String id, String password);
    
    //Page<Charger> findByChargingStation(ChargingStation chargingStation, Pageable pageable);

    // Long countByChargingStationIdAndChargerTypeAndOperationStatus(Long chargingStationId, ChargerType chargerType, OperationStatus operationStatus);

    // Long countByChargingStationIdAndOperationStatus(Long chargingStationId, OperationStatus operationStatus);

    
}
