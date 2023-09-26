package com.femsa.digitalhouse.domain.service.impl

import com.femsa.digitalhouse.application.dto.response.UserDetailsDTO
import com.femsa.digitalhouse.domain.model.User
import com.femsa.digitalhouse.domain.repository.UserRepository
import com.femsa.digitalhouse.exceptions.InvalidPasswordException
import com.femsa.digitalhouse.exceptions.ResourceNotFoundException
import spock.lang.Specification
import spock.lang.Subject

class AuthServiceImplSpec extends Specification {
    def userRepository = Mock(UserRepository)

    @Subject
    def subject = new AuthServiceImpl(userRepository)

    def "Should allow a registered user to log in correctly"() {
        given:
        String username = "admin@gmail.com"
        String password = "Test.123"
        userRepository.findByUsername(username) >> User.builder().id("1").username("admin@gmail.com").password("Test.123").build()

        when:
        def result = subject.login(username, password)

        then:
        result instanceof UserDetailsDTO
    }

    def "should fail if user enters wrong username"() {
        given:
        String username = "mirakel@hotmail.com"
        String password = "Test.1"
        userRepository.findByUsername(username) >> null

        when:
        subject.login(username, password)

        then:
        def expected = thrown(ResourceNotFoundException)
        expected.message == "The username does not exist"
    }

    def "should fail if user enters wrong password"() {
        given:
        String username = "admin@gmail.com"
        String password = "Test.1"
        userRepository.findByUsername(username) >> User.builder().username("admin@gmail.com").password("Test.123").build()

        when:
        subject.login(username, password)

        then:
        def expected = thrown(InvalidPasswordException)
        expected.message == "Password is incorrect"
    }
}
