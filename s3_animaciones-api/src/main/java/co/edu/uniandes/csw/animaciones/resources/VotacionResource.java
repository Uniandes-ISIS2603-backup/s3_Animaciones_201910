/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.VotacionDTO;
import co.edu.uniandes.csw.animaciones.ejb.VotacionLogic;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    @Inject
    private VotacionLogic vl;
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
    public VotacionDTO crearVotacion(VotacionDTO votacion) throws BusinessLogicException{
        VotacionEntity ve = votacion.toEntity();
        vl.createVotacion(ve);
        return new VotacionDTO(ve);
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
