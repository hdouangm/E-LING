/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.rest;

import com.ophedinho.eling.backend.domain.TypeExamen;
import com.ophedinho.eling.backend.repository.TypeExamenRepository;
import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author ophedinho
 */

@Path("/TypeExamen")
public class TypeExamenRestService {
    
    @EJB
    private TypeExamenRepository repository;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTypeExamen() {
        List<TypeExamen> types = repository.list();
        return Response.ok(types).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTypeExamen(TypeExamen te) {
        repository.save(te);
        URI typeUri = uriInfo.getBaseUriBuilder().path(TypeExamenRestService.class).path(te.getId().toString()).build();
        return Response.created(typeUri).build();
    }
    
}
