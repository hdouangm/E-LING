package application.security;

import application.domain.CompteAphp;
import application.domain.DonneesSociales;
import application.domain.Employe;
import application.repository.EmployeRepository;
import application.security.utils.KeyGenerator;
import application.security.utils.LoggerProducer;
import application.security.utils.SimpleKeyGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;


import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

    // ======================================
    // =          Injection Points          =
    // ======================================

  // @Inject
    private Logger logger = Logger.getAnonymousLogger();
    
    @EJB
    private EmployeRepository eRepository;

    // ======================================
    // =          Business methods          =
    // ======================================

  @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        logger.info("#### authorizationHeader : " + authorizationHeader);

        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.severe("#### invalid authorizationHeader : " + authorizationHeader);
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {

            // Validate the token
            Key key = new SimpleKeyGenerator().generateKey();
            //JwtParser parser = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            JwtParser parser = Jwts.parser().setSigningKey(key);
            Jws<Claims> claims = parser.parseClaimsJws(token);
            String login = claims.getBody().getSubject();
            Employe currentUser = (Employe) eRepository.findByLogin(login);
            logger.info("#### valid token : " + token);
            logger.info("#### valid employe : ");
            
        } catch (Exception e) {
            logger.severe("#### invalid token : " + token);
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}