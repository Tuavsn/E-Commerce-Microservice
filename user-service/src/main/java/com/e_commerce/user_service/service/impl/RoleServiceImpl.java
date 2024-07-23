package com.e_commerce.user_service.service.impl;

import com.e_commerce.user_service.dto.RoleDTO;
import com.e_commerce.user_service.entity.Role;
import com.e_commerce.user_service.mapper.RoleMapper;
import com.e_commerce.user_service.repository.RoleRepository;
import com.e_commerce.user_service.service.RoleService;
import com.microservice.shared_library.service.BaseService;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleDTO, UUID> implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        super(roleRepository, roleMapper);
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional
    public RoleDTO save(RoleDTO RoleDTO) {
        return super.save(RoleDTO);
    }
}