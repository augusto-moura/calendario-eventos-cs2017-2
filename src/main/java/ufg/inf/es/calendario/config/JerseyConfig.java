package ufg.inf.es.calendario.config;


import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

@Named
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super();
        packages("ufg.inf.es.calendario.recursos", "ufg.inf.es.calendario.config");
    }

}
