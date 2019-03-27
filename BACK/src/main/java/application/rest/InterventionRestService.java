package application.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.glassfish.jersey.media.multipart.FormDataParam;

import application.eling.domain.DMP;
import application.eling.domain.DemandeIntervention;
import application.eling.domain.Employe;
import application.eling.domain.Intervention;
import application.repository.DMPRepository;
import application.repository.DemandeInterventionRepository;
import application.repository.EmployeRepository;
import application.repository.InterventionDAO;


@Path("/interventions")
public class InterventionRestService {



		@EJB
	    private InterventionDAO interventionDAO = new InterventionDAO();


		@EJB
		private DMPRepository dmpDAO;
		
		@EJB
		private DemandeInterventionRepository demandeDAO;
		
		@EJB
		private EmployeRepository employeDAO;

	    @Context
	    private UriInfo uriInfo;

	    
	    
	    @GET
	    @Path("all")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExams() {
	    	List<Intervention> exams = interventionDAO.findAll();
	        return Response.ok(exams).build();
	    }

	    @GET
	    @Path("all/dmp/{DMPID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDmpId(@PathParam("DMPID") Long id) {
	    	List<Intervention> interventions = interventionDAO.findByParam("dmp.id", id.toString());
	        if (interventions == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(interventions).build();
	    }
	    
	    @GET
	    @Path("get/{InterventionID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByInterventionId(@PathParam("InterventionID") Integer id) {
	        Intervention intervention = interventionDAO.get(id);
	        if (intervention == null) {
	        	try {
					interventionDAO.create(new Intervention());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.ok(intervention).build();
	    }
	    
	    @GET
	    @Path("all/responsable/{DocteurID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDocteurId(@PathParam("DocteurID") Long id) {
	    	List<Intervention> interventions = interventionDAO.findByParam("responsable.id", id.toString());
	        if (interventions == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(interventions).build();
	    }

	    
	    @DELETE
	    @Path("delete/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteExam(@PathParam("id") Long id) {
	        try {
	            interventionDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	    
	    @POST
	    @Path("create")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response createIntervention(Intervention exam) {

	    	try {
				interventionDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(InterventionRestService.class).path(String.valueOf(exam.getId())).build();
	        return Response.created(bookUri).build();
	    }
	    
	    @POST
	    @Path("linkDMP")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkDMPToExamen(@FormDataParam("intervention") Integer id_intervention, @FormDataParam("dmp") Integer id_dmp) {
	    	DMP dmp = dmpDAO.find(id_dmp);
	    	Intervention intervention = interventionDAO.get(id_intervention);
	    	try {
				intervention.setDmp(dmp);
				intervention = interventionDAO.update(intervention);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(intervention).build();
	    }
	    
	    @POST
	    @Path("linkRes")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkResToExamen(@FormDataParam("intervention") Integer id_intervention, @FormDataParam("res") Integer id_dmp) {
	    	Employe res = employeDAO.find(id_dmp);
	    	Intervention intervention = interventionDAO.get(id_intervention);
	    	try {
				intervention.setResponsable(res);
				intervention = interventionDAO.update(intervention);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(intervention).build();
	    }

	    
	    @POST
	    @Path("linkDemande")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkDemandeToExamen(@FormDataParam("intervention") Integer id_exam, @FormDataParam("demande") Integer id_demande) {
	    	DemandeIntervention demande = demandeDAO.find(id_demande);
	    	Intervention exam = interventionDAO.get(id_exam);
	    	try {
				exam.setDemandeIntervention(demande);
				exam = interventionDAO.update(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(exam).build();
	    }
	
}
