package main.java.application;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.java.core.Intervention;
import main.java.core.InterventionDAO;

@Path("/interventions")
public class InterventionRestService {

		@EJB
	    private InterventionDAO interventionDAO = new InterventionDAO();

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
	
}
