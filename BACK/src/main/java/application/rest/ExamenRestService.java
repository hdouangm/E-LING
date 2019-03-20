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
import application.eling.domain.DemandeExamen;
import application.eling.domain.Employe;
import application.eling.domain.Examen;
import application.repository.DMPRepository;
import application.repository.DemandeExamenRepository;
import application.repository.EmployeRepository;
import application.repository.ExamenDAO;


@Path("/examens")
public class ExamenRestService {

		@EJB
	    private ExamenDAO examenDAO = new ExamenDAO();
		
		@EJB
		private DMPRepository dmpDAO;
		
		@EJB
		private DemandeExamenRepository demandeDAO;
		
		@EJB
		private EmployeRepository employeDAO;

	    @Context
	    private UriInfo uriInfo;

	    
	    
	    @GET
	    @Path("all")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExams() {
	    	List<Examen> exams = examenDAO.findAll();
	        return Response.ok(exams).build();
	    }

	    @GET
	    @Path("all/dmp/{DMPID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDmpId(@PathParam("DMPID") Long id) {
	    	List<Examen> examens = examenDAO.findByParam("dmp.id", id.toString());
	        if (examens == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(examens).build();
	    }
	    
	    @GET
	    @Path("get/{ExamenID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByExamenId(@PathParam("ExamenID") Integer id) {
	        Examen examen = examenDAO.get(id);
	        if (examen == null) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.ok(examen).build();
	    }
	    
	    @GET
	    @Path("all/responsable/{DocteurID}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getExamByDocteurId(@PathParam("DocteurID") Long id) {
	    	List<Examen> examens = examenDAO.findByParam("responsable.id", id.toString());
	        if (examens == null)
	            return Response.status(Response.Status.NOT_FOUND).build();
	        return Response.ok(examens).build();
	    }

	    
	    @DELETE
	    @Path("delete/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response deleteExam(@PathParam("id") Long id) {
	        try {
	            examenDAO.delete(id);
	        } catch (Exception e) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.noContent().build();
	    
	    }
	    
	    @POST
	    @Path("create")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response createExamen(Examen exam) {
	    	try {
				exam = examenDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	    	URI bookUri = uriInfo.getBaseUriBuilder().path(ExamenRestService.class).path(String.valueOf(exam.getId())).build();
	        return Response.ok(exam).build();
	    }
	    
	    @POST
	    @Path("linkDMP")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkDMPToExamen( @FormDataParam("examen")  Integer idExamen, @FormDataParam("dmp") Integer idDmp) {
	    	DMP dmp = dmpDAO.find(idDmp);
	    	Examen examen = examenDAO.get(idExamen);
	    	try {
				examen.setDmp(dmp);
				examen = examenDAO.update(examen);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(examen).build();
	    }
	    
	    @POST
	    @Path("linkRes")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkResToExamen( @FormDataParam("examen")  Integer idExamen, @FormDataParam("res") Integer idRes) {
	    	Employe res = employeDAO.find(idRes);
	    	Examen examen = examenDAO.get(idExamen);
	    	try {
				examen.setResponsable(res);
				examen = examenDAO.update(examen);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(examen).build();
	    }
	    
	    @POST
	    @Path("linkDemande")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkDemandeToExamen(@FormDataParam("examen") Integer id_exam, @FormDataParam("demande") Integer id_demande) {
	    	DemandeExamen demande = demandeDAO.find(id_demande);
	    	Examen exam = examenDAO.get(id_exam);
	    	try {
				exam.setDemandeExamen(demande);
				exam = examenDAO.update(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(exam).build();
	    }
	    

	
}
