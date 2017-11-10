package ufg.inf.es.calendario.dao;

import org.springframework.data.repository.CrudRepository;
import ufg.inf.es.calendario.dominio.entidades.Evento;

public interface EventosDao extends CrudRepository<Evento, Long> {
}
