package com.evpowerguard.registration.service;

import java.util.Optional;

import com.evpowerguard.registration.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;

/**
 * Service Interface for managing {@link com.evpowerguard.registration.domain.User}.
 */
public interface UserService {
    /**
     * Save a User.
     *
     * @param user the entity to save.
     * @return the persisted entity.
     */
    User save(User user);

    /**
     * Updates a User.
     *
     * @param User the entity to update.
     * @return the persisted entity.
     */
    User update(User user);


     
    /**
     * Delete the "id" user.
     *
     * @param id the id of the entity.
     */
    void delete(String id);



    /**
     * Get all the Users.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<User> findAll(Pageable pageable);


    
    /**
     * Get the users by userType.
     * @param userType
     * @param pageable
     * @return
     */
    Page<User> findByUserType(String userType, Pageable pageable);


    /**
     * Get the "id" user.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<User> findOne(String id);


    

    /**
     * update ChargerStatus To Broken (Kafka)
     * 
     * @param id
     */
    void updateChargerStatusToBroken(Long id) throws InterruptedException, ExecutionException, JsonProcessingException;
}
