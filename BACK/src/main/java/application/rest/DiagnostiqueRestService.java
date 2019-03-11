package main.java.application;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.java.core.Diagnostique;
import main.java.core.DiagnostiqueDAO;

@Path("/diagnostiques")
public class DiagnostiqueRestService {

		@EJB
	    private DiagnostiqueDAO diagnostiqueDAO = new DiagnostiqueDAO();

	    @Context
	    private UriInfo uriInfo;

	    
	    
	    @GET
	    @Path("all")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExams() {
	    	List<Diagnostique> exams = diagnostiqueDAO.findAll();
	        return Response.ok(exams).build();
	    }

	    @GET
	    @Path("all/dmp/{DMPID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDmpId(@PathParam("DMPID") Long id) {
	    	List<Diagnostique> diagnostiques = diagnostiqueDAO.findByParam("dmp.id", id.toString());
	        if (diagnostiques == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(diagnostiques).build();
	    }
	    
	    @GET
	    @Path("get/{DiagnostiqueID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDiagnostiqueId(@PathParam("DiagnostiqueID") Integer id) {
	        Diagnostique diagnostique = diagnostiqueDAO.get(id);
	        if (diagnostique == null) {
	        	try {
					diagnostiqueDAO.create(new Diagnostique());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.ok(diagnostique).build();
	    }
	    
	    @GET
	    @Path("all/responsable/{DocteurID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDocteurId(@PathParam("DocteurID") Long id) {
	    	List<Diagnostique> diagnostiques = diagnostiqueDAO.findByParam("responsable.id", id.toString());
	        if (diagnostiques == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(diagnostiques).build();
	    }

	    
	    @DELETE
	    @Path("delete/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteExam(@PathParam("id") Long id) {
	        try {
	            diagnostiqueDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	    
	    @POST
	    @Path("create")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response createDiagnostique(Diagnostique exam) {
	    	try {
				diagnostiqueDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(DiagnostiqueRestService.class).path(String.valueOf(exam.getId())).build();
	        return Response.created(bookUri).build();
	    }
	
}
