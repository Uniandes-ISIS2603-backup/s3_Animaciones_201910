package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionParticipanteDTO;
import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;
import co.edu.uniandes.csw.animaciones.dtos.JuradoDTO;
import co.edu.uniandes.csw.animaciones.dtos.VotacionDTO;
import java.util.ArrayList;
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

    @POST
    public ConcursoDTO crearConcurso(ConcursoDTO concurso) {
        return concurso;
    }

    @GET
    public ArrayList<ConcursoDTO> getConcursos() {
        return null;
    }

    @GET
    @Path("{concursoId: \\d+}")
    public ConcursoDTO getConcurso(@PathParam("artistaId") Long artistaId) {
        return null;
    }

  
/**
    @POST
    @Path("{concursoId: \\d+}")
    public String createReglaConcurso(@PathParam("concursoId") Long concursoId, String reglaConcurso) {
        return reglaConcurso;
    }
    */

    /**
    @GET
    @Path("{concursoId: \\d+}")
    public String getReglasConcurso(@PathParam("concursoId") Long concursoId) {
        return "reglas";
    }
    */

    /**
     * las reglas estan en un arreglo por lo cual para acceder a ellas no se
     * sales de concurso, el identificador de una regla sera su pocision en el
     * arreglo
     * 
     */
    @DELETE
    @Path("{concursoId: \\d+}//")
    public void deleteRegla(@PathParam("concursoId") Long concursoId, @PathParam("reglaId") Long reglaId) {

    }

   
@POST
    @Path("{concursoId: \\d+}")
    public AnimacionParticipanteDTO inscribirAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("animacionId") Long animacionId) {
        return null;
    }
    


    /**
    @DELETE
    @Path("{concursoId: \\d+}/rondas/{ronda: \\d+}/animacionesParticipantesId/{animacionesParticipanteId: \\+d}")
    public void descalificarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionParticipanteId) {
    }
    */

}
