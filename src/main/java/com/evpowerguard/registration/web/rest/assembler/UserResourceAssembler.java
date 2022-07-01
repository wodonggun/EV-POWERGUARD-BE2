package com.evpowerguard.registration.web.rest.assembler;

import java.util.concurrent.ExecutionException;
import com.evpowerguard.registration.web.rest.UserResource;
import com.evpowerguard.registration.web.rest.dto.UserDTO;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.URISyntaxException;
import org.springframework.stereotype.Component;

@Component
public class UserResourceAssembler  {
    public UserResourceAssembler() {
        
    } 

    public UserDTO toModel(UserDTO model) throws  URISyntaxException, JsonProcessingException, InterruptedException, ExecutionException {
       
        //list link 
        model.add(linkTo(methodOn(UserResource.class).getAllUsers(null)).withRel("list"));

        //insert link
        model.add(linkTo(methodOn(UserResource.class).createUser(null)).withRel("insert"));

        //update link
        model.add(linkTo(methodOn(UserResource.class).updateUser(null)).withRel("update"));

        //delete link
        model.add(linkTo(methodOn(UserResource.class).deleteUser(model.getId())).withRel("delete"));
        
        return model;
    }
}