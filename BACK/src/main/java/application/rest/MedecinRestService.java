package application.rest;

import application.eling.domain.*;
import application.repository.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Set;

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
    @EJB
    private ActeRepository acterepository;

    @Context
    private UriInfo uriInfo;


    @GET
    @Path("listintervention")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listintervention(){
        return Response.ok(interventionrepository.list()).build();
    }
    @GET
    @Path("listacte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listacte(){
        return Response.ok(acterepository.list()).build();
    }

    @GET
    @Path("getacte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getacte(@QueryParam("type") String type,@QueryParam("id") Integer id){
        if (type.equals("intervention")){
            Intervention i = interventionrepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                return Response.ok(l).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("posologie")){
            Posologie i = posologierepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                return Response.ok(l).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("diagnostique")){
            Diagnostique i = diagnostiquerepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                return Response.ok(l).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("examen")){
            Examen i = examenrepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                return Response.ok(l).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("coderacte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response coderacte(@QueryParam("idacte") Integer idacte,@QueryParam("type") String type,@QueryParam("id") Integer id) {
        Acte a = acterepository.find(idacte);
        if (a == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("intervention")){
            Intervention i = interventionrepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.add(a)) {
                    i.setPrix(i.getPrix()+a.getPrix());
                    interventionrepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("posologie")){
            Posologie i = posologierepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.add(a)) {
                    //i.setCodesActes(l);
                    i.setPrix(i.getPrix()+a.getPrix());
                    posologierepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("diagnostique")){
            Diagnostique i = diagnostiquerepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.add(a)) {
                    //i.setCodesActes(l);
                    i.setPrix(i.getPrix()+a.getPrix());
                    diagnostiquerepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("examen")){
            Examen i = examenrepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.add(a)) {
                    //i.setCodesActes(l);
                    i.setPrix(i.getPrix()+a.getPrix());
                    examenrepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("deleteacte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteacte(@QueryParam("idacte") Integer idacte,@QueryParam("type") String type,@QueryParam("id") Integer id) {
        Acte a = acterepository.find(idacte);
        if (a == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("intervention")){
            Intervention i = interventionrepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.remove(a)) {
                    i.setPrix(i.getPrix()-a.getPrix());
                    interventionrepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("posologie")){
            Posologie i = posologierepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.remove(a)) {
                    //i.setCodesActes(l);
                    i.setPrix(i.getPrix()-a.getPrix());
                    posologierepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("diagnostique")){
            Diagnostique i = diagnostiquerepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.remove(a)) {
                    //i.setCodesActes(l);
                    i.setPrix(i.getPrix()-a.getPrix());
                    diagnostiquerepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (type.equals("examen")){
            Examen i = examenrepository.find(id);
            if (i != null){
                Set<Acte> l = i.getCodesActes();
                if (l.remove(a)) {
                    //i.setCodesActes(l);
                    i.setPrix(i.getPrix()-a.getPrix());
                    examenrepository.update(i);
                    return Response.ok(true).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("publierdiagnostique")
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierdiagnostique(@QueryParam("id") Integer id) {
        Diagnostique d = diagnostiquerepository.find(id);
        if (d != null ) {
            if (d.getPublication()) {
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierposologie(@QueryParam("id") Integer id) {
        Posologie p = posologierepository.find(id);
        if (p != null ) {
            if (p.getPublication()) {
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response publierintervention(@QueryParam("id") Integer id) {
        Intervention i = interventionrepository.find(id);
        if (i != null ) {
            if (i.getPublication()) {
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
            if (e.getPublication()) {
                return Response.notModified().build();
            }
            e.setPublication(true);
            examenrepository.update(e);
            return Response.ok(e).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("validationdemandeexamen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validationdemandeexamen(@QueryParam("id") Integer id) {
        DemandeExamen de = demandeexamenrepository.find(id);
        if (de != null ) {
            if (de.getPublierDemande()) {
                return Response.notModified().build();
            }
            de.setPublierDemande(true);
            demandeexamenrepository.update(de);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("validationdemandeintervention")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validationdemandeintervention(@QueryParam("id") Integer id) {
        DemandeIntervention di = demandeinterventionrepository.find(id);
        if (di != null ) {
            if (di.getPublierDemande()) {
                return Response.notModified().build();
            }
            di.setPublierDemande(true);
            demandeinterventionrepository.update(di);
            return Response.ok(true).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}

