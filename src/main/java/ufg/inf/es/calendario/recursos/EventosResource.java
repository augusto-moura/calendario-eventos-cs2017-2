package ufg.inf.es.calendario.recursos;


import ufg.inf.es.calendario.dominio.entidades.Evento;
import ufg.inf.es.calendario.servicos.EventosService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: 1.0
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
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
     * Consulta todos os eventos de um usuário.
     *
     * @return lista - arryList contendo todos os eventos de um usuário cadastrado no
     * sistema.
     */
    @GET
    public List<Evento> consultaTodos() {
        return eventosService.consultarTodos();
    }

    /**
     * Adiciona um novo evento ao calendário de um usuário
     *
     * @param evento objeto com os atributos de evento.
     * @return objeto do tipo evento - objeto contendo todos os eventos de cadastrados.
     * no sistema.
     */
    @POST
    public Evento criarNovo(final Evento evento) {
        return eventosService.salvar(evento);
    }

    /**
     * Consulta um Evento por seu ID.
     *
     * @param id Identificador do Evento a ser buscado
     * @return Evento com Identificador passado por argumento
     */
    @GET
    @Path("/{id}")
    public Evento consultarPorId(@PathParam("id") final Long id) {
        return eventosService.consultarPorId(id);
    }

    /**
     * Apaga um Evento por seu ID.
     *
     * @param id Identificador do Evento a ser apagado.
     * @return Resposta com OK caso o evento tenha sido apagado ou erro a ser tratado.
     */
    @DELETE
    @Path("/{id}")
    public Response apagarPorId(@PathParam("id") final Long id) {
        eventosService.apagarPorId(id);
        return Response.ok().build();
    }

    /**
     * Apaga um Evento por seu ID.
     *
     * @param id         Identificador do Evento a ser apagado.
     * @param novoEvento Evento modificado a ser colocado no lugar do antigo.
     * @return Evento modificado pós salvamento
     */
    @PUT
    @Path("/{id}")
    public Evento sobreescreverPorId(@PathParam("id") final Long id, final Evento novoEvento) {
        return eventosService.sobreescreverPorId(id, novoEvento);
    }


}
