package com.e_commerce.user_service.controller;

import com.e_commerce.user_service.dto.RoleDTO;
import com.e_commerce.user_service.entity.Role;
import com.e_commerce.user_service.service.RoleService;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleDTO, UUID> {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        super(roleService);
        this.roleService = roleService;
    }
}
