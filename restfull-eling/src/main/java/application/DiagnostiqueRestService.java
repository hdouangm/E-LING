package main.java.application;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.java.core.Diagnostique;
import main.java.core.DiagnostiqueDAO;

@Path("/diagnostique")
public class DiagnostiqueRestService {

		@EJB
	    private DiagnostiqueDAO diagnostiqueDAO = new DiagnostiqueDAO();

	    @Context
	    private UriInfo uriInfo;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getAllDiagnostique() {
	    	List<Diagnostique> exams = diagnostiqueDAO.findAll();
	        return Response.ok(exams).build();
 
	    }

	    @GET
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getDiagnostique(@PathParam("id") Long id) {
	        Diagnostique diagnostique = diagnostiqueDAO.get(id);
	        if (diagnostique == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(diagnostique).build();
	    }

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response createDiagnostique(Diagnostique exam) {
	        try {
				diagnostiqueDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(DiagnostiqueRestService.class).path(exam.getId().toString()).build();
	        return Response.created(bookUri).build();
	    }

	    @DELETE
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteDiagnostique(@PathParam("id") Long id) {
	        try {
	            diagnostiqueDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	
}
