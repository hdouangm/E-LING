/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.rest;

import com.ophedinho.eling.backend.domain.CompteAphp;
import com.ophedinho.eling.backend.repository.CompteAphpRepository;
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
@Path("/CompteAphp")
public class CompteAphpRestService {
    
    @EJB
    private CompteAphpRepository repository;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompteAphp() {
        List<CompteAphp> comptes = repository.list();
        return Response.ok(comptes).build();
    }

    @GET
    @Path("/Search/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompteAphp(@PathParam("username") String usr, @PathParam("password") String psw) {
        //List<CompteAphp> comptes = (List<CompteAphp>) repository.find(new CompteAphp(usr, psw));
        List<CompteAphp> comptes = (List<CompteAphp>) repository.find(usr, psw);
        if (comptes.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(comptes).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompteAphp(CompteAphp cp) {
        repository.save(cp);
        URI compteUri = uriInfo.getBaseUriBuilder().path(CompteAphpRestService.class).path(cp.getId().toString()).build();
        return Response.created(compteUri).build();
    }
    
}
