/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionGanadoraDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.logging.Logger;

/**
 *
 * @author by.cuta10
 */
@Path("animacion_ganadora")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimacionGanadoraResource {
    
    private static final Logger  LOGGER=Logger.getLogger(AnimacionGanadoraResource.class.getName());
            
    @GET
    @Path("concursos/{id1: \\d+}/animacionesGanadoras/{id2: \\d+}")
    public AnimacionGanadoraDTO getAnimacionesGanadoras (@PathParam("id1")Long id1, @PathParam("id2")Long id2){
        return new AnimacionGanadoraDTO() ;
    }
    
    @GET
    @Path("concursos/{id1: \\d+}/animacionesGanadoras")
    public AnimacionGanadoraDTO getAnimacionesGanadoras (@PathParam("id1")Long id1){
        return new AnimacionGanadoraDTO() ;
    }
    
    @POST
    @Path("concursos/{id1: \\d+}/animacionesGanadoras")
    public String  postAnimacionesGanadoras (@PathParam("id1")Long id1){
    String n ="Verificacion";
    return n;
    }
    
    @DELETE
    @Path("concursos/{id1: \\d+}/animacionesGanadoras/{id2: \\d+}")
    public AnimacionGanadoraDTO deleteAnimacionesGanadoras (@PathParam("id1")Long id1,@PathParam("id2")Long id2){
        return new AnimacionGanadoraDTO() ;
    }
    
    
    
}
