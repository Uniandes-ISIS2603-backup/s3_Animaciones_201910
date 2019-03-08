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

import co.edu.uniandes.csw.animaciones.dtos.AnimacionParticipanteDTO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("animacionesParticipantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimacionParticipanteResource {
    

    @POST
    public AnimacionParticipanteDTO crearAnimacionParticipante(AnimacionParticipanteDTO animacionParticipante){
        return animacionParticipante;
    }
   
     
    @GET
    public List<AnimacionParticipanteDTO> getAnimacionesParticipantes() {
        return null;
    }
    
    @GET
    @Path("{animacionParticipanteId: \\+d}")
    public AnimacionParticipanteDTO getAnimacionParticipante( @PathParam("animacionParticipanteId") Long animacionParticipanteId) {
        return null;
    }
    
    @PUT
    @Path("{animacionParticipanteId: \\+d}")
    public AnimacionParticipanteDTO updateAnimacionParticipante( @PathParam("animacionParticipanteId") Long animacionParticipanteId, AnimacionParticipanteDTO animacionParticipanteDTO) {
        return animacionParticipanteDTO;
    }
   

}
