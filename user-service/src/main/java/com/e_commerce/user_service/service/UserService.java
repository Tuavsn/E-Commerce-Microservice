package com.e_commerce.user_service.service;

import com.e_commerce.user_service.dto.UserDTO;
import com.e_commerce.user_service.entity.User;
import com.e_commerce.user_service.mapper.UserMapper;
import com.e_commerce.user_service.repository.UserRepository;
import com.microservice.shared_library.service.BaseService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService extends BaseService<User, UserDTO, UUID> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
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

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        if(userDTO.getFullname() != null) {
            existingUser.setFullname(userDTO.getFullname());
        }
        if(userDTO.getPhone() != null) {
            existingUser.setPhone(userDTO.getPhone());
        }
        if(userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail());
        }

        return userMapper.toDTO(userRepository.save(existingUser));
    }

    public List<UserDTO> findByIdPublic(Set<UUID> id) {
        List<User> users = (List<User>)userRepository.findAllById(id);
        if(users.isEmpty()) {
            throw new NotFoundException("User id not found");
        }
        return userMapper.toDTO(users);
    }

    public UserDTO findByEmail(String email) {
        return userMapper.toDTO(
                userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"))
        );
    }

    public UUID findIdByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found")).getId();
    }
}