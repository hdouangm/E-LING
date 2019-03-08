package application;

import application.rest.EchoEndpoint;
import application.rest.ProfilRestService;
import application.filters.CORSFilter;
import application.rest.ConnexionRestService;
import application.rest.DMPRestService;
import application.rest.DeconnexionRestService;
import application.rest.EmployeRestService;
import application.security.JWTTokenNeededFilter;
import application.security.RoleNeededFilter;
import org.glassfish.jersey.jackson.JacksonFeature;


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
        c.add(ProfilRestService.class);
        c.add(DMPRestService.class);
        c.add(ConnexionRestService.class);
        c.add(DeconnexionRestService.class);
        c.add(EmployeRestService.class);
        c.add(EchoEndpoint.class);
        c.add(JWTTokenNeededFilter.class);
        c.add(RoleNeededFilter.class);
        c.add(CORSFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}