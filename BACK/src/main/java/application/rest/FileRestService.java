package application.rest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;

import application.eling.domain.ExamenDAO;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.sun.corba.ee.spi.ior.Writeable;


@Path("/file")
public class FileRestService {

	@Context
    private UriInfo uriInfo;
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload")
    public Response uploadFile(@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataContentDisposition fileDetail, @FormDataParam("dir") String dir) throws IOException{
		if(!Files.exists(Paths.get("upload")))
			new File("upload").mkdir();
		if(!Files.exists(Paths.get("upload/"+dir)))
			new File("upload/"+dir).mkdir();
		if(Files.exists(Paths.get("upload"))){}
		  try {  
              FileOutputStream out = new FileOutputStream(new File("./upload/"+dir+"/"+fileDetail.getFileName()));
              int read = 0;  
              byte[] bytes = new byte[1024];    
              while ((read = file.read(bytes)) != -1) {  
                  out.write(bytes, 0, read);  
              }  
              out.flush();  
              out.close();  
          } catch (IOException e) {
        	  e.printStackTrace();
        	  return Response.serverError().build();
        }  
            return Response.ok().build();
      
    }
 
    @POST
    @Path("download")
    @Produces("image/png")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response downloadFileWithPost(@FormDataParam("dir") String dir, @FormDataParam("name") String name) {
        /*String path = System.getProperty("user.home") + File.separator + "uploads";
        File fileDownload = new File(path + File.separator + file);
        ResponseBuilder response = Response.ok((Object) fileDownload);
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build();*/
    	File file = new File("./upload/"+dir+"/"+name);
    	ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename="+name);
        
    	try {
			return Response.ok(new FileInputStream(file)).build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
    	
    }
    
    @GET
    @Path("download/Examen{examID}")
    @Produces("image/png")
    public Response getResultByExamenId(@PathParam("examID") Integer id) {
    	File file = new File("./upload/"+"examen"+id+"/"+new ExamenDAO().get(id).getResultats());
    	ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename="+new ExamenDAO().get(id).getResultats());
        
    	try {
			return Response.ok(new FileInputStream(file)).build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
    }
    
    @GET
    @Path("download/Intervention{interventionID}")
    @Produces("image/png")
    public Response getResultByInterventionId(@PathParam("interventionID") Integer id) {
    	File file = new File("./upload/"+"intervention"+id+"/"+new ExamenDAO().get(id).getResultats());
    	ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename="+new ExamenDAO().get(id).getResultats());
        
    	try {
			return Response.ok(new FileInputStream(file)).build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
    }
 
 
}