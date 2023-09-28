import com.femsa.digitalhouse.DigitalhouseApplication
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import spock.lang.AutoCleanup
import spock.lang.Specification

class DigitalHouseApplicationSpec extends Specification {
    @AutoCleanup
    ConfigurableApplicationContext context

    def "The application should start without errors"() {
        given:
        String[] args = []

        when:
        context = SpringApplication.run(DigitalhouseApplication, args)

        then:
        context != null
        context.isActive()
    }
}
