package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.CalificacionDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
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
    
    @POST
    public AnimacionDTO crearAnimacion(AnimacionDTO animacion){
        return animacion;
    }
    
    @GET
    @Path("{animacionId: \\d+}")
    public AnimacionDetailDTO getAnimacion(@PathParam("animacionId") Long animacionID){
        return null;
    }
    
    @GET
    public ArrayList<AnimacionDetailDTO> getAnimaciones(){
        return null;
    }
    
    @PUT
    @Path("{animacionId: \\d+}")
    public AnimacionDTO updateAnnimacion(@PathParam("animacionId") Long animacionID, AnimacionDTO adto){
        return adto;
    }
    
    @DELETE
    @Path("{animacionId: \\d+}")
    public void deleteAnimacion(@PathParam("animacionId") Long animacionID){
        
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
    
}
