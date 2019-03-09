/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.MedioDePagoDTO;
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
@Path("mediosDePago")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MedioDePagoResource {
    private static final Logger LOGGER = Logger.getLogger(MedioDePagoResource.class.getName());
    /**
     * Retorna los medios de pago
     * @return Lista de medios de pago
     */
    @GET
    public List <MedioDePagoDTO> darMediosDePago(){
        return null;
    }
    /**
     * Obtiene un medio de pago
     * @param medioDePagoId
     * @return MedioDePagoDTO retorna el medio de pago dado
     */
    @GET
    @Path("{medioDePagoId: \\d+}")
    public MedioDePagoDTO darMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId){
        return null;
    }    
    /**
     * Crea un nuevo pago
     * @param medioDePago
     * @return MedioDePagoDTO returna el medio de pago creado
     */
    @POST
    public MedioDePagoDTO crearMedioDePago(MedioDePagoDTO medioDePago) {
        return medioDePago;
    }
    /**
     * Cambio un medio de pago
     * @param medioDePagoId
     * @param medioDePago
     * @return MediodePago que fue cambiado 
     */
    @PUT
       @Path("{medioDePagoIdId: \\d+}")
    public MedioDePagoDTO cambiarMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId, MedioDePagoDTO medioDePago){
        return medioDePago;
    }
    /**
     * Elmina un medio de pago
     * @param medioDePagoId
     * @return  MedioDePago
     */
    @DELETE
    @Path("{medioDePagoIdId: \\d+}")
    public MedioDePagoDTO eliminarMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId){
        return null;
    }

}