/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;

import application.repository.DonneesSocialesRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import application.domain.DonneesSociales;
import application.security.JWTTokenNeeded;
import javax.ws.rs.*;
import java.net.URI;
import javax.ejb.NoSuchEntityException;

/**
 *
 * @author asus
 */
@Path("/Profil")
public class ProfilRestService {
    
    @EJB
    private DonneesSocialesRepository repository;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response getDonneesSociales() {
        List<DonneesSociales> profils = repository.list();
        return Response.ok(profils).build();
    }
    
   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response getDonneesSociales(@PathParam("id") Long id) {
        DonneesSociales profil = repository.find(id);
        if (profil == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(profil).build();
    }
    
   /* @GET
    @Path("numeroSS/{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDonneesSociale(@PathParam("numero") String numero) {
        DonneesSociales profil = repository.findByUsername(numero);
        if (profil == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(profil).build();
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response createDonneesSociales(DonneesSociales profil) {
        repository.save(profil);
        URI profilUri = uriInfo.getBaseUriBuilder().path(ProfilRestService.class).path(profil.getId().toString()).build();
        return Response.created(profilUri).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response modifierDonneesSociales(DonneesSociales profil) {
        repository.update(profil);
        URI profilUri = uriInfo.getBaseUriBuilder().path(ProfilRestService.class).path(profil.getId().toString()).build();
        return Response.created(profilUri).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response deleteDonneesSociales(@PathParam("id") Long id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
    
}
