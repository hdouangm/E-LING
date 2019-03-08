/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;

import application.domain.DonneesSociales;
import application.domain.Employe;
import application.repository.DonneesSocialesRepository;
import application.repository.EmployeRepository;
import application.security.JWTTokenNeeded;
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
 * @author asus
 */
@Path("/Employe")
public class EmployeRestService {
    @EJB
    private EmployeRepository repository;

    @Context
    private UriInfo uriInfo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response getEmploye() {
        List<Employe> profils = repository.list();
        return Response.ok(profils).build();
    }

    @GET
    @Path("getByLogin/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response getDonneesSociales(@PathParam("login") String login) {
        Employe employe = repository.findByLogin(login);
        if (employe == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(employe).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response getDonneesSociales(@PathParam("id") Integer id) {
        Employe employe = repository.find(id);
        if (employe == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(employe).build();
    }
    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response createDonneesSociales(Employe employe) {
        repository.save(employe);
        URI profilUri = uriInfo.getBaseUriBuilder().path(ProfilRestService.class).path(employe.getId().toString()).build();
        return Response.created(profilUri).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response modifierDonneesSociales(Employe employe) {
        repository.update(employe);
        URI profilUri = uriInfo.getBaseUriBuilder().path(ProfilRestService.class).path(employe.getId().toString()).build();
        return Response.created(profilUri).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response deleteDonneesSociales(@PathParam("id") Integer id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
