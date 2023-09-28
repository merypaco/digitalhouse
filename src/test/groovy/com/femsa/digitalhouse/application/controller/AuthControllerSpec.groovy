package com.femsa.digitalhouse.application.controller

import com.femsa.digitalhouse.application.dto.request.LoginDTO
import com.femsa.digitalhouse.application.dto.response.UserDetailsDTO
import com.femsa.digitalhouse.domain.service.AuthService
import spock.lang.Specification
import spock.lang.Subject

class AuthControllerSpec extends Specification {
    def authService = Mock(AuthService)

    @Subject
    def subject = new AuthController(authService)

    def "create should delegate the execution to the service layer"() {
        given:
        def response = new UserDetailsDTO("1", "admin@hotmail.com", "Joe", "Doe", "5635353535")
        def request = LoginDTO.builder().username("admin@gmail.com").password("Test").build()

        when:
        def result = subject.login(request)

        then:
        result == response
        1 * authService.login(request.username, request.password) >> response
    }
}
