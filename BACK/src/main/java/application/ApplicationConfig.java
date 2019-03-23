package application;

import application.filters.CORSFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import application.resources.ImageService;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

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
        c.add(application.rest.PatientRestService.class);
        c.add(application.rest.SecretaireMedicaleRestService.class);
        c.add(application.rest.ConnexionRestService.class);
        c.add(application.rest.DMPRestService.class);
        c.add(application.rest.ProfilRestService.class);
        c.add(application.rest.TypeExamenRestService.class);
        c.add(application.rest.ExamenRestService.class);
        c.add(application.rest.FileRestService.class);
        c.add(application.rest.MedecinRestService.class);
        c.add(MultiPartFeature.class);
        c.add(ImageService.class);
        c.add(CORSFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}