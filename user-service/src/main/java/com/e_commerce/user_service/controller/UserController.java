package com.e_commerce.user_service.controller;

import com.e_commerce.user_service.dto.UserDTO;
import com.e_commerce.user_service.entity.User;
import com.e_commerce.user_service.service.impl.UserServiceImpl;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, UserDTO, UUID> {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/{id}/public")
    public ResponseEntity<List<UserDTO>> getPublic(@PathVariable Set<UUID> id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/email/{email}/id")
    public ResponseEntity<UUID> getUserIdByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.findIdByEmail(email), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return new ResponseEntity<>(userService.update(userDTO), HttpStatus.OK);
    }
}
