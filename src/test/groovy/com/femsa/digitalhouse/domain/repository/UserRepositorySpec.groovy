package com.femsa.digitalhouse.domain.repository

import com.femsa.digitalhouse.domain.model.User
import spock.lang.Specification

class UserRepositorySpec extends Specification {
    def userRepository = new UserRepository()

    def "should return the list of users"() {
        when:
        List<User> users = userRepository.findAll()

        then:
        users.size() == 1
        users[0].username == "admin@gmail.com"
        users[0].password == "Test.123"
        users[0].name == "Joe"
        users[0].lastName == "Doe"
        users[0].phoneNumber == "5635353535"
    }

    def "should search for a user by existing username and return the user"() {
        given:
        String username = "admin@gmail.com"

        when:
        def result = userRepository.findByUsername(username)

        then:
        result.username == username
    }

    def "should search for a user by non-existing username and return null"() {
        given:
        String username = "mirakel@gmail.com"

        when:
        def result = userRepository.findByUsername(username)

        then:
        result == null
    }
}
