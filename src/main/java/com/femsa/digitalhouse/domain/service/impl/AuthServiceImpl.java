package com.femsa.digitalhouse.domain.service.impl;
import com.femsa.digitalhouse.application.dto.response.UserDetailsDTO;
import com.femsa.digitalhouse.domain.model.User;
import com.femsa.digitalhouse.domain.repository.UserRepository;
import com.femsa.digitalhouse.domain.service.AuthService;
import com.femsa.digitalhouse.exceptions.InvalidPasswordException;
import com.femsa.digitalhouse.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsDTO login(String username, String password) {
        User userFound = userRepository.findByUsername(username);

        if (userFound == null) {
            throw new ResourceNotFoundException("The username does not exist");
        } else if (!userFound.getPassword().equals(password)) {
            throw new InvalidPasswordException("Password is incorrect");
        }

        return new UserDetailsDTO(userFound.getId(), userFound.getUsername(), userFound.getName(), userFound.getLastName(), userFound.getPhoneNumber());
    }
}
