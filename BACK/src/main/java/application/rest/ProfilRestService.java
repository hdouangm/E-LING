/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;

import application.eling.domain.CompteAphp;
import application.eling.domain.Employe;
import application.repository.CompteAphpRepository;
import application.repository.DonneeSocialeRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import application.eling.domain.DonneesSociales;
import javax.ws.rs.*;
import java.net.URI;
import javax.annotation.security.DeclareRoles;
import javax.ejb.NoSuchEntityException;

/**
 *
 * @author asus
 */
@Path("/Profil")
public class ProfilRestService {
    
    @EJB
    private DonneeSocialeRepository repository;

    @EJB
    private CompteAphpRepository caphp;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDonneesSociales() {
        List<DonneesSociales> profils = repository.list();
        return Response.ok(profils).build();
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getDonneesSociales")
    public Response getDonneesSociales(String login) {
        DonneesSociales ds = caphp.findByLogin(login);
        if(ds == null)
            return Response.status(Response.Status.NO_CONTENT).build();


        return Response.ok(ds).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getNiveau")
    public Response getEmploye(String login) {
        Employe ds = caphp.getEmploye(login);

        if(ds == null)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(ds).build();
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
    public Response createDonneesSociales(DonneesSociales profil) {
        repository.save(profil);
        URI profilUri = uriInfo.getBaseUriBuilder().path(ProfilRestService.class).path(profil.getId().toString()).build();
        return Response.created(profilUri).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifierDonneesSociales(DonneesSociales profil) {
        repository.update(profil);
        URI profilUri = uriInfo.getBaseUriBuilder().path(ProfilRestService.class).path(profil.getId().toString()).build();
        return Response.created(profilUri).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDonneesSociales(@PathParam("id") Integer  id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
    
}
