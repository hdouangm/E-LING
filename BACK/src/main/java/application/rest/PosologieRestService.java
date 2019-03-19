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
import application.eling.domain.Employe;
import application.eling.domain.Examen;
import application.eling.domain.Intervention;
import application.eling.domain.Posologie;
import application.repository.DMPRepository;
import application.repository.EmployeRepository;
import application.repository.PosologieDAO;


@Path("/posologies")
public class PosologieRestService {

		@EJB
	    private PosologieDAO posologieDAO = new PosologieDAO();
		
		@EJB
		private DMPRepository dmpDAO;
		
		@EJB
		private EmployeRepository employeDAO;

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
	    
	    @POST
	    @Path("linkDMP")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkDMPToExamen(@FormDataParam("posologie") Integer id_exam, @FormDataParam("dmp") Integer id_dmp) {
	    	DMP dmp = dmpDAO.find(id_dmp);
	    	Posologie exam = posologieDAO.get(id_exam);
	    	try {
				exam.setDmp(dmp);
				exam = posologieDAO.update(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(exam).build();
	    }
	    
	    @POST
	    @Path("linkRes")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkResToExamen(@FormDataParam("posologie") Integer id_intervention, @FormDataParam("res") Integer id_dmp) {
	    	Employe res = employeDAO.find(id_dmp);
	    	Posologie intervention = posologieDAO.get(id_intervention);
	    	try {
				intervention.setResponsable(res);
				intervention = posologieDAO.update(intervention);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(intervention).build();
	    }
	
}
