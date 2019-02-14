package main.java.application;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.java.core.Posologie;
import main.java.core.PosologieDAO;

@Path("/posologie")
public class PosologieRestService {

		@EJB
	    private PosologieDAO posologieDAO = new PosologieDAO();

	    @Context
	    private UriInfo uriInfo;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getAllPosologie() {
	    	List<Posologie> exams = posologieDAO.findAll();
	        return Response.ok(exams).build();
 
	    }

	    @GET
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getPosologie(@PathParam("id") Long id) {
	        Posologie posologie = posologieDAO.get(id);
	        if (posologie == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(posologie).build();
	    }

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response createPosologie(Posologie exam) {
	        try {
				posologieDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(PosologieRestService.class).path(exam.getId().toString()).build();
	        return Response.created(bookUri).build();
	    }

	    @DELETE
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deletePosologie(@PathParam("id") Long id) {
	        try {
	            posologieDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	
}
