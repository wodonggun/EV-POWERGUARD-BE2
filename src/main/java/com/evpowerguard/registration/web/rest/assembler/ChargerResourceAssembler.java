package com.evpowerguard.registration.web.rest.assembler;


import com.fasterxml.jackson.core.JsonProcessingException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

@Component
public class ChargerResourceAssembler  {
    public ChargerResourceAssembler() {
        
    } 

    // public ChargerDTO toModel(ChargerDTO model) throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
       
    //     //list link 
    //     model.add(linkTo(methodOn(ChargerResource.class).getAllChargers(null)).withRel("list"));

    //     //insert link
    //     model.add(linkTo(methodOn(ChargerResource.class).createCharger(null)).withRel("insert"));

    //     //update link
    //     model.add(linkTo(methodOn(ChargerResource.class).updateCharger(null)).withRel("update"));

    //     //delete link
    //     model.add(linkTo(methodOn(ChargerResource.class).deleteCharger(model.getId())).withRel("delete"));
        
    //     return model;
    // }
}