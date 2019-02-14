package main.java.application;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.java.core.Intervention;
import main.java.core.InterventionDAO;

@Path("/intervention")
public class InterventionRestService {

		@EJB
	    private InterventionDAO interventionDAO = new InterventionDAO();

	    @Context
	    private UriInfo uriInfo;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getAllIntervention() {
	    	List<Intervention> exams = interventionDAO.findAll();
	        return Response.ok(exams).build();
 
	    }

	    @GET
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getIntervention(@PathParam("id") Long id) {
	        Intervention intervention = interventionDAO.get(id);
	        if (intervention == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(intervention).build();
	    }

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response createIntervention(Intervention exam) {
	        try {
				interventionDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(InterventionRestService.class).path(exam.getId().toString()).build();
	        return Response.created(bookUri).build();
	    }

	    @DELETE
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteIntervention(@PathParam("id") Long id) {
	        try {
	            interventionDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	
}
