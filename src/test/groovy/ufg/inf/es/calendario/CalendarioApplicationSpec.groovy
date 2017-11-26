package ufg.inf.es.calendario.servicos;

import ufg.inf.es.calendario.dominio.entidades;
import spock.lang.Specification

class CalendarioApplicationSpec extends Specification {

    def "Canary test"() {
        expect:
        assert true
    }

    def "construtor da classe"(){
        def evento = new 
        def eventosDao = []
        def calendario = new EventosService(eventosDao)

        expect:
        calendario.EventosDao == eventosDao
        
    }

    def "Listar eventos"(){
        def evento = new Evento;
        evento.setTitulo("titulo")
        evento.setId(1)
        evento.setDescricao("Descrição")
        evento.setDate("26/11/2017")
        def eventosDao = [(evento,1)]
        def calendario = new EventosService(eventosDao)
        def resultado  = calendario.consultarTodos()

        expect:
        resultado == eventosDao

    }

    def "Salvar evento"(){
        def evento = new Evento;
        evento.setTitulo("titulo")
        evento.setId(1)
        evento.setDescricao("Descrição")
        evento.setDate("26/11/2017")
        def eventosDao = []
        
        def calendario = new EventosService(eventosDao)
        calendario.Salvar(evento)
        def resultado  = calendario.consultarTodos()
        
        expect:
        resultado[0] == (evento,1)
    }

    def "consultar por Id"(){
        def evento = new Evento;
        evento.setTitulo("titulo")
        evento.setId(1)
        evento.setDescricao("Descrição")
        evento.setDate("26/11/2017")
        def eventosDao = []
        
        def calendario = new EventosService(eventosDao)
        calendario.Salvar(evento)
        def resultado = calendario.consultarPorId(1)

        expect:
        resltado == evento
    }

    def "Apagar por id"(){
        def evento = new Evento;
        evento.setTitulo("titulo")
        evento.setId(1)
        evento.setDescricao("Descrição")
        evento.setDate("26/11/2017")
        def eventosDao = []
        
        def calendario = new EventosService(eventosDao)
        calendario.Salvar(evento)
        calendario.apagarPorId(1)

        expect:
        calendario.EventosDao == eventosDao
    }

    def "sobreescrever por id"(){
        def evento = new Evento;
        evento.setTitulo("titulo")
        evento.setId(1)
        evento.setDescricao("Descrição")
        evento.setDate("26/11/2017")

        def evento2 = new Evento;
        evento2.setTitulo("titulo2")
        evento2.setId(2)
        evento2.setDescricao("Descrição2")
        evento2.setDate("26/11/2017")


        def eventosDao = []
        
        def calendario = new EventosService(eventosDao)
        calendario.Salvar(evento)
        def retorno = sobreescreverPorId(1, evento2)


        expect:
        retorno == evento2

    }



}