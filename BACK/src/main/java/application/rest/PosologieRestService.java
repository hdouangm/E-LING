package application.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import application.eling.domain.Posologie;
import application.repository.PosologieDAO;


@Path("/posologies")
public class PosologieRestService {

		@EJB
	    private PosologieDAO posologieDAO = new PosologieDAO();

	    @Context
	    private UriInfo uriInfo;

	    
	    
	    @GET
	    @Path("all")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExams() {
	    	List<Posologie> exams = posologieDAO.findAll();
	        return Response.ok(exams).build();
	    }

	    @GET
	    @Path("all/dmp/{DMPID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDmpId(@PathParam("DMPID") Long id) {
	    	List<Posologie> posologies = posologieDAO.findByParam("dmp.id", id.toString());
	        if (posologies == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(posologies).build();
	    }
	    
	    @GET
	    @Path("get/{PosologieID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByPosologieId(@PathParam("PosologieID") Integer id) {
	        Posologie posologie = posologieDAO.get(id);
	        if (posologie == null) {
	        	try {
					posologieDAO.create(new Posologie());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.ok(posologie).build();
	    }
	    
	    @GET
	    @Path("all/responsable/{DocteurID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDocteurId(@PathParam("DocteurID") Long id) {
	    	List<Posologie> posologies = posologieDAO.findByParam("responsable.id", id.toString());
	        if (posologies == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(posologies).build();
	    }

	    
	    @DELETE
	    @Path("delete/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteExam(@PathParam("id") Long id) {
	        try {
	            posologieDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	    
	    @POST
	    @Path("create")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response createPosologie(Posologie exam) {
	    	try {
				posologieDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(PosologieRestService.class).path(String.valueOf(exam.getId())).build();
	        return Response.created(bookUri).build();
	    }
	
}
