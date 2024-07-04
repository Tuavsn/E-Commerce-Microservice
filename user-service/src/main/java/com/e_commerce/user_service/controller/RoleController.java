package com.e_commerce.user_service.controller;

import com.e_commerce.user_service.dto.RoleDTO;
import com.e_commerce.user_service.entity.Role;
import com.e_commerce.user_service.service.impl.RoleServiceImpl;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleDTO, UUID> {

    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        super(roleService);
        this.roleService = roleService;
    }
}
