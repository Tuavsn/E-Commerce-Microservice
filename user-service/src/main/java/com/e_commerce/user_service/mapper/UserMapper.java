package com.e_commerce.user_service.mapper;

import com.e_commerce.user_service.dto.UserDTO;
import com.e_commerce.user_service.entity.User;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO, UUID> {
    @Named("userToUserDTO")
    @Override
    UserDTO toDTO (User user);

    @Named("userDTOToUser")
    @Override
    User toModel (UserDTO userDTO);

    @Named("userListToUserDTOList")
    @Override
    List<UserDTO> toDTO (List<User> userList);

    @Named("userDTOListToUserList")
    @Override
    List<User> toModel (List<UserDTO> userDTOList);
}
