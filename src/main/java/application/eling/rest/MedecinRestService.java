package application.eling.rest;

import application.eling.domain.*;
import application.eling.repository.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/medecin")
public class MedecinRestService {

    @EJB
    private DiagnostiqueRepository diagnostiquerepository;
    @EJB
    private PosologieRepository posologierepository;
    @EJB
    private InterventionRepository interventionrepository;
    @EJB
    private ExamenRepository examenrepository;
    @EJB
    private DemandeExamenRepository demandeexamenrepository;
    @EJB
    private DemandeInterventionRepository demandeinterventionrepository;


    @Context
    private UriInfo uriInfo;

    /*@GET
    @Path("coderacte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response coderacte() {
        return Response.ok(repository.list()).build();
    }
    */

    @GET
    @Path("publierdiagnostique")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response publierdiagnostique(@QueryParam("id") Integer id) {
        Diagnostique d = diagnostiquerepository.find(id);
        if (d != null ) {
            if (d.isPublication()) {
                return Response.notModified().build();
            }
            d.setPublication(true);
            diagnostiquerepository.update(d);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("publierposologie")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response publierposologie(@QueryParam("id") Integer id) {
        Posologie p = posologierepository.find(id);
        if (p != null ) {
            if (p.isPublication()) {
                return Response.notModified().build();
            }
            p.setPublication(true);
            posologierepository.update(p);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("publierintervention")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response publierintervention(@QueryParam("id") Integer id) {
        Intervention i = interventionrepository.find(id);
        if (i != null ) {
            if (i.isPublication()) {
                return Response.notModified().build();
            }
            i.setPublication(true);
            interventionrepository.update(i);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("publierexamen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierexamen(@QueryParam("id") Integer id) {
        Examen e = examenrepository.find(id);
        if (e != null ) {
            if (e.isPublication()) {
                return Response.notModified().build();
            }
            e.setPublication(true);
            examenrepository.update(e);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("validationdemandeexamen")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validationdemandeexamen(@QueryParam("id") Integer id) {
        DemandeExamen de = demandeexamenrepository.find(id);
        if (de != null ) {
            if (de.isPublication()) {
                return Response.notModified().build();
            }
            de.setPublication(true);
            demandeexamenrepository.update(de);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("validationdemandeintervention")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validationdemandeintervention(@QueryParam("id") Integer id) {
        DemandeIntervention di = demandeinterventionrepository.find(id);
        if (di != null ) {
            if (di.isPublication()) {
                return Response.notModified().build();
            }
            di.setPublication(true);
            demandeinterventionrepository.update(di);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}

