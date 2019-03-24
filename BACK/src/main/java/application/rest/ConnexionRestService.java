package application.rest;

import application.eling.domain.CompteAphp;
import application.eling.domain.Employe;
import application.repository.CompteAphpRepository;
import application.repository.EmployeRepository;
import application.security.utils.KeyGenerator;
import application.security.utils.SimpleKeyGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import javax.ws.rs.core.UriInfo;
import javax.json.*;


@Path("/Connexion")
public class ConnexionRestService {
		
    @EJB
    private CompteAphpRepository repository;
    private EmployeRepository eRepository;
    
    @Context
    private UriInfo uriInfo;
    
    
     // ======================================
    // =          Injection Points          =
    // ======================================
   // @Inject
    private Logger logger;

    //@Inject
    private KeyGenerator keyGenerator;

    // ======================================
    // =          Business methods          =
    // ======================================

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response connexion(CompteAphp compte) {
        List<CompteAphp> comptes = repository.find(compte.getLogin(),compte.getMotDePasse());
	if(comptes.isEmpty()) return null;;
         // Issue a token for the user
         String token = issueToken(compte.getLogin());
         //return Response.ok(token).header(AUTHORIZATION, "Bearer " + token).build();
          //return Response.ok().entity(token).build();
         // return Response.ok(token).build();
        try{
            JsonObjectBuilder o =Json.createObjectBuilder();
            o.add("token", token);
           return Response.ok(token).build();
          //r
        }catch(Exception e)  {
            return null;
        }
       
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("calendar")
    public Response getCalendar(String login) {
        CompteAphp comptes = repository.find(login);
        if(comptes != null){
            return  Response.ok(comptes).build();


        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    //ok
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

}

 

    

