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

@Named
@Path("/eventos")
@Produces(MediaType.APPLICATION_JSON)
public class EventosResource {

    @Inject
    private EventosService eventosService;

    @GET
    public List<Evento> consultaTodos() {
        return eventosService.consultarTodos();
    }

    @POST
    public Evento criarNovo(final Evento evento) {
        return eventosService.salvar(evento);
    }

}
