package com.evpowerguard.registration.web.rest;

import com.evpowerguard.registration.service.UserService;
import com.evpowerguard.registration.web.rest.assembler.UserResourceAssembler;
import com.evpowerguard.registration.web.rest.dto.UserDTO;
import com.evpowerguard.registration.web.rest.mapper.UserMapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;
/**
 * REST controller for managing {@link com.evpowerguard.registration.domain.User}.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Value("registration")
    private String applicationName;

    private final UserService userService;

    private final UserMapper userMapper;

    private final UserResourceAssembler userResourceAssembler;

    public UserResource(UserService userService, UserMapper userMapper, UserResourceAssembler userResourceAssembler) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userResourceAssembler = userResourceAssembler;
    }

    /**
     * {@code POST  /users} : Create a new user.
     *
     * @param userDTO the userDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userDTO, or with status {@code 400 (Bad Request)} if the user has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/registration/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
        log.debug("REST request to save User : {}", userDTO);

        UserDTO result = userMapper.toDto(userService.save(userMapper.toEntity(userDTO)));
        
        // Set Hateoas 
        result = userResourceAssembler.toModel(result);

        return ResponseEntity
            .created(new URI("/api/registration/users/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /userrs/:id} : Updates an existing user.
     *
     * @param id the id of the userDTO to save.
     * @param userDTO the userDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userDTO,
     * or with status {@code 400 (Bad Request)} if the userDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping("/registration/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable String id) throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
        log.debug("REST request to update user : {}, {}", id, userDTO);
        
        UserDTO result = userMapper.toDto(userService.update(userMapper.toEntity(userDTO)));

        result = userResourceAssembler.toModel(result);

        return ResponseEntity
            .ok()
            .body(result);
    }

    @PutMapping("/registration")
    public ResponseEntity<UserDTO> updateUser(
            @RequestBody UserDTO userDTO) throws URISyntaxException, JsonProcessingException, InterruptedException, ExecutionException {
        log.debug("REST request to update driverLog : {}", userDTO);

        UserDTO result = userMapper.toDto(userService.update(userMapper.toEntity(userDTO)));

        // Set Hateoas
        result = userResourceAssembler.toModel(result);

        return ResponseEntity
                .ok()
                .body(result);
    }

    /**
     * {@code GET  /users} : get all the users.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of users in body.
     */
    @GetMapping("/registration/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(Pageable pageable) {
        log.debug("REST request to get a page of Chargers");
        Page<UserDTO> page = userService.findAll(pageable).map(userMapper::toDto);
        return ResponseEntity.ok().body(page.getContent());
    }

     /**
     * {@code GET  /users/:id} : get the "id" user.
     *
     * @param id the id of the userDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/registration/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id, Pageable pageable) throws InterruptedException, ExecutionException, JsonProcessingException, URISyntaxException {
        log.debug("REST request to get Charger : {}", id);
        UserDTO userDTO = userMapper.toDto(userService.findOne(id).get());
        return ResponseEntity.ok().body(userDTO);

    }



    /**
     * {@code DELETE  /users/:id} : delete the "id" charger.
     *
     * @param id the id of the userDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/registration/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        log.debug("REST request to delete Charger : {}", id);
        userService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }

    /**
     * {@code POST  /users/status/broken/:id} : change status of the "id" charger.
     * 
     * @param id
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws JsonProcessingException
     */
    @PostMapping("/registrations/users/status/broken/{id}")
    public ResponseEntity<Void> updateStatusBroken(@PathVariable Long id) throws InterruptedException, ExecutionException, JsonProcessingException {
        log.debug("REST request to updateStatusBroken Charger : {}", id);
        userService.updateChargerStatusToBroken(id);
        return ResponseEntity
            .noContent()
            .build();
    }
    
}
