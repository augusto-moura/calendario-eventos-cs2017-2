package ufg.inf.es.calendario.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import ufg.inf.es.calendario.dao.EventosDao;
import ufg.inf.es.calendario.dominio.entidades.Evento;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: <1.0>
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 *
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
    * @param null - nenhum paramentro
    * @return lista - arryList contendo todos os eventos de um usuário cadastrado no
    * sistema.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
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
    * @param Evento - objeto com as suas eventos.
    * @return objeto do tipo eventoDao - objeto contendo todos os eventos de cadastrados. 
    * no sistema.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Evento salvar(Evento evento) {
        return eventosDao.save(evento);
    }

}
