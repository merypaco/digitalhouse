package com.femsa.digitalhouse.domain.repository;

import com.femsa.digitalhouse.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users;

    UserRepository() {
        users = new ArrayList<>();
        users.add(User.builder().id("1").username("admin@gmail.com").password("Test.123").name("Joe").lastName("Doe").phoneNumber("5635353535").build());
    }
    public List<User> findAll() {
        return users;
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}

