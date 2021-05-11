package com.polozov.javaspringbootlessonfour.mappers;

import com.polozov.javaspringbootlessonfour.dto.UserDTO;
import com.polozov.javaspringbootlessonfour.entities.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ProductMapper.class})
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "productDTOS", target = "products")
    User toUser(UserDTO userDTO);
    List<User> toUserList(List<UserDTO> userDTOS);

    @InheritConfiguration
    UserDTO fromUser(User user);
    List<UserDTO> fromUserList(List<User> users);

}
