package com.e_commerce.user_service.service;

import com.e_commerce.user_service.dto.UserDTO;
import com.e_commerce.user_service.entity.User;
import com.microservice.shared_library.service.BaseService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService extends BaseService<User, UserDTO, UUID> {
    List<UserDTO> findByIdPublic(Set<UUID> ids);

    UserDTO findByEmail(String email);

    UUID findIdByEmail(String email);
}