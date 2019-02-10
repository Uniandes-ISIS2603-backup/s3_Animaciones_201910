package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
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
    public AnimacionDTO getAnimacion(@PathParam("animacionId") Long animacionID){
        return null;
    }
    
    @GET
    public ArrayList<AnimacionDTO> getAnimaciones(){
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
    
}
