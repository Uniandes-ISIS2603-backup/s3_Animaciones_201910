package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDetailDTO;
import co.edu.uniandes.csw.animaciones.ejb.ConcursoLogic;
import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * @author df.perezc
 * recurso que maneja lo relacionado al CRUD de un concurso
 */
@Path("concursos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ConcursoResource {
    
    
    private static final Logger LOGGER = Logger.getLogger(ConcursoResource.class.getName());
    
    @Inject
    private ConcursoLogic cl;
    
    /**
     * Metodo que publica un concurso
     * @param concursoDTO es el concurso a ser publicado
     * @return el concurso que se creo
     * @throws BusinessLogicException se lanza en caso de que este concurso rompa las reglas de negocio 
     */
    @POST
    public ConcursoDTO crearConcurso(ConcursoDTO concursoDTO)throws BusinessLogicException {
        ConcursoEntity ce = concursoDTO.toEntity();
        ce = cl.createConcursoEntity(ce);
        return new ConcursoDTO(ce);
    }

    /**
     * Metodo qeu retorna una lista de todos los concursos
     * @return la lista de todos los concursos
     */
    @GET
    public ArrayList<ConcursoDetailDTO> getConcursos() {
        return null;
    }

    /**
     * Medodo que retorna el detalle de un concurso teniedo la id
     * @param concursoDetailId la id del concurso del cual se quiere el detalle
     * @return el detalle del concurso
     */
    @GET
    @Path("{concursoId: \\d+}")
    public ConcursoDetailDTO getConcurso(@PathParam("concursoId") Long concursoDetailId) {
        return null;
    }
    
    /**
     * Metodo que actualiza un concurso 
     * @param artistaId es la id del concurso que se busca actualizar
     * @param concursoDetailDTO es el detalle actualizado del recurso
     * @return  el detalle actualizado del concurso
     */
    @PUT
    @Path("{concursoId: \\d+}")
    public ConcursoDetailDTO updateConcurso(@PathParam("concusoId") Long artistaId, ConcursoDetailDTO concursoDetailDTO){
        return concursoDetailDTO;
    }
    
    /**
     * metodo que elimina el concurso correspondiente al id ingresado
     * @param concursoId es la id del concurso ingresado
     */
    @DELETE
    @Path("{concursoId: \\d+}//")
    public void deleteConcurso(@PathParam("concursoId") Long concursoId) {

    }
}
