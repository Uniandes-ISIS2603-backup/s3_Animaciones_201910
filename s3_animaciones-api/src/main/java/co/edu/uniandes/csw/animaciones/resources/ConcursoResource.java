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
 */
@Path("concursos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ConcursoResource {
    
    private static final Logger LOGGER = Logger.getLogger(ConcursoResource.class.getName());
    
    @Inject
    private ConcursoLogic cl;
    
    @POST
    public ConcursoDTO crearConcurso(ConcursoDTO concursoDTO)throws BusinessLogicException {
        ConcursoEntity ce = concursoDTO.toEntity();
        ce = cl.createConcursoEntity(ce);
        return new ConcursoDTO(ce);
    }

    @GET
    public ArrayList<ConcursoDetailDTO> getConcursos() {
        return null;
    }

    @GET
    @Path("{concursoId: \\d+}")
    public ConcursoDetailDTO getConcurso(@PathParam("concursoId") Long concursoDetailId) {
        return null;
    }
    
    @PUT
    @Path("{concursoId: \\d+}")
    public ConcursoDetailDTO updateConcurso(@PathParam("concusoId") Long artistaId, ConcursoDetailDTO concursoDetailDTO){
        return concursoDetailDTO;
    }
    
    @DELETE
    @Path("{concursoId: \\d+}//")
    public void deleteConcurso(@PathParam("concursoId") Long concursoId) {

    }
}
