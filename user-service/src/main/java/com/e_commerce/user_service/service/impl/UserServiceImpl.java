package com.e_commerce.user_service.service.impl;

import com.e_commerce.user_service.dto.UserDTO;
import com.e_commerce.user_service.entity.User;
import com.e_commerce.user_service.mapper.UserMapper;
import com.e_commerce.user_service.repository.UserRepository;
import com.e_commerce.user_service.service.UserService;
import com.microservice.shared_library.service.BaseService;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDTO, UUID> implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        return super.save(userDTO);
    }

    @Override
    public List<UserDTO> findByIdPublic(Set<UUID> ids) {
        List<User> users = (List<User>)userRepository.findAllById(ids);
        if(users.isEmpty()) {
            throw new NotFoundException("User id not found");
        }
        return userMapper.toDTO(users);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userMapper.toDTO(
                userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"))
        );
    }

    @Override
    public UUID findIdByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found")).getId();
    }
}
