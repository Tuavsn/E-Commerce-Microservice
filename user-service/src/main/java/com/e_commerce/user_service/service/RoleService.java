package com.e_commerce.user_service.service;

import com.e_commerce.user_service.dto.RoleDTO;

public interface RoleService {
    RoleDTO save(RoleDTO roleDTO);

    RoleDTO update(RoleDTO roleDTO);
}
