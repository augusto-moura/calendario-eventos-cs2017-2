package ufg.inf.es.calendario.servicos

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import spock.lang.Specification
import ufg.inf.es.calendario.dao.EventosDao
import ufg.inf.es.calendario.dominio.entidades.Evento

class EventosServiceSpec extends Specification {

    User userDummy = new User('nome', 'senha', [])

    EventosDao mockedDao = Mock()
    Authentication authMock = Mock()
    SecurityContext securityContextMock = Mock()

    EventosService service = new EventosService(mockedDao)

    def setup() {
        authMock.getPrincipal() >> userDummy
        securityContextMock.getAuthentication() >> authMock

        SecurityContextHolder.setContext(securityContextMock)
    }

    def "Listar eventos"() {
        def evento = new Evento()
        evento.titulo = "titulo"
        evento.id = 1
        evento.descricao = "Descrição"
        evento.data = Date.parse("dd/MM/yyyy", "26/11/2017")

        // Mockando o método `.findAll` para retornar uma lista do evento escrito acima
        mockedDao.findAll() >> [evento]

        expect:
        service.consultarTodos() == [evento]
    }

    def "Salvar evento"() {
        def evento = new Evento()
        evento.titulo = "titulo"
        evento.id = 1
        evento.descricao = "Descrição"
        evento.data = Date.parse("dd/MM/yyyy", "26/11/2017")

        when:
        service.salvar(evento)

        then:
        // Espera ter chamado o método salvar do DAO 1 vez com o evento criado acima como argumento
        // Ao mesmo tempo mocka o dao.save() para retornar o evento
        1 * mockedDao.save(evento) >> evento
    }

    def "consultar por Id"() {
        def eventoId = 1

        def evento = new Evento()
        evento.titulo = "titulo"
        evento.id = eventoId
        evento.descricao = "Descrição"
        evento.data = Date.parse("dd/MM/yyyy", "26/11/2017")

        mockedDao.exists(_) >> true
        mockedDao.findOne(eventoId) >> evento

        expect:
        service.consultarPorId(eventoId) == evento
    }

    def "Apagar por id"() {
        def eventoId = 1

        def evento = new Evento()
        evento.titulo = "titulo"
        evento.id = eventoId
        evento.descricao = "Descrição"
        evento.data = Date.parse("dd/MM/yyyy", "26/11/2017")

        mockedDao.exists(_) >> true

        when:
        service.apagarPorId(eventoId)

        then:
        1 * mockedDao.delete(eventoId)
    }

    def "sobreescrever por id"() {
        def eventoId = 1

        def eventoSalvo = new Evento()
        eventoSalvo.titulo = "titulo"
        eventoSalvo.descricao = "Descrição"
        eventoSalvo.data = Date.parse("dd/MM/yyyy", "27/11/2017")

        def eventoASerSobreescrito = new Evento()
        eventoASerSobreescrito.titulo = "titulo123"
        eventoASerSobreescrito.descricao = "Descrição514324"
        eventoASerSobreescrito.data = Date.parse("dd/MM/yyyy", "31/11/2017")

        mockedDao.exists(_) >> true
        mockedDao.findOne(eventoId) >> eventoSalvo

        when:
        def resultado = service.sobreescreverPorId(eventoId, eventoASerSobreescrito)

        then:
        1 * mockedDao.save(eventoASerSobreescrito) >> eventoASerSobreescrito

        resultado == eventoASerSobreescrito
    }
}
