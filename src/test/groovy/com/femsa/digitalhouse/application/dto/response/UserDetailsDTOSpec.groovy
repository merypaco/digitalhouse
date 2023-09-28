package com.femsa.digitalhouse.application.dto.response

import spock.lang.Specification

class UserDetailsDTOSpec extends Specification {
    def "Should be able to set and get the DTO values correctly"() {
        given:
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO()

        when:
        userDetailsDTO.setId("1")
        userDetailsDTO.setName("John")
        userDetailsDTO.setLasName("Doe")
        userDetailsDTO.setUsername("john@example.com")
        userDetailsDTO.setPhoneNumber("555556565")

        then:
        userDetailsDTO.getId() == "1"
        userDetailsDTO.getName() == "John"
        userDetailsDTO.getLasName() == "Doe"
        userDetailsDTO.getUsername() == "john@example.com"
        userDetailsDTO.getPhoneNumber() == "555556565"
    }
}
