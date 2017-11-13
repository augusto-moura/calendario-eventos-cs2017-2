package ufg.inf.es.calendario.recursos;


import ufg.inf.es.calendario.dao.EventosDao;
import ufg.inf.es.calendario.dominio.entidades.Evento;
import ufg.inf.es.calendario.servicos.EventosService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List; 
/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: <1.0>
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 *
 * Esta classe tem o propósito de ser a interface de comunicação 
 * do o servidor e a aplicação calendário.
 */

@Named
@Path("/eventos")
@Produces(MediaType.APPLICATION_JSON)
public class EventosResource {

    @Inject
    private EventosService eventosService;

    /**
    *  Consulta todos os eventos de um usuário.
    *
    * @param null - nenhum paramentro
    * @return lista - arryList contendo todos os eventos de um usuário cadastrado no
    * sistema.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    @GET
    public List<Evento> consultaTodos() { 
        return eventosService.consultarTodos();
    } 
    
    /**
    * Adiciona um novo evento ao calendário de um usuário
    *
    * @param Evento - objeto com os atributos de evento.
    * @return objeto do tipo evento - objeto contendo todos os eventos de cadastrados. 
    * no sistema.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    @POST
    public Evento criarNovo(final Evento evento) {
        return eventosService.salvar(evento);
    }

}
