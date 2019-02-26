/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.rest;

import com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention;
import com.ophedinho.eling.backend.repository.DemandeInterventionRepository;
import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.NoSuchEntityException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

@Path("/DemandeIntervention")
public class DemandeInterventionRestService {
    
    @EJB
    private DemandeInterventionRepository repository;

    @Context
    private UriInfo uriInfo;
    //private Object d_intervention;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDemandeIntervention() {
        List<DemandeIntervention> d_intervention = repository.list();
        return Response.ok(d_intervention).build();
    }
    
    @GET
    @Path("/Med")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDemandeInterventionMed() {
        List<DemandeIntervention> d_intervention = repository.listMed();
        return Response.ok(d_intervention).build();
    }
    
    @GET
    @Path("/Lab")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDemandeInterventionLab() {
        List<DemandeIntervention> d_intervention = repository.listLab();
        return Response.ok(d_intervention).build();
    }
    
    @GET
    @Path("/Search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDemandeIntervention(@PathParam("id") Long id) {
        DemandeIntervention d_intervention = repository.find(id);
        if (d_intervention == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(d_intervention).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDemandeIntervention(DemandeIntervention d_intervention) {
        repository.save(d_intervention);
        URI compteUri = uriInfo.getBaseUriBuilder().path(DemandeInterventionRestService.class).path(d_intervention.getId().toString()).build();
        return Response.created(compteUri).build();
    }
    
    @PUT
    @Path("/Update")
    @Produces({ MediaType.APPLICATION_JSON})
    public Long updateDemandeIntervention(DemandeIntervention d_intervention) {
        return repository.update(d_intervention);
    }
 
    @DELETE
    @Path("/Delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteDemandeIntervention(@PathParam("id") Long id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
    
}
