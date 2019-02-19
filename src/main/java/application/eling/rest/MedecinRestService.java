package application.eling.rest;

import application.eling.repository.DMPRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/medecin")
public class MedecinRestService {

    @EJB
    private DMPRepository repository;


    @Context
    private UriInfo uriInfo;

    @GET
    @Path("coderacte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response coderacte() {
        return Response.ok(repository.list()).build();
    }

    @GET
    @Path("publierdiagnostique")
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierdiagnostique(@PathParam("id") Integer id) {
        return Response.ok(true).build();
    }

    @GET
    @Path("publierposologie")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response publierposologie(@PathParam("id") Integer id) {

        return Response.ok(true).build();
    }

    @GET
    @Path("publierintervention")
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierintervention(@PathParam("id") Integer id) {
        return Response.ok(true).build();
    }

    @GET
    @Path("publierexamen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierexamen(@PathParam("id") Integer id) {
        return Response.ok(true).build();
    }

    @GET
    @Path("validationdemandeexamen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validationdemandeexamen(@PathParam("id") Integer id) {
        return Response.ok(true).build();
    }

    @GET
    @Path("validationdemandeintervention")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validationdemandeintervention(@PathParam("id") Integer id) {
        return Response.ok(true).build();
    }

}

