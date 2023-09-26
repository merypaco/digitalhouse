package com.femsa.digitalhouse.domain.service;

import com.femsa.digitalhouse.application.dto.response.UserDetailsDTO;

public interface AuthService {
    UserDetailsDTO login(String username, String password);
}
