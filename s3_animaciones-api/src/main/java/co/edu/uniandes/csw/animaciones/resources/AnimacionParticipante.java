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
import javax.ws.rs.PUT;
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
   /*
     * @param concursoId
     * @param animacionParticipanteId
     * @param puntaje
     * @return
     */
    @POST
    @Path("{animacionParticipanteId: \\+d}")
    public Long puntuarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionParticipanteId, Double puntaje) {
        return animacionParticipanteId;
    }

    @PUT
    @Path("{animacionParticipanteId: \\+d}")
    public Long updateRankAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionParticipanteId) {
        return animacionParticipanteId;
    }
    
    @GET
    @Path("{animacionParticipanteId: \\+d}")
    public AnimacionParticipanteDTO getAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionParticipanteId) {
        return null;
    }

     /**
     *
     * @param concursoId
     * @param rondaId
     * @param animacionParticipanteId
     * @param dinero
     * @return
     */
    /**
    @POST
    @Path("{concursoId: \\d+}/rondas/{ronda: \\d+}/animacionesParticipantesId/{animacionParticipanteId: \\+d}")
    public Long premiarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionParticipanteId, Integer dinero) {
        return animacionParticipanteId;
    }
    */
}
