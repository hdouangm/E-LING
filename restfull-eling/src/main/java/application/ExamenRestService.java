package main.java.application;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.java.core.Examen;
import main.java.core.ExamenDAO;

@Path("/examen")
public class ExamenRestService {

		@EJB
	    private ExamenDAO examenDAO = new ExamenDAO();

	    @Context
	    private UriInfo uriInfo;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExams() {
	    	List<Examen> exams = examenDAO.findAll();
	        return Response.ok(exams).build();
 
	    }

	    @GET
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExam(@PathParam("id") Long id) {
	        Examen examen = examenDAO.get(id);
	        if (examen == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(examen).build();
	    }

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response createExam(Examen exam) {
	        try {
				examenDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(ExamenRestService.class).path(exam.getId().toString()).build();
	        return Response.created(bookUri).build();
	    }

	    @DELETE
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteExam(@PathParam("id") Long id) {
	        try {
	            examenDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	
}
