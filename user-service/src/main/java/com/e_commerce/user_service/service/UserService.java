package com.e_commerce.user_service.service;

import com.e_commerce.user_service.dto.UserDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    List<UserDTO> findByIdPublic(Set<UUID> ids);

    UserDTO findByEmail(String email);

    UUID findIdByEmail(String email);
}