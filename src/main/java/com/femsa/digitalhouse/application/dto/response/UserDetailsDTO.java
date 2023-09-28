package com.femsa.digitalhouse.application.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {
    private String id;

    private String username;

    private String name;

    private String lasName;

    private String phoneNumber;
}
