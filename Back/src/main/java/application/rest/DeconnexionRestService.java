/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.rest;

import application.security.JWTTokenNeeded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author asus
 */
@Path("/Deconnexion")
@JWTTokenNeeded
public class DeconnexionRestService {
    
    @GET
    @JWTTokenNeeded
    @Produces(MediaType.APPLICATION_JSON)
    public Response deconnexion() {
            //jwt
          return  Response.ok().build();
     }
}
