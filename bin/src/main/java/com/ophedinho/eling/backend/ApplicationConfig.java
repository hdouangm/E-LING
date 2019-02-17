/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend;

/**
 *
 * @author ophedinho
 */

import com.ophedinho.eling.backend.rest.CompteAphpRestService;
import com.ophedinho.eling.backend.filters.CORSFilter;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.glassfish.jersey.jackson.JacksonFeature;

@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(JacksonFeature.class);
        c.add(CompteAphpRestService.class);
        c.add(CORSFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
