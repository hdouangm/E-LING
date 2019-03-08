package application.rest;


import application.security.JWTTokenNeeded;
import application.security.RoleNeeded;
import application.security.utils.KeyGenerator;
import application.security.utils.Role;
import application.security.utils.SimpleKeyGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import javax.ws.rs.core.UriInfo;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/echo")
@Produces(TEXT_PLAIN)
public class EchoEndpoint {

    // ======================================
    // =          Injection Points          =
    // ======================================

   // @Inject
    private Logger logger;
   @Context
    private UriInfo uriInfo;
    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response echo(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
    
     private String issueToken(String login) {
         Key key =  new SimpleKeyGenerator().generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }
     
      private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    @GET
    @Path("/test/{message}")
    public Response echo1(@PathParam("message") String message) {
         return Response.ok().entity(issueToken(message)).build();//.header(AUTHORIZATION, "Bearer " + issueToken(message)).build();
    }

    @GET
    @Path("jwt")
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
}
