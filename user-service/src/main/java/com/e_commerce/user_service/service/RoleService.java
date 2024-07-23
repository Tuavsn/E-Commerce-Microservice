package com.e_commerce.user_service.service;

import com.e_commerce.user_service.dto.RoleDTO;
import com.e_commerce.user_service.entity.Role;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface RoleService extends BaseService<Role, RoleDTO, UUID> {

}
