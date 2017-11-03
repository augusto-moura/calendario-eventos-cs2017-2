package ufg.inf.es.calendario.recursos;

import org.springframework.boot.info.BuildProperties;
import ufg.inf.es.calendario.dominio.ApplicationInfo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("/healthcheck")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckResource {

    @Inject
    private BuildProperties buildProperties;

    @GET
    public ApplicationInfo getInfo() {
        return new ApplicationInfo(buildProperties.getName(), buildProperties.getVersion());
    }

}
