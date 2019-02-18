/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

/**
 *
 * @author df.perezc
 */

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionParticipanteDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("animacionesParticipantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimacionParticipante {
    
    @POST
    public AnimacionParticipanteDTO crearAnimacion(AnimacionParticipanteDTO animacionParticipante){
        return animacionParticipante;
    }
     @GET
    @Path("{animacionParticipanteId: \\d+}")
    public AnimacionDTO getAnimacion(@PathParam("animacionParticipanteId") Long animacionParticipanteID){
        return null;
    }
}
