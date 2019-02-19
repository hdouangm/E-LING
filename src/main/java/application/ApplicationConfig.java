package application;

import application.filters.CORSFilter;
import application.responsableLaboratoire.rest.AgendaRestService;
import org.glassfish.jersey.jackson.JacksonFeature;
import application.responsableLaboratoire.rest.ResponsableLaboratoireRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(JacksonFeature.class);
        c.add(ResponsableLaboratoireRestService.class);
        c.add(AgendaRestService.class);
        c.add(CORSFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}