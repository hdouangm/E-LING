/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;


import application.domain.DMP;
import application.domain.Patient;
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
import application.security.JWTTokenNeeded;
import application.security.RoleNeeded;
import application.security.utils.Role;
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
    @Path("{id}")
    //@JWTTokenNeeded
    @RoleNeeded({Role.MEDECIN, Role.SECRETAIRE_MEDICAL})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDMP(@PathParam("id") Long id) {
        DMP dmp = repository.find(id);
        if (dmp == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dmp).build();
    }
    
   /* @GET
    @Path("accederDMP/{patient}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response accederDMP(@PathParam("patient") Patient patient) {
        DMP dmp = repository.findByPatient(patient);
        if (dmp == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dmp).build();
    }*/
    
 
}
