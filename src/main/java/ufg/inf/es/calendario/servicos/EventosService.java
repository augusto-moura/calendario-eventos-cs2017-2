package ufg.inf.es.calendario.servicos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ufg.inf.es.calendario.dao.EventosDao;
import ufg.inf.es.calendario.dominio.entidades.Evento;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: 1.0
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 * Esta classe tem o propósito de adicionar eventos a estrutura
 * calendário.
 */

@Named
public class EventosService {

    private static final Logger logger = LoggerFactory.getLogger(EventosService.class);

    private final EventosDao eventosDao;

    @Inject
    public EventosService(final EventosDao eventosDao) {
        this.eventosDao = eventosDao;
    }

    private User getUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            return (User) principal;
        } else {
            throw new IllegalStateException("Não existe usuário presente no contexto atual");
        }
    }

    /**
     * Consulta todos os eventos de um usuário.
     *
     * @return lista - arryList contendo todos os eventos de um usuário cadastrado no
     * sistema.
     */
    public List<Evento> consultarTodos() {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou uma consulta de todos Eventos do sistema");

        List<Evento> lista = new ArrayList<>();

        for (Evento evento : eventosDao.findAll()) {
            lista.add(evento);
        }

        logger.info("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "concluiu uma consulta de todos Eventos do sistema");

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
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou a criação do evento:\n\n" + evento.toString());

        final Evento eventoSalvo = eventosDao.save(evento);

        logger.info("Usuário com nome `" + usuarioAtual.getUsername() + "`, " +
            "concluiu a criação do evento:\n\n" + evento.toString());

        return eventoSalvo;
    }

    /**
     * Consulta um Evento por seu ID.
     *
     * @param id Identificador do Evento a ser buscado
     * @return Evento com Identificador passado por argumento
     */
    public Evento consultarPorId(final Long id) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou uma consulta do Evento com identificador: " + id);

        if (!eventosDao.exists(id)) {
            logger.error("Evento com identificador: " + id + ", pesquisado pelo " +
                "usuário: `" + usuarioAtual.getUsername() + "` não foi encontrado");

            throw new NotFoundException("Evento com identificador `" + id + "`, não foi encontrado");
        }

        final Evento eventoEncontrado = eventosDao.findOne(id);

        logger.info("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "concluiu com sucesso uma consulta do Evento com identificador: " + id);

        return eventoEncontrado;
    }

    /**
     * Apaga um Evento por seu ID.
     *
     * @param id Identificador do Evento a ser apagado
     */
    public void apagarPorId(final Long id) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "requisitou apagar o Evento com identificador: " + id);

        if (!eventosDao.exists(id)) {
            logger.error("Evento com identificador: " + id + ", requisitado " +
                "para ser apagado pelo usuário: `" + usuarioAtual.getUsername() +
                "` não foi encontrado");

            throw new NotFoundException("Evento com identificador `" + id + "`, não foi encontrado");
        }

        logger.info("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "apagou com sucesso o Evento com identificador: " + id);

        eventosDao.delete(id);
    }

    /**
     * Apaga um Evento por seu ID.
     *
     * @param id         Identificador do Evento a ser apagado.
     * @param novoEvento Evento modificado a ser colocado no lugar do antigo.
     * @return Evento modificado pós salvamento
     */
    public Evento sobreescreverPorId(final Long id, final Evento novoEvento) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou a sobrescrita do conteúdo do evento com identficador: " + id +
            " para: " + novoEvento.toString());

        if (!eventosDao.exists(id)) {
            logger.error("Evento com identificador: " + id + ", requisitado " +
                "para ser sobreescrito pelo usuário: `" + usuarioAtual.getUsername() +
                "` não foi encontrado");
            throw new NotFoundException("Evento com identificador `" + id + "`, não foi encontrado");
        }

        novoEvento.setId(id);

        final Evento eventoAtual = eventosDao.findOne(id);
        final Evento eventoSobreescrito = eventosDao.save(novoEvento);

        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "concluiu com sucesso a sobrescrita do conteúdo do evento com " +
            "identficador: " + id + " de: " + eventoAtual.toString() + ", para: " + eventoSobreescrito.toString());

        return eventoSobreescrito;
    }

}
