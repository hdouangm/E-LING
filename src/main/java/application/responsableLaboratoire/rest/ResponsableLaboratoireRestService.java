/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.responsableLaboratoire.rest;

import application.responsableLaboratoire.domain.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 *
 * @author Reda Amhaouch
 */
@Path("/responsableLaboratoire")
public class ResponsableLaboratoireRestService {
    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN) // added
    public Response createExamen(Examen examen) {
        ResponsableLaboratoire responsableLaboratoire = new ResponsableLaboratoire();
        responsableLaboratoire.creerExamen(examen);
        
        URI uri = uriInfo.getBaseUriBuilder().path(ResponsableLaboratoireRestService.class).path(examen.getId().toString()).build();
        return Response.created(uri).build();
        //return examen.getName();
    }
    
    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN) // added
    public Response editExamen(Examen examen) {
        ResponsableLaboratoire responsableLaboratoire = new ResponsableLaboratoire();
        responsableLaboratoire.modifierExamen(examen);
        
        URI uri = uriInfo.getBaseUriBuilder().path(ResponsableLaboratoireRestService.class).path(examen.getId().toString()).build();
        return Response.created(uri).build();
        //return examen.getName();
    }
    
    @GET
    @Path("/responsables")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListResponsables() {
        List<Employe> employes = Employe.getAllEmployes();
        return Response.ok(employes).build();
    }
    
    @GET
    @Path("/dmps")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListDMPs() {
        List<DMP> dmps = DMP.getAllDMPs();
        return Response.ok(dmps).build();
    }
    
    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExam(@PathParam("id") Long id) {
        ResponsableLaboratoire.supprimerExamen(id);
        return Response.ok(id).build();
    }
    
    @GET
    @Path("/publish/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response publishExam(@PathParam("id") Long id) {
        ResponsableLaboratoire.publierExamen(id);
        return Response.ok(id).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExamens() {
        return Response.ok(Examen.getAll()).build();
    }
}
