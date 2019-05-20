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
import co.edu.uniandes.csw.animaciones.ejb.AnimacionParticipanteLogic;
import co.edu.uniandes.csw.animaciones.entities.AnimacionParticipanteEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 * recurso que maneja el recurso de la animacion que participa en un concurso
 */
@Path("animacionesParticipantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimacionParticipanteResource {

    @Inject
    private AnimacionParticipanteLogic apl;

    /**
     * metodo que publica una animacion
     *
     * @param animacionParticipante DTO de la animacion que va a ser publicada
     * @return el DTO de la animacion que se crea
     */
    @POST
    public AnimacionParticipanteDTO crearAnimacionParticipante(AnimacionParticipanteDTO animacionParticipante) {
        AnimacionParticipanteDTO apd = new AnimacionParticipanteDTO(apl.create(animacionParticipante.toEntity()));
        return apd;
    }

    /**
     * las animaciones participantes de un concurso
     *
     * @return lista de dtos de animaciones participantes
     */
    @GET
    public ArrayList<AnimacionParticipanteDTO> getAnimacionesParticipantes() {
        ArrayList<AnimacionParticipanteDTO> re = listEntityToListDetail(apl.findAll());
        return re;
    }

    /**
     * metodo que retorna una animacion participante
     *
     * @param animacionParticipanteId el id de la animacion buscada
     * @return dto de la animacion buscada
     */
    @GET
    @Path("{animacionParticipanteId: \\d+}")
    public AnimacionParticipanteDTO getAnimacionParticipante(@PathParam("animacionParticipanteId") Long animacionParticipanteId) {
        AnimacionParticipanteEntity ape = apl.find(animacionParticipanteId);
        if (ape == null) {
            throw new WebApplicationException("La no está inscrita en ningunconcurso", 404);
        }
        AnimacionParticipanteDTO apd = new AnimacionParticipanteDTO(ape);
        return apd;
    }

    /**
     * metodo que actualiza una animacion participante
     *
     * @param animacionParticipanteId el id de la animacion participante
     * @param animacionParticipanteDTO la animacion participante con las
     * actualizaciones
     * @return la animacionParticipante ya actualizada las animaciones no se
     * deben modificar una vez han sido inscritas
     */
    @PUT
    @Path("{animacionParticipanteId: \\+d}")
    public AnimacionParticipanteDTO updateAnimacionParticipante(@PathParam("animacionParticipanteId") Long animacionParticipanteId, AnimacionParticipanteDTO animacionParticipanteDTO) throws BusinessLogicException{ 
        animacionParticipanteDTO.setId(animacionParticipanteId);
        if (apl.find(animacionParticipanteId) == null) {
            throw new WebApplicationException("La animacion no está inscrita", 404);
        }
        AnimacionParticipanteDTO apd = new AnimacionParticipanteDTO(apl.update(animacionParticipanteDTO.toEntity()));
        return apd;
    }

    /**
     * metodo que borra la animacion correspondiente al id que se le ingrese
     *
     * @param animacionParticipanteId es el id de la animacion que se quiere
     * eliminar del concurso
     *
     * @DELETE
     * @Path("{animacionParticipanteId: \\+d}") public void
     * deleteAnimacionParticipante( @PathParam("animacionParticipanteId") Long
     * animacionParticipanteId) { AnimacionParticipanteEntity ape =
     * apl.find(animacionParticipanteId); if(ape == null){ throw new
     * WebApplicationException("La animacion no está inscrita",404); }
     * apl.delete(animacionParticipanteId); }
     */
    
    /**
     * 
     * @param list
     * @return 
     */
    private ArrayList<AnimacionParticipanteDTO> listEntityToListDetail(List<AnimacionParticipanteEntity> list) {
        ArrayList<AnimacionParticipanteDTO> apList = new ArrayList<>();
        for (AnimacionParticipanteEntity ape : list) {
            apList.add(new AnimacionParticipanteDTO(ape));
        }
        return apList;
    }
}
