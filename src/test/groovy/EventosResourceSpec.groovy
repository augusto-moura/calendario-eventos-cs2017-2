import spock.lang.Specification
import ufg.inf.es.calendario.recursos.EventosResource

class EventosResourceSpec extends Specification {

    EventosResource resource = new EventosResource()

    def "canary test"() {
        when:
        def resultado = resource.consultarTodos()

        then:
        true == true
    }

}
