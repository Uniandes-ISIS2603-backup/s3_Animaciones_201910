package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
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
    
    @POST
    public ConcursoDTO crearConcurso(ConcursoDTO concursoDTO) {
        return concursoDTO;
    }

    @GET
    public ArrayList<ConcursoDTO> getConcursos() {
        return null;
    }

    @GET
    @Path("{concursoId: \\d+}")
    public ConcursoDTO getConcurso(@PathParam("concursoId") Long artistaId) {
        return null;
    }
    
    @PUT
    @Path("{concursoId: \\d+}")
    public ConcursoDTO updateConcurso(@PathParam("concusoId") Long artistaId, ConcursoDTO concursoDTO){
        return concursoDTO;
    }
    
    @DELETE
    @Path("{concursoId: \\d+}//")
    public void deleteConcurso(@PathParam("concursoId") Long concursoId) {

    }
}
