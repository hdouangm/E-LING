/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;

import application.eling.domain.TypeIntervention;
import application.repository.TypeInterventionRepository;
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

@Path("/TypeIntervention")
public class TypeInterventionRestService {
    
    @EJB
    private TypeInterventionRepository repository;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTypeIntervention() {
        List<TypeIntervention> types = repository.list();
        return Response.ok(types).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTypeIntervention(TypeIntervention ti) {
        repository.save(ti);
        URI typeUri = uriInfo.getBaseUriBuilder().path(TypeInterventionRestService.class).path(ti.getId().toString()).build();
        return Response.created(typeUri).build();
    }
    
}
