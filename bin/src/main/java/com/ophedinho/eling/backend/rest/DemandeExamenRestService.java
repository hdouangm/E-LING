/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.rest;

import com.ophedinho.eling.backend.demandeExamen.domain.DemandeExamen;
import com.ophedinho.eling.backend.repository.DemandeExamenRepository;
import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/**
 *
 * @author ophedinho
 */

@Path("/DemandeExamen")
public class DemandeExamenRestService {
    
    @EJB
    private DemandeExamenRepository repository;

    @Context
    private UriInfo uriInfo;
    //private Object d_examen;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDemandeExamen() {
        List<DemandeExamen> d_examen = repository.list();
        return Response.ok(d_examen).build();
    }
    
    @GET
    @Path("/Search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDemandeExamen(@PathParam("id") Long id) {
        DemandeExamen d_examen = repository.find(id);
        if (d_examen == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(d_examen).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDemandeExamen(DemandeExamen d_examen) {
        repository.save(d_examen);
        URI compteUri = uriInfo.getBaseUriBuilder().path(DemandeExamenRestService.class).path(d_examen.getId().toString()).build();
        return Response.created(compteUri).build();
    }
}
