package ufg.inf.es.calendario.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomJacksonJaxProvider extends JacksonJaxbJsonProvider {

    public CustomJacksonJaxProvider() {
        setMapper(new ObjectMapper()
                .registerModule(
                        new Hibernate5Module()
                                .configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true)));
    }
}
