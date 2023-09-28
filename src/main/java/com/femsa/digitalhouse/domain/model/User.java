package com.femsa.digitalhouse.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String id;
    private String username;
    private String password;
}
