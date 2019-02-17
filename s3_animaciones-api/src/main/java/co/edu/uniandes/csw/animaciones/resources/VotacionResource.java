/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.VotacionDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author df.serrano
 */
@Path("votaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
/**
 *
 * @author estudiante
 */
public class VotacionResource {
    private static final Logger LOGGER = Logger.getLogger(VotacionResource.class.getName());
    
    @GET
    public List <VotacionDTO> darVotaciones(){
        return null;
    }
    
    @GET
    @Path("{votacionId: \\d+}")
    public VotacionDTO darVotacion(@PathParam("votacionId") Long votacionId){
        return null;
    }    
    @POST
    public VotacionDTO crearVotacion(VotacionDTO votacion) {
        return votacion;
    }
    @PUT
    @Path("{votacionId: \\d+}")
    public VotacionDTO cambiarVotacion(@PathParam("votacionId") Long votacionId, VotacionDTO votacion ){
        return votacion;
    }
    @DELETE
    @Path("{votacionId: \\d+}")
    public VotacionDTO eliminarVotacion(@PathParam("votacionId") Long votacionId){
        return null;
    }
}
