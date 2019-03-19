package application.rest;

import application.eling.domain.DMP;
import application.eling.domain.DonneesSociales;
import application.eling.domain.NoeudHopital;
import application.eling.domain.Patient;

import javax.ejb.EJB;
import javax.ejb.NoSuchEntityException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/Patient")
public class PatientRestService {

    @EJB
    private application.repository.PatientRepository repository;

    @EJB
    private application.repository.DMPRepository dmprepo;
    @EJB
    private application.repository.NoeudHopitalRepository noeudrepo;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatients() {
        List<Patient> Patients = repository.list();
        return Response.ok(Patients).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("PatientByID")
    public Response getPatientByID(@QueryParam("id") Integer id) {
        Patient patient = repository.find(id);
        if (patient == null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        return Response.ok(patient).build();
    }

    @GET
    @Path("PatientByNom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientByNom(@QueryParam("nom") String nom) {

        List<Patient> toSend = repository.findByDsNom(nom);


        if (toSend == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(toSend).build();
    }

    @GET
    @Path("PatientByNomPrenom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientNomPrenom(@QueryParam("nom") String nom,@QueryParam("prenom") String prenom) {

        List<Patient> toSend = repository.findByDsNomPrenom(nom,prenom);
        if (toSend == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(toSend).build();
    }


    @DELETE
    @Path("deletePatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePatient(@QueryParam("id") Integer id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
