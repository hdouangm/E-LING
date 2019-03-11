/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;


import application.eling.domain.DMP;
import application.eling.domain.Patient;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import application.repository.DMPRepository;
import javax.ws.rs.*;
import java.net.URI;
import javax.ejb.NoSuchEntityException;

/**
 *
 * @author asus
 */
@Path("/DMP")
public class DMPRestService {
    
    @EJB
    private DMPRepository repository;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDMPS() {
        List<DMP> DMP = repository.list();
        return Response.ok(DMP).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDMP(@PathParam("id") Integer id) {
        DMP dmp = repository.find(id);
        if (dmp == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dmp).build();
    }
    
 
 
}