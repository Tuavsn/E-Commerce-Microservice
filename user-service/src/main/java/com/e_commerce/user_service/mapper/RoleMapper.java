package com.e_commerce.user_service.mapper;

import com.e_commerce.user_service.dto.RoleDTO;
import com.e_commerce.user_service.entity.Role;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {

}
