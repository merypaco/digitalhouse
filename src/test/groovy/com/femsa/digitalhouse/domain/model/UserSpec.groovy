package com.femsa.digitalhouse.domain.model

import spock.lang.Specification

class UserSpec extends Specification {
    def "should create a user with valid data"() {
        when:
        def user = User.builder().id("2").username("test@gmail.com").password("Abc.1").build()

        then:
        user.id == "2"
        user.username == "test@gmail.com"
    }
}
