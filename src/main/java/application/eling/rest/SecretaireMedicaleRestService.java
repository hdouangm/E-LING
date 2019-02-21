package application.eling.rest;


import application.eling.domain.*;
import application.eling.repository.*;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/secretairemedicale")
public class SecretaireMedicaleRestService {

    @Context
    private UriInfo uriInfo;

    @EJB
    private DMPRepository dmpRepository;

    @EJB
    private NoeudHopitalRepository noeudHopitalRepository;

    @EJB
    private DonneeSocialeRepository donneeSocialeRepository;

    @EJB
    private PatientRepository patientRepository;

    @EJB
    private DemandeInterventionRepository demandeInterventionRepository;

    @EJB
    private DemandeExamenRepository demandeExamenRepository;

    @EJB
    private ConstantesVitalesRepository constantesVitalesRepository;

    @EJB
    private PosologieRepository posologieRepository;

    @EJB
    private ExamenRepository examenRepository;

    @EJB
    private DiagnostiqueRepository diagnostiqueRepository;

    @EJB
    private InterventionRepository interventionRepository;



    @GET
    @Path("patients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatient () throws Exception {
        List<Patient> tmp = patientRepository.list();
        return Response.ok(tmp).build();
    }

    @GET
    @Path("creerpatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPatient (@QueryParam("ss") String ss, @QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("adresse") String adresse, @QueryParam("age") String age,@QueryParam("genre") String genre) throws Exception {
        DMP dmp = new DMP(ss);
        NoeudHopital noeudHopital = new NoeudHopital();
        DonneesSociales donneesSociales = new DonneesSociales(nom, prenom, adresse, age, genre);
        Patient patient = new Patient(noeudHopital, dmp, donneesSociales);

        List<DMP> tmp = dmpRepository.findByParam(ss);
        if (tmp.size() > 0){
            return Response.status(Response.Status.CONFLICT).build();
        }
        dmpRepository.save(dmp);

        noeudHopitalRepository.save(noeudHopital);

        donneeSocialeRepository.save(donneesSociales);

        Integer idPatient = patientRepository.save(patient);
        Patient p = patientRepository.find(idPatient);

        return Response.ok(p).build();
    }

    @GET
    @Path("transfertpatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferPatient (@QueryParam("idPatient") Integer idPatient, @QueryParam("idNoeud") Integer idNoeud){
        Patient patient = patientRepository.find(idPatient);
        if (patient == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        NoeudHopital noeudHopital = noeudHopitalRepository.find(idNoeud);
        if (noeudHopital == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        patient.setNoeudHopital(noeudHopital);
        patientRepository.update(patient);
        return Response.ok(patient).build();
    }

    @GET
    @Path("updatedemandeintervention")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPDemandeIntervention(@QueryParam("idDMP") Integer idDMP, @QueryParam("idDemandeIntervention") Integer idDemandeIntervention){
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        DemandeIntervention demandeIntervention = demandeInterventionRepository.find(idDemandeIntervention);
        if (demandeIntervention == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        demandeIntervention.setDmp(dmp);
        demandeInterventionRepository.update(demandeIntervention);
        return Response.ok(true).build();
    }

    @GET
    @Path("updatedemandeexamen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPDemandeExamen(@QueryParam("idDMP") Integer idDMP, @QueryParam("idDemandeExamen") Integer idDemandeExamen) {
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        DemandeExamen demandeExamen = demandeExamenRepository.find(idDemandeExamen);
        if (demandeExamen == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        demandeExamen.setDmp(dmp);
        demandeExamenRepository.update(demandeExamen);
        return Response.ok(true).build();
    }

    @GET
    @Path("updatedeconstantesVitales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPConstantesVitales(@QueryParam("idDMP") Integer idDMP, @QueryParam("idConstantesVitales") Integer idConstantesVitales) {
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        ConstantesVitales constantesVitales = constantesVitalesRepository.find(idConstantesVitales);
        if (constantesVitales == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        constantesVitales.setDmp(dmp);
        constantesVitalesRepository.update(constantesVitales);
        return Response.ok(true).build();
    }

    @GET
    @Path("updatedeposologie")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPPosologie(@QueryParam("idDMP") Integer idDMP, @QueryParam("idPosologie") Integer idPosologie){
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        Posologie posologie = posologieRepository.find(idPosologie);
        if (posologie == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        posologie.setDmp(dmp);
        posologieRepository.update(posologie);
        return Response.ok(true).build();
    }

    @GET
    @Path("updatedeexamen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPExamen(@QueryParam("idDMP") Integer idDMP, @QueryParam("idExamen") Integer idExamen){
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        Examen examen = examenRepository.find(idExamen);
        if (examen == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        examen.setDmp(dmp);
        examenRepository.update(examen);
        return Response.ok(true).build();
    }

    @GET
    @Path("updatedediagnostique")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPDiagnostique(@QueryParam("idDMP") Integer idDMP, @QueryParam("idDiagnostique") Integer idDiagnostique){
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        Diagnostique diagnostique = diagnostiqueRepository.find(idDiagnostique);
        if (diagnostique == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        diagnostique.setDmp(dmp);
        diagnostiqueRepository.update(diagnostique);
        return Response.ok(true).build();
    }

    @GET
    @Path("updatedeintervention")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDMPIntervention(@QueryParam("idDMP") Integer idDMP, @QueryParam("idIntervention") Integer idIntervention){
        DMP dmp = dmpRepository.find(idDMP);
        if (dmp == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        Intervention intervention = interventionRepository.find(idIntervention);
        if (intervention == null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        intervention.setDmp(dmp);
        interventionRepository.update(intervention);
        return Response.ok(true).build();
    }

}
