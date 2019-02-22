package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.ArtistaDTO;
import co.edu.uniandes.csw.animaciones.dtos.ArtistaDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.PropuestaDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

/**
 *
 * @author Nicolas Alvardo
 */
@Path("artistas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ArtistaResource {
    
    @POST
    public ArtistaDTO crearArtista(ArtistaDTO artista){
        return artista;
    }
    
    @GET
    @Path("{artistaId: \\d+}")
    public ArtistaDetailDTO getArtista(@PathParam("artistaId") Long artistaId){
        return null;
    }
    
    @GET
    public ArrayList<ArtistaDetailDTO> getArtistas(){
        return null;
    }
    
    @PUT
    @Path("{artistaId: \\d+}")
    public ArtistaDTO updateArtista(@PathParam("artistaId") Long artistaId, ArtistaDTO adto){
        return adto;
    }
    
    @DELETE
    @Path("{artistaId: \\d+}")
    public void deleteArtista(@PathParam("artistaId") Long artistaId){
        
    }
    
    @POST
    @Path("{artistaId: \\d+}/animaciones/{animacionId: \\d+}")
    public AnimacionDTO addAnimacion(@PathParam("artistaId") Long artistaId, @PathParam("animacionId") Long animacionId){
        return null;
    }
    
    @POST
    @Path("{artistaId: \\d+}/propuestas/{propuestaId: \\d+}")
    public PropuestaDTO addPropuesta(@PathParam("artistaId") Long artistaId, @PathParam("propuestaId") Long PropuestaId){
        return null;
    }
    
    @GET
    @Path("{artistaId: \\d+}/animaciones/{animacionId: \\d+}")
    public AnimacionDetailDTO getAnimacion(@PathParam("artistaId") Long artistaId, @PathParam("animacionId") Long animacionId){
        return null;
    }
    
    @GET
    @Path("{artistaId: \\d+}/aninmaciones")
    public ArrayList<AnimacionDetailDTO> getAnimaciones(@PathParam("artistaId") Long artistaId){
        return null;
    }
    
    @GET
    @Path("{artistaId: \\d+}/propuestas/{propuestaId: \\d+}")
    public PropuestaDTO getPropuesta(@PathParam("artistaId") Long artistaId, @PathParam("propuestaId") Long PropuestaId){
        return null;
    }
    
    @GET
    @Path("{artistaId: \\d+}/propuestas")
    public ArrayList<PropuestaDTO> getPropuestas(@PathParam("artistaId") Long artistaId){
        return null;
    }
    
    @DELETE
    @Path("{artistaId: \\d+}/animaciones/{animacionId: \\d+}")
    public void deleteAnimacion(@PathParam("artistaId") Long artistaId, @PathParam("animacionId") Long animacionId){
        
    }
    
    @DELETE
    @Path("{artistaId: \\d+}/propuestas/{propuestaId: \\d+}")
    public void deletePropuesta(@PathParam("artistaId") Long artistaId, @PathParam("propuestaId") Long PropuestaId){
        
    }
}
