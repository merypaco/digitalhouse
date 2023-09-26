package com.femsa.digitalhouse.application.controller;

import com.femsa.digitalhouse.application.dto.request.LoginDTO;
import com.femsa.digitalhouse.application.dto.response.UserDetailsDTO;
import com.femsa.digitalhouse.domain.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
@Tag(name = "Auth")
public class AuthController {
    private final AuthService loginService;

    @Operation(summary = "User login")
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetailsDTO login(@RequestBody @Valid LoginDTO loginDTO) {
        return loginService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
