package com.femsa.digitalhouse.domain.model

import spock.lang.Specification

class UserSpec extends Specification {
    def "should create a user with valid data"() {
        when:
        def user = User.builder().id("2").username("test@gmail.com")
                .password("Abc.1").name("test").lastName("testing").phoneNumber("5635353535").build()

        then:
        user.id == "2"
        user.username == "test@gmail.com"
        user.name == "test"
        user.lastName == "testing"
        user.phoneNumber == "5635353535"
    }
}
