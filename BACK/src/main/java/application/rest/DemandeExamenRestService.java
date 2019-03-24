/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;


import application.eling.domain.DemandeExamen;
import application.repository.DemandeExamenRepository;

import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.NoSuchEntityException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
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
    @Path("/Med")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDemandeExamenMed() {
        List<DemandeExamen> d_examen = repository.listMed();
        return Response.ok(d_examen).build();
    }
    
    @GET
    @Path("/Lab")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDemandeExamenLab() {
        List<DemandeExamen> d_examen = repository.listLab();
        return Response.ok(d_examen).build();
    }
    
    @GET
    @Path("/Search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDemandeExamen(@PathParam("id") int id) {
        DemandeExamen d_examen = repository.find(id);
        if (d_examen == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(d_examen).build();
    }
    
    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDemandeExamen(DemandeExamen d_examen) {
        repository.save(d_examen);
        URI compteUri = uriInfo.getBaseUriBuilder().path(DemandeExamenRestService.class).path(Integer.toString(d_examen.getId())).build();
        return Response.ok().build();
    }
    
    
    @PUT
    @Path("/Update")
    @Produces({ MediaType.APPLICATION_JSON})
    public int updateDemandeExamen(DemandeExamen dExamen) {
        return repository.update(dExamen);
    }
 
    @DELETE
    @Path("/Delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDemandeExamen(@PathParam("id") int id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
