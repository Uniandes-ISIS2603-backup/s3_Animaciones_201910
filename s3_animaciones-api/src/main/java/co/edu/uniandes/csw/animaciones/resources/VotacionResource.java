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
import java.util.ArrayList;
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
import javax.ws.rs.WebApplicationException;
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
 * @author df.serrano
 */
public class VotacionResource {
    private static final Logger LOGGER = Logger.getLogger(VotacionResource.class.getName());
    @Inject
    private VotacionLogic vl;
    @GET
    public List <VotacionDTO> darVotaciones(){
        List <VotacionEntity> lista = vl.getVotaciones();
        if(lista == null)
        {
            throw new WebApplicationException("La lista no existe", 404);
        }
        return convertir(lista);
    }
    
    @GET
    @Path("{votacionId: \\d+}")
    public VotacionDTO darVotacion(@PathParam("votacionId") Long votacionId){
        VotacionEntity ve = vl.getVotacion(votacionId);
        if(ve == null)
        {
            throw new WebApplicationException("La votacion no existe", 404);
        }
        return new VotacionDTO(ve);
    }    
    @POST
    public VotacionDTO crearVotacion(VotacionDTO votacion) throws BusinessLogicException{
        VotacionEntity ve = votacion.toEntity();
        vl.createVotacion(ve);
        return new VotacionDTO(ve);
    }
    @PUT
    @Path("{votacionId: \\d+}")
    public VotacionDTO cambiarVotacion(@PathParam("votacionId") Long votacionId, VotacionDTO votacion ) throws BusinessLogicException{
        VotacionEntity ve = vl.getVotacion(votacionId);
        if(ve == null)
        {
            throw new WebApplicationException("La votacion no existe", 404);
        }
        votacion.setId(votacionId);
        return new VotacionDTO (vl.updateVotacion(votacion.toEntity()));
    }
    @DELETE
    @Path("{votacionId: \\d+}")
    public void eliminarVotacion(@PathParam("votacionId") Long votacionId){
        VotacionEntity ve = vl.getVotacion(votacionId);
        if(ve == null)
        {
             throw new WebApplicationException("La votacion no existe",404);
        }
        vl.deleteVotacion(votacionId);

      }
    
        private List<VotacionDTO> convertir(List<VotacionEntity> lista){
        List<VotacionDTO> aRetornar = new ArrayList();
        for(VotacionEntity ve : lista){
            aRetornar.add(new VotacionDTO(ve));
        }
        return aRetornar;
    }
}
