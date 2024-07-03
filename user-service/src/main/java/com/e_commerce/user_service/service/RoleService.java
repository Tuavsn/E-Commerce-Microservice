package com.e_commerce.user_service.service;

import com.e_commerce.user_service.dto.RoleDTO;
import com.e_commerce.user_service.entity.Role;
import com.e_commerce.user_service.mapper.RoleMapper;
import com.e_commerce.user_service.repository.RoleRepository;
import com.microservice.shared_library.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService extends BaseService<Role, RoleDTO, UUID> {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        super(roleRepository, roleMapper);
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }
}
