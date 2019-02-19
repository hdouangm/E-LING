/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.responsableLaboratoire.rest;

import application.responsableLaboratoire.domain.Agenda;
import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Reda Amhaouch
 */
@Path("/agenda")
public class AgendaRestService {
     @Context
    private UriInfo uriInfo;
    
     @GET
    @Path("/link")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgendaLink() {
        URI uri = uriInfo.getBaseUriBuilder().path(Agenda.getAgendaLink()).build();
        return Response.ok(Agenda.getAgendaLink()).build();
    }
    
    
}
