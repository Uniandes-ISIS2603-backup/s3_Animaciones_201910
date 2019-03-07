package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionDTO;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.ArtistaDTO;
import co.edu.uniandes.csw.animaciones.dtos.ArtistaDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.PropuestaDTO;
import co.edu.uniandes.csw.animaciones.ejb.AnimacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.ArtistaAnimacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.ArtistaLogic;
import co.edu.uniandes.csw.animaciones.ejb.ArtistaPropuestaLogic;
import co.edu.uniandes.csw.animaciones.ejb.PropuestaLogic;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    
    @Inject
    private ArtistaLogic artistal;
    
    @Inject
    private AnimacionLogic animacionl;
    
    @Inject
    private PropuestaLogic propuestal;
    
    @Inject
    private ArtistaAnimacionLogic aal;
    
    @Inject
    private ArtistaPropuestaLogic apl;
    
    @POST
    public ArtistaDTO crearArtista(ArtistaDTO artista) throws BusinessLogicException{
        ArtistaDTO re = new ArtistaDTO(artistal.createArtista(artista.toEntity()));
        return re;
    }
    
    @GET
    @Path("{artistaId: \\d+}")
    public ArtistaDetailDTO getArtista(@PathParam("artistaId") Long artistaId){
        ArtistaEntity ae = artistal.getArtista(artistaId);
        if(ae == null){
            throw new WebApplicationException("El artista no existe",404);
        }
        ArtistaDetailDTO re = new ArtistaDetailDTO(ae);
        return re;
    }
    
    @GET
    public ArrayList<ArtistaDetailDTO> getArtistas(){
        ArrayList<ArtistaDetailDTO> re = ArtistaEntity2DetailDTO(artistal.getArtistas());
        return re;
    }
    
    @PUT
    @Path("{artistaId: \\d+}")
    public ArtistaDTO updateArtista(@PathParam("artistaId") Long artistaId, ArtistaDTO adto) throws BusinessLogicException{
        adto.setId(artistaId);
        if(artistal.getArtista(artistaId) == null){
            throw new WebApplicationException("El artista no existe",404);
        }
        ArtistaDTO re = new ArtistaDTO(artistal.updateArtista(adto.toEntity()));
        return re;
    }
    
    @DELETE
    @Path("{artistaId: \\d+}")
    public void deleteArtista(@PathParam("artistaId") Long artistaId){
        ArtistaEntity ae = artistal.getArtista(artistaId);
        if(ae == null){
            throw new WebApplicationException("El artista no existe",404);
        }
        artistal.deleteArtista(artistaId);
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
    
    private ArrayList<ArtistaDetailDTO> ArtistaEntity2DetailDTO(List<ArtistaEntity> list){
        ArrayList<ArtistaDetailDTO> re = new ArrayList<>();
        for(ArtistaEntity ae: list){
            re.add(new ArtistaDetailDTO(ae));
        }
        return re;
    }
}
