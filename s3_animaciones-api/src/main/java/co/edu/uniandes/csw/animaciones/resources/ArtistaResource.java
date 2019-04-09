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
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
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
    
    /**
     * Metodo que crea un artista llamando a la persistencia 
     * @param artista, el artista que se quiere crear
     * @return El artista creado
     * @throws BusinessLogicException 
     */
    @POST
    public ArtistaDTO crearArtista(ArtistaDTO artista) throws BusinessLogicException{
        ArtistaDTO re = new ArtistaDTO(artistal.createArtista(artista.toEntity()));
        return re;
    }
    
    /**
     * Metodo para obtener un artista 
     * @param artistaId, el id del artista que se quiere obtener
     * @return El artista que se quiere
     */
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
    
    /**
     * Metodo para obtener todos los artistas
     * @return Todos los artistas
     */
    @GET
    public ArrayList<ArtistaDetailDTO> getArtistas(){
        ArrayList<ArtistaDetailDTO> re = ArtistaEntity2DetailDTO(artistal.getArtistas());
        return re;
    }
    
    /**
     * Metodo para actualizar un artista
     * @param artistaId, el id del artista que se quiere actualizar
     * @param adto, la informacion nueva del artista
     * @return El artista actualizado
     * @throws BusinessLogicException 
     */
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
    
    /**
     * Metodo para borrar un artista
     * @param artistaId, id del artista que se quiere borrar
     */
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
        AnimacionEntity ae = animacionl.getAnimacion(animacionId);
        if(ae == null){
            throw new WebApplicationException("La annimacion no existe",404);
        }
        AnimacionDTO re = new AnimacionDTO(aal.addAnimacion(artistaId, animacionId));
        return re;
    }
    
    @POST
    @Path("{artistaId: \\d+}/propuestas/{propuestaId: \\d+}")
    public PropuestaDTO addPropuesta(@PathParam("artistaId") Long artistaId, @PathParam("propuestaId") Long PropuestaId){
        PropuestaEntity pe = propuestal.getP(PropuestaId);
        if(pe == null){
            throw new WebApplicationException("La propuesta no existe",404);
        }
        PropuestaDTO re = new PropuestaDTO(apl.addPropuesta(artistaId, PropuestaId));
        return re;
    }
    
    @GET
    @Path("{artistaId: \\d+}/animaciones/{animacionId: \\d+}")
    public AnimacionDetailDTO getAnimacion(@PathParam("artistaId") Long artistaId, @PathParam("animacionId") Long animacionId){
        AnimacionEntity ae = animacionl.getAnimacion(animacionId);
        if(ae == null){
            throw new WebApplicationException("La annimacion no existe",404);
        }
        AnimacionDetailDTO re = new AnimacionDetailDTO(aal.getAnimacion(artistaId, animacionId));
        return re;
    }
    
    @GET
    @Path("{artistaId: \\d+}/aninmaciones")
    public ArrayList<AnimacionDetailDTO> getAnimaciones(@PathParam("artistaId") Long artistaId){
        ArrayList<AnimacionDetailDTO> re = AnimacionEntity2DetailDTO(aal.getAnimaciones(artistaId));
        if(re == null){
            throw new WebApplicationException("El artista no existe",404);
        }
        return re;
    }
    
    @GET
    @Path("{artistaId: \\d+}/propuestas/{propuestaId: \\d+}")
    public PropuestaDTO getPropuesta(@PathParam("artistaId") Long artistaId, @PathParam("propuestaId") Long PropuestaId){
        PropuestaEntity pe = propuestal.getP(PropuestaId);
        if(pe == null){
            throw new WebApplicationException("La propuesta no existe",404);
        }
        PropuestaDTO re = new PropuestaDTO(apl.getPropuesta(artistaId, PropuestaId));
        return re;
    }
    
    @GET
    @Path("{artistaId: \\d+}/propuestas")
    public ArrayList<PropuestaDTO> getPropuestas(@PathParam("artistaId") Long artistaId){
        ArrayList<PropuestaDTO> re = PropuestaEntity2DTO(apl.getPropuestas(artistaId));
        if(re == null){
            throw new WebApplicationException("El artista no existe",404);
        }
        return re;
    }
    
    @DELETE
    @Path("{artistaId: \\d+}/animaciones/{animacionId: \\d+}")
    public void deleteAnimacion(@PathParam("artistaId") Long artistaId, @PathParam("animacionId") Long animacionId){
        AnimacionEntity ae = animacionl.getAnimacion(animacionId);
        if(ae == null){
            throw new WebApplicationException("La animacion no existe",404);
        }
        aal.removeAnimacion(artistaId, animacionId);
    }
    
    @DELETE
    @Path("{artistaId: \\d+}/propuestas/{propuestaId: \\d+}")
    public void deletePropuesta(@PathParam("artistaId") Long artistaId, @PathParam("propuestaId") Long PropuestaId){
        PropuestaEntity pe = propuestal.getP(PropuestaId);
        if(pe == null){
            throw new WebApplicationException("La propuesta no existe",404);
        }
        apl.removePropuesta(artistaId, PropuestaId);
    }
    
    private ArrayList<ArtistaDetailDTO> ArtistaEntity2DetailDTO(List<ArtistaEntity> list){
        ArrayList<ArtistaDetailDTO> re = new ArrayList<>();
        for(ArtistaEntity ae: list){
            re.add(new ArtistaDetailDTO(ae));
        }
        return re;
    }
    
    private ArrayList<AnimacionDetailDTO> AnimacionEntity2DetailDTO(List<AnimacionEntity> list){
        ArrayList<AnimacionDetailDTO> re = new ArrayList<>();
        for(AnimacionEntity ce: list){
            re.add(new AnimacionDetailDTO(ce));
        }
        return re;
    }
    
    private ArrayList<PropuestaDTO> PropuestaEntity2DTO(List<PropuestaEntity> list){
        ArrayList<PropuestaDTO> re = new ArrayList<>();
        for(PropuestaEntity ce: list){
            re.add(new PropuestaDTO(ce));
        }
        return re;
    }
}
