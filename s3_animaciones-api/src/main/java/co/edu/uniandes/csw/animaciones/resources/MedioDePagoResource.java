/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.EstadoDTO;
import co.edu.uniandes.csw.animaciones.dtos.MedioDePagoDTO;
import co.edu.uniandes.csw.animaciones.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
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
 * @author by.cuta
 */
@Path("mediosDePago")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MedioDePagoResource {
    private static final Logger LOGGER = Logger.getLogger(MedioDePagoResource.class.getName());
    @Inject
    private MedioDePagoLogic medioDePagoLogic ;
    /**
     * Retorna los medios de pago
     * @return Lista de medios de pago
     */
    @GET
    @Path("all")
    public List <MedioDePagoDTO> darMediosDePago(){
        List<MedioDePagoDTO> n = new ArrayList<>();
        List<MedioDePagoEntity> n2 =  medioDePagoLogic.getAll();
        if(n2 != null){
            for (MedioDePagoEntity a : n2){
            n.add(new MedioDePagoDTO(a));
        }
        }
        return n;
    }
    /**
     * Obtiene un medio de pago
     * @param medioDePagoId
     * @return MedioDePagoDTO retorna el medio de pago dado
     */
    @GET
    @Path("{medioDePagoId: \\d+}")
    public MedioDePagoDTO darMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId){
        MedioDePagoEntity mdpe = medioDePagoLogic.getMedioDePago(medioDePagoId);
        if(mdpe == null)
        {
            throw new WebApplicationException("Medio de Pago with id: " + medioDePagoId + " does not exists", 404);
        }
        return new MedioDePagoDTO(mdpe);

    }    
    /**
     * Crea un nuevo pago
     * @param medioDePago
     * @return MedioDePagoDTO returna el medio de pago creado
     */
    @POST
    public MedioDePagoDTO crearMedioDePago(MedioDePagoDTO medioDePago) throws BusinessLogicException {
        return new MedioDePagoDTO( medioDePagoLogic.createMedioDePago(medioDePago.toEntity()));
    }
    /**
     * Cambio un medio de pago
     * @param medioDePagoId
     * @param medioDePago
     * @return MediodePago que fue cambiado 
     */
    @PUT
       @Path("{medioDePagoId: \\d+}")
    public MedioDePagoDTO cambiarMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId, MedioDePagoDTO medioDePago){

        MedioDePagoEntity mdpe = medioDePagoLogic.getMedioDePago(medioDePagoId);
        if(mdpe == null)
        {
            throw new WebApplicationException("Medio de Pago with id: " + medioDePagoId + " does not exists", 404); 
        }
        MedioDePagoEntity mdpe2 = medioDePagoLogic.updateMedioDePago(medioDePagoId, medioDePago.toEntity());
        return new MedioDePagoDTO(mdpe2);

    }
    /**
     * Elmina un medio de pago
     * @param medioDePagoId
     * @return  MedioDePago
     */
    @DELETE
    @Path("{medioDePagoIdId: \\d+}")

    public void eliminarMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId){
               MedioDePagoEntity mdpe = medioDePagoLogic.getMedioDePago(medioDePagoId);
        if(mdpe == null)
        {
            throw new WebApplicationException("Medio de Pago with id: " + medioDePagoId + " does not exists", 404); 
        }

       medioDePagoLogic.deleteMedioDePago(medioDePagoId);
       //return new EstadoDTO("Eliminado Medio de Pago");
    }

}