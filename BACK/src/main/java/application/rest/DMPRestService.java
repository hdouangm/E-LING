/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;


import application.eling.domain.DMP;
import application.eling.domain.Examen;
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
import application.repository.PatientRepository;

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

    @EJB
    private PatientRepository patientrep;
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

    @POST
    @Path("getDMP")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDMPP(@PathParam("id") Integer id) {
        DMP p = patientrep.find(id).getDmp();
        if (p == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(p).build();
    }
    @POST
    @Path("profession")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setProfession( DMP dmp ) {
        if (dmp == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        repository.setProfession(dmp);


        return Response.ok().build();


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
