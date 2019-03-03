package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.CalificacionDTO;
import co.edu.uniandes.csw.animaciones.ejb.AnimacionCalificacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.AnimacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.CalificacionLogic;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
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
    
    @POST
    public AnimacionDTO crearAnimacion(AnimacionDTO animacion) throws BusinessLogicException{
        AnimacionDTO re = new AnimacionDTO(animacionl.createAnimacion(animacion.toEntity()));
        return re;
    }
    
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
    
    @GET
    public ArrayList<AnimacionDetailDTO> getAnimaciones(){
        ArrayList<AnimacionDetailDTO> re = AnimacionEntity2DetailDTO(animacionl.getAnimaciones());
        return re;
    }
    
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
    
    @DELETE
    @Path("{animacionId: \\d+}")
    public void deleteAnimacion(@PathParam("animacionId") Long animacionID){
        AnimacionEntity re = animacionl.getAnimacion(animacionID);
        if(re == null){
            throw new WebApplicationException("La nimacion no existe",404);
        }
        animacionl.deleteAnimacion(animacionID);
    }
    
    @POST
    @Path("{animacionId: \\d+}/calificaciones/{calificacionId: \\d+}")
    public CalificacionDTO addCalificacion(@PathParam("animacionId") Long animacionID, @PathParam("calificacionId") Long calificacionID){
        return null;
    }
    
    @GET
    @Path("{animacionId: \\d+}/calificaciones/{calificacionId: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("animacionId") Long animacionID, @PathParam("calificacionId") Long calificacionID){
        return null;
    }
    
    @GET
    @Path("{animacionId: \\d+}/calificaciones")
    public ArrayList<CalificacionDTO> getCalificaciones(@PathParam("animacionId") Long animacionID){
        return null;
    }
    
    @DELETE
    @Path("{animacionId: \\d+}/calificaciones/{calificacionId: \\d+}")
    public void deleteCalifiacion(@PathParam("animacionId") Long animacionID, @PathParam("calificacionId") Long calificacionID){
        
    }
    
    private ArrayList<AnimacionDetailDTO> AnimacionEntity2DetailDTO(List<AnimacionEntity> list){
        ArrayList<AnimacionDetailDTO> re = new ArrayList<>();
        for(AnimacionEntity ae: list){
            re.add(new AnimacionDetailDTO(ae));
        }
        return re;
    }
    
}
