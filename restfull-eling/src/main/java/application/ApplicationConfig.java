package main.java.application;

import java.util.Collections;
import java.util.HashSet;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;



@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        
        c.add(ExamenRestService.class);
        c.add(FileRestService.class);
        c.add(MultiPartFeature.class);
        c.add(CORSFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
    
    
}