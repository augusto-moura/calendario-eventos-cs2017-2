package ufg.inf.es.calendario.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import ufg.inf.es.calendario.dao.EventosDao;
import ufg.inf.es.calendario.dominio.entidades.Evento;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class EventosService {

    @Inject
    private EventosDao eventosDao;

    public List<Evento> consultarTodos() {
        List<Evento> lista = new ArrayList<>();

        for (Evento evento : eventosDao.findAll()) {
            lista.add(evento);
        }

        return lista;
    }

    public Evento salvar(Evento evento) {
        return eventosDao.save(evento);
    }

}
