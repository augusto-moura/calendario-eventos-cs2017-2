package ufg.inf.es.calendario.servicos;

import ufg.inf.es.calendario.dao.EventosDao;
import ufg.inf.es.calendario.dominio.entidades.Evento;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: <1.0>
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 * Esta classe tem o propósito de adicionar eventos a estrutura
 * calendário.
 */

@Named
public class EventosService {

    @Inject
    private EventosDao eventosDao;

    /**
     * Consulta todos os eventos de um usuário.
     *
     * @return lista - arryList contendo todos os eventos de um usuário cadastrado no
     * sistema.
     */
    public List<Evento> consultarTodos() {
        List<Evento> lista = new ArrayList<>();

        for (Evento evento : eventosDao.findAll()) {
            lista.add(evento);
        }

        return lista;
    }

    /**
     * Gera relatório das notas do aluno.
     *
     * @param evento objeto com as suas eventos.
     * @return objeto do tipo eventoDao - objeto contendo todos os eventos de cadastrados.
     * no sistema.
     */
    public Evento salvar(Evento evento) {
        return eventosDao.save(evento);
    }

    /**
     * Consulta um Evento por seu ID.
     *
     * @param id Identificador do Evento a ser buscado
     * @return Evento com Identificador passado por argumento
     */
    public Evento consultarPorId(final Long id) {
        if (!eventosDao.exists(id)) {
            throw new NotFoundException("Evento com identificador `" + id + "`, não foi encontrado");
        }

        return eventosDao.findOne(id);
    }

    /**
     * Apaga um Evento por seu ID.
     *
     * @param id Identificador do Evento a ser apagado
     */
    public void apagarPorId(final Long id) {
        if (!eventosDao.exists(id)) {
            throw new NotFoundException("Evento com identificador `" + id + "`, não foi encontrado");
        }

        eventosDao.delete(id);
    }

}
