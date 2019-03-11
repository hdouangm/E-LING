/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.security;


import application.eling.domain.Employe;
import application.repository.EmployeRepository;
import application.security.utils.Role;
import application.security.utils.SimpleKeyGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author asus
 */

@RoleNeeded
@Provider
@Priority(Priorities.AUTHORIZATION)
public class RoleNeededFilter implements ContainerRequestFilter {

    private Logger logger = Logger.getAnonymousLogger();
    
    @EJB
    private EmployeRepository eRepository;
    @Context
    private ResourceInfo resourceInfo;
    
     @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        // Get the resource class which matches with the requested URL
        // Extract the roles declared by it
        Class<?> resourceClass = resourceInfo.getResourceClass();
         List<Role> classRoles = extractRoles(resourceClass);

        // Get the resource method which matches with the requested URL
        // Extract the roles declared by it
        Method resourceMethod = resourceInfo.getResourceMethod();
        List<Role> methodRoles = extractRoles(resourceMethod);
        
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
            Employe employe = (Employe) eRepository.findByLogin(login);
            
            // Check if the user is allowed to execute the method
            // The method annotations override the class annotations
            if (methodRoles.isEmpty()) {
                checkPermissions(classRoles,employe);
                logger.info("#### checkPermissions(classRoles) : " + classRoles.toString());
            } else {
                logger.info("#### checkPermissions(methodRoles) : " + methodRoles.toString());
                checkPermissions(methodRoles,employe);
                
                
            }

        } catch (Exception e) {
            requestContext.abortWith(
                Response.status(Response.Status.FORBIDDEN).build());
        }
    }

    // Extract the roles from the annotated element
    private List<Role> extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return new ArrayList<Role>();
        } else {
            RoleNeeded secured = annotatedElement.getAnnotation(RoleNeeded.class);
            if (secured == null) {
                return new ArrayList<Role>();
            } else {
                Role[] allowedRoles = secured.value();
                return Arrays.asList(allowedRoles);
            }
        }
    }

    private void checkPermissions(List<Role> allowedRoles,Employe employe) throws Exception {
        // Check if the user contains one of the allowed roles
        for(Role role : allowedRoles) {
            if(role != Role.DATAMANAGER && employe.getNiveau()==5) 
                 throw new NotAuthorizedException("Role must match provided");
             if(role != Role.LABORATIN && employe.getNiveau()==4) 
                  throw new NotAuthorizedException("Role must match provided");
             if(role != Role.INFIRMIERE && employe.getNiveau()==3) 
                  throw new NotAuthorizedException("Role must match provided");
             if(role != Role.SECRETAIRE_MEDICAL && employe.getNiveau()== 2) 
                  throw new NotAuthorizedException("Role must match provided");
             if(role != Role.MEDECIN && employe.getNiveau()==1) 
                  throw new NotAuthorizedException("Role must match provided");
             else return;
        }
        // Throw an Exception if the user has not permission to execute the method
         // throw new NotAuthorizedException("Role must be provided");
        
    }
}
    

