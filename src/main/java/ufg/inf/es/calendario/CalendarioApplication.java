package ufg.inf.es.calendario;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

@SpringBootApplication
public class CalendarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarioApplication.class, args);
    }

    @Bean
    @Scope("prototype")
    @Named("customDefaultMapper")
    public ObjectMapper defaultMapper() {
        final Module hibernateModule = new Hibernate5Module()
            .configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);

        return new ObjectMapper()
            .registerModule(hibernateModule);
    }

}
