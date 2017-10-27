package ufg.inf.es.calendario.recursos;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;


@Provider
@Component
@Path("/eventos")
public class EventosResource {

    @GET
    public String[] consultarTodos() {
        return new String[] {"foo", "bar"};
    }

}
