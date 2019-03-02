package application.eling.rest;

import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.media.multipart.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("/upload")
public class UploadRestService {
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("file") InputStream is,
                               @FormDataParam("file") FormDataContentDisposition formData) {
        String fileLocation = "../" + formData.getFileName();
        try {
            saveFile(is, fileLocation);
            String result = "Successfully File Uploaded on the path "+fileLocation;
            return Response.ok(result).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.ok(true).build();
        }
    }
    private void saveFile(InputStream is, String fileLocation) throws IOException {
        OutputStream os = new FileOutputStream(new File(fileLocation));
        byte[] buffer = new byte[256];
        int bytes = 0;
        while ((bytes = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytes);
        }
    }

}
