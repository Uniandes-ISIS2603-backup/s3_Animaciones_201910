package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.CalificacionDTO;
import co.edu.uniandes.csw.animaciones.ejb.AnimacionCalificacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.AnimacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.CalificacionLogic;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 *
 * @author Nicolas Alvarado
 */
@Path("animaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimacionResource {
    
    @Inject
    private AnimacionLogic animacionl;
    
    @Inject
    private CalificacionLogic calificacionl;
    
    @Inject
    private AnimacionCalificacionLogic acl;
    
    /**
     * Metodo para crear una Animacion
     * @param animacion, la animacion que se quiere crear
     * @return La animacion que se creo
     * @throws BusinessLogicException 
     */
    @POST
    public AnimacionDTO crearAnimacion(AnimacionDTO animacion) throws BusinessLogicException{
        AnimacionDTO re = new AnimacionDTO(animacionl.createAnimacion(animacion.toEntity()));
        return re;
    }
    
    /**
     * Metodo para obtener una animacion
     * @param animacionID, id de la animacion que se quiere obtener
     * @return La animacion deseada
     */
    @GET
    @Path("{animacionId: \\d+}")
    public AnimacionDetailDTO getAnimacion(@PathParam("animacionId") Long animacionID){
        AnimacionEntity ae = animacionl.getAnimacion(animacionID);
        if(ae == null){
            throw new WebApplicationException("La animacion no existe",404);
        }
        AnimacionDetailDTO re = new AnimacionDetailDTO(ae);
        return re;
    }
    
    /**
     * Metodo para obtener todas las animaciones
     * @return Todas las animaciones
     */
    @GET
    public ArrayList<AnimacionDetailDTO> getAnimaciones(){
        ArrayList<AnimacionDetailDTO> re = AnimacionEntity2DetailDTO(animacionl.getAnimaciones());
        return re;
    }
    
    /**
     * Metodo para actualizar una animacion
     * @param animacionID, id de la animacion que se quiere actualizar
     * @param adto, la nueva informacion de la animacion
     * @return La animacion con la nueva informacion
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{animacionId: \\d+}")
    public AnimacionDTO updateAnnimacion(@PathParam("animacionId") Long animacionID, AnimacionDTO adto) throws BusinessLogicException{
        adto.setId(animacionID);
        if(animacionl.getAnimacion(animacionID) == null){
            throw new WebApplicationException("La animacion no existe",404);
        }
        AnimacionDTO re = new AnimacionDTO(animacionl.updateAnimacion(adto.toEntity()));
        return re;
    }
    
    /**
     * Metodo para eliminar una animacion
     * @param animacionID, id de la annimacion que se quiere eliminar 
     */
    @DELETE
    @Path("{animacionId: \\d+}")
    public void deleteAnimacion(@PathParam("animacionId") Long animacionID){
        AnimacionEntity re = animacionl.getAnimacion(animacionID);
        if(re == null){
            throw new WebApplicationException("La nimacion no existe",404);
        }
        animacionl.deleteAnimacion(animacionID);
    }
    
    @GET
    @Path("{animacionId: \\d+}/calificaciones/{calificacionId: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("animacionId") Long animacionID, @PathParam("calificacionId") Long calificacionID){
        CalificacionEntity ce = calificacionl.getCalificacion(animacionID,calificacionID);
        if(ce == null){
            throw new WebApplicationException("La califiocacion no existe",404);
        }
        CalificacionDTO re = new CalificacionDTO(acl.getAimacion(animacionID, calificacionID));
        return re;
    }
    
    @GET
    @Path("{animacionId: \\d+}/calificaciones")
    public ArrayList<CalificacionDTO> getCalificaciones(@PathParam("animacionId") Long animacionID){
        ArrayList<CalificacionDTO> list = CalificacionEntity2DTO(acl.getAnimaciones(animacionID));
        if(list == null){
            throw new WebApplicationException("La animacion no existe",404);
        }
        return list;
    }
    
    @POST
    @Path("{animacionId: \\d+}/calificaciones")
    public CalificacionDTO createCalificacion(@PathParam("animacionId") Long animacionId, CalificacionDTO calificacion) throws BusinessLogicException {
        CalificacionDTO nuevoCalificacionDTO = new CalificacionDTO(acl.addCalificacion( animacionId, calificacion.toEntity()));
        return nuevoCalificacionDTO;
    }
    
    @PUT
    @Path("{animacionId: \\d+}/calificaciones/{calificacionId: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("animacionId") Long animacionId, @PathParam("calificacionId") Long calificacionId, CalificacionDTO calificacion){
        calificacion.setId(calificacionId);
        CalificacionDTO nueva = new CalificacionDTO(acl.update(calificacion.toEntity()));
        return nueva;
    }
    
    @DELETE
    @Path("{animacionId: \\d+}/calificaciones/{calificacionId: \\d+}")
    public void deleteCalifiacion(@PathParam("animacionId") Long animacionID, @PathParam("calificacionId") Long calificacionID){
        CalificacionEntity ce = calificacionl.getCalificacion(animacionID,calificacionID);
        if(ce == null){
            throw new WebApplicationException("La califiocacion no existe",404);
        }
        acl.deleteCalificacion(animacionID, calificacionID);
    }
    
    private ArrayList<AnimacionDetailDTO> AnimacionEntity2DetailDTO(List<AnimacionEntity> list){
        ArrayList<AnimacionDetailDTO> re = new ArrayList<>();
        for(AnimacionEntity ae: list){
            re.add(new AnimacionDetailDTO(ae));
        }
        return re;
    }
    
    private ArrayList<CalificacionDTO> CalificacionEntity2DTO(List<CalificacionEntity> list){
        ArrayList<CalificacionDTO> re = new ArrayList<>();
        for(CalificacionEntity ce: list){
            re.add(new CalificacionDTO(ce));
        }
        return re;
    }
    
}
