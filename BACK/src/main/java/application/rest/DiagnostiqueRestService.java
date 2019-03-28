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
import application.eling.domain.Diagnostique;
import application.eling.domain.Employe;
import application.eling.domain.Intervention;
import application.eling.domain.Posologie;
import application.repository.DMPRepository;
import application.repository.DiagnostiqueDAO;
import application.repository.EmployeRepository;





@Path("/diagnostiques")
public class DiagnostiqueRestService {

		@EJB
	    private DiagnostiqueDAO diagnostiqueDAO = new DiagnostiqueDAO();
		
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
	            return Response.status(Response.Status.FORBIDDEN).build();
	        }
	        return Response.noContent().build();
	    
	    }
	    @POST
		@Path("update")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateExam(Diagnostique diag) {
			try {
				diagnostiqueDAO.update(diag);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.noContent().build();

		}
		@POST
		@Path("deletezer")
		@Produces(MediaType.APPLICATION_JSON)
		public Response deletezer(Diagnostique diag) {
			try {
				diagnostiqueDAO.update(diag);
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
				exam = diagnostiqueDAO.create(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        URI bookUri = uriInfo.getBaseUriBuilder().path(DiagnostiqueRestService.class).path(String.valueOf(exam.getId())).build();
	        return Response.ok(exam).build();
	    }
	    
	    @POST
	    @Path("linkDMP")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkDMPToExamen(@FormDataParam("diagnostique") Integer id_exam, @FormDataParam("dmp") Integer id_dmp) {
	    	DMP dmp = dmpDAO.find(id_dmp);
	    	Diagnostique exam = diagnostiqueDAO.get(id_exam);
	    	try {
				exam.setDmp(dmp);
				exam = diagnostiqueDAO.update(exam);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(exam).build();
	    }
	    
	    @POST
	    @Path("linkRes")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response linkResToExamen(@FormDataParam("diagnostique") Integer id_intervention, @FormDataParam("res") Integer id_dmp) {
	    	Employe res = employeDAO.find(id_dmp);
	    	Diagnostique intervention = diagnostiqueDAO.get(id_intervention);
	    	try {
				intervention.setResponsable(res);
				intervention = diagnostiqueDAO.update(intervention);
			} catch (Exception e) {
				return Response.status(Response.Status.NOT_ACCEPTABLE).build();
			}
	        return Response.ok(intervention).build();
	    }
	
}
