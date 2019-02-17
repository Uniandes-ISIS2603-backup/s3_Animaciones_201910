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
    
   @GET
    public List <MedioDePagoDTO> darMediosDePago(){
        return null;
    }
    
    @GET
    @Path("{medioDePagoId: \\d+}")
    public MedioDePagoDTO darMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId){
        return null;
    }    
    @POST
    public MedioDePagoDTO crearMedioDePago(MedioDePagoDTO medioDePago) {
        return medioDePago;
    }
    @PUT
       @Path("{medioDePagoIdId: \\d+}")
    public MedioDePagoDTO cambiarMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId, MedioDePagoDTO medioDePago){
        return medioDePago;
    }
    @DELETE
    @Path("{medioDePagoIdId: \\d+}")
    public MedioDePagoDTO eliminarMedioDePago(@PathParam("medioDePagoId") Long medioDePagoId){
        return null;
    }

}