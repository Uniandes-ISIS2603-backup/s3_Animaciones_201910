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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * recurso que maneja el recurso de la animacion que participa en un concurso
 */

@Path("animacionesParticipantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimacionParticipanteResource {
    

    /**
     * metodo que publica una animacion
     * @param animacionParticipante DTO de la animacion que va a ser publicada
     * @return el DTO de la animacion que se crea
     */
    @POST
    public AnimacionParticipanteDTO crearAnimacionParticipante(AnimacionParticipanteDTO animacionParticipante){
        return animacionParticipante;
    }
   
     /**
      * las animaciones participantes de un concurso
      * @return lista de dtos de animaciones participantes
      */
    @GET
    public List<AnimacionParticipanteDTO> getAnimacionesParticipantes() {
        return null;
    }
    
    /**
     * metodo que retorna una animacion participante
     * @param animacionParticipanteId el id de la animacion buscada
     * @return  dto de la animacion buscada
     */
    @GET
    @Path("{animacionParticipanteId: \\+d}")
    public AnimacionParticipanteDTO getAnimacionParticipante( @PathParam("animacionParticipanteId") Long animacionParticipanteId) {
        return null;
    }
    
    /**
     * metodo que actualiza una animacion participante
     * @param animacionParticipanteId el id de la animacion participante
     * @param animacionParticipanteDTO la animacion participante con las actualizaciones
     * @return la animacionParticipante ya actualizada
     */
    @PUT
    @Path("{animacionParticipanteId: \\+d}")
    public AnimacionParticipanteDTO updateAnimacionParticipante( @PathParam("animacionParticipanteId") Long animacionParticipanteId, AnimacionParticipanteDTO animacionParticipanteDTO) {
        return animacionParticipanteDTO;
    }
   
    /**
     * metodo que borra la animacion correspondiente al id que se le ingrese
     * @param animacionParticipanteId es el id de la animacion que se quiere eliminar del concurso
     */
    @DELETE
    @Path("{animacionParticipanteId: \\+d}")
    public void deleteAnimacionParticipante( @PathParam("animacionParticipanteId") Long animacionParticipanteId) {
       
    }

}
