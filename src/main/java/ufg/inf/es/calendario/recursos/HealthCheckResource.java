package ufg.inf.es.calendario.recursos;

import org.springframework.boot.info.BuildProperties;
import ufg.inf.es.calendario.dominio.ApplicationInfo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
@Path("/healthcheck")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckResource {

    private final BuildProperties buildProperties;

    @Inject
    public HealthCheckResource(final BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    /**
     * Retorna informações da versão e informações da aplicação.
     * Útil para checagens de saúde da API
     *
     * @return objeto do tipo ApplicationInfo - objeto contendo o nome e versão da aplicação.
     */
    @GET
    public ApplicationInfo getInfo() {
        return new ApplicationInfo(buildProperties.getName(), buildProperties.getVersion());
    }

}
