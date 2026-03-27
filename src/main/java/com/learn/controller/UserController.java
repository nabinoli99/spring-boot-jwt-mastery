package com.learn.controller;

import com.learn.dto.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity <UserResponseDTO> getMe(
            @AuthenticationPrincipal User currentuser) {

        UserResponseDTO dto = new UserResponseDTO(
                currentuser.getId(),
                currentuser.getFirstName() + " " + currentuser.getLastName(),
                currentuser.getEmail(),
                currentuser.getRole().name()
                );
        return ResponseEntity.ok(dto);
    }
}
