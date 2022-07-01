package com.evpowerguard.registration.service.impl;



import com.evpowerguard.registration.adaptor.ChargingStationProducer;
import com.evpowerguard.registration.adaptor.RegistrationProducer;
import com.evpowerguard.registration.domain.User;
import com.evpowerguard.registration.domain.enumeration.LoginType;
import com.evpowerguard.registration.repository.UserRepository;
import com.evpowerguard.registration.service.UserService;


// import com.evpowerguard.registration.domain.event.BreakdownReportSubmitted;
 


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;

/**
 * Service Implementation for managing {@link User}.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserRepository userRepository2;

    private final RegistrationProducer registrationProducer;

    //private final ChargingStationProducer chargingStationProducer;

    public UserServiceImpl(UserRepository userRepository, UserRepository userRepository2
                              ,RegistrationProducer registrationProducer) {
        this.userRepository = userRepository;
        this.userRepository2 = userRepository2;
        this.registrationProducer = registrationProducer;
    }

    @Override
    public User save(User user) {
        log.debug("Request to save User : {}", user);
        
        if(user.getLoginType() == null)
        {
            user.setLoginType(LoginType.DEFAULT);
        }

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.debug("Request to update User : {}", user);

        //카프카 발행 필요.


        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findByUserType(String userType, Pageable pageable) {
        // log.debug("Request to get all Users");
        // User chargingStation = chargingStationRepository.findById(stationId).get();
        //return userRepository.findByChargingStation(chargingStation, pageable);
        return null;
    }



    @Override
    @Transactional(readOnly = true)
    public Optional<User> findOne(String id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findById(id);
    }

  
    @Override
    @Transactional(readOnly = true)
    public void updateChargerStatusToBroken(Long id) throws InterruptedException, ExecutionException, JsonProcessingException {

         log.debug("Request to save User : {}", id);
        // User user = userRepository.findById(id).get();
        // user.setOperationStatus(OperationStatus.BROKEN);
        // userRepository.save(user);

        // UserBroken userBroken = new UserBroken();        
        // userBroken.setId(user.getId());
        // userBroken.setUserType(user.getUserType());
        // userBroken.setOperationStatus(user.getOperationStatus());
        // userBroken.setUserName(user.getUserName());
        // userBroken.setSerialNumber(user.getSerialNumber());
        // userBroken.setModelNo(user.getModelNo());
        // userBroken.setConnectorType(user.getConnectorType());
        // userBroken.setInputVoltage(user.getInputVoltage());
        // userBroken.setOutputVoltage(user.getOutputVoltage());
        // userBroken.setRatedCapacity(user.getRatedCapacity());
        // userBroken.setChargingTime(user.getChargingTime());
        // userBroken.setChargingStationId(user.getChargingStation().getId());

        // chargingStationProducer.updateUserStatusToBroken(userBroken);

    }

}
