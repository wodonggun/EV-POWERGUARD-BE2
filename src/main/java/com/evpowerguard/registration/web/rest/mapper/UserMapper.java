package com.evpowerguard.registration.web.rest.mapper;

import com.evpowerguard.registration.domain.User;
import com.evpowerguard.registration.web.rest.dto.UserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link User} and its DTO {@link UserDTO}.
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

    @Mapping(source = "id", target = "id")
    UserDTO toDto(User user);

    @Mapping(source = "id", target = "id")
    User toEntity(UserDTO userDTO);

    
    default User fromId(String id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

}