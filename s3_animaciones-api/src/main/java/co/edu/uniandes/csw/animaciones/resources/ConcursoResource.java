package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.AnimacionConcursoDTO;
import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;
import co.edu.uniandes.csw.animaciones.dtos.VotacionDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author df.perezc
 */
@Path("concursos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ConcursoResource {

    private final static Logger LOGGER = Logger.getLogger(ConcursoResource.class.getName());
    /**
     * crea y retorna un concurso
     * @param concurso
     * @return 
     */
    @POST
    public ConcursoDTO crearConcurso(ConcursoDTO concurso) {
        return concurso;
    }
    
    /**
     * retorna todos los concursos
     * @return 
     */
    @GET
    public ArrayList<ConcursoDTO> getConcursos() {
        return null;
    }
    
    /**
     * devuelve el concurso de la id que entra por parametro
     * @param artistaId
     * @return 
     */
    @GET
    @Path("(concursoId: \\d+)")
    public ConcursoDTO getConcurso(@PathParam("artistaId") Long artistaId) {
        return null;
    }

    /**
     * @POST @Path("(concursoId: \\d+)") public JuradoDTO createJurado(JuradoDTO
     * jurado){ return jurado; }
     *
     * @GET
     * @Path("(concusoId: \\d+)//jurados/(juradoId: \\d+)") public JuradoDTO
     * getJurado(@PathParam("concursoId") Long concursoId,
     * @PathParam("juradoId") Long juradoId) {
     *
     * }
     *
     * @DELETE
     * @Path("(concusoId: \\d+)//jurados/(juradoId: \\d+)") public void
     * deleteJurado(@PathParam("concursoId") Long concursoId,
     * @PathParam("juradoId") Long juradoId) {
     *
     * }
     */
    /**
     * crea una nueva regla para el concurso
     * @param concursoId
     * @param reglaConcurso
     * @return 
     */
    @POST
    @Path("(concursoId: \\d+)/reglas/(reglasId: \\d+)")
    public String createReglaConcurso(@PathParam("concursoId") Long concursoId, String reglaConcurso) {
        return reglaConcurso;
    }

    /**
     * retorna todas las reglas de un concurso
     * @param concursoId
     * @return 
     */
    @GET
    @Path("(concursoId: \\d+)/reglas")
    public String getReglasConcurso(@PathParam("concursoId") Long concursoId) {
        return "reglas";
    }

    /**
     * las reglas estan en un arreglo por lo cual para acceder a ellas no se
     * sales de concurso, el identificador de una regla sera su pocision en el 
     * arreglo.suposición..
     * @param concursoId
     * @param reglaId 
     */
    @DELETE
    @Path("(concursoId: \\d+)/reglas/(reglaId)")
    public void deleteRegla(@PathParam("concursoId") Long concursoId, @PathParam("reglaId") Long reglaId) {
        
    }
    
    /**
     * 
     * @param concursoId
     * @param rondaId
     * @param inicio
     * @param limite
     * @param fin
     * @return 
     *
    @POST
    @Path("(concursoId: \\d+)/rondas/(rondaId: \\d+)")
    public Date createFechasRonda(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, Date inicio, Date limite, Date fin) {
        return inicio;
    }
    */

    
    /**
     * 
     * @param concursoId
     * @param rondaId
     * @param inicio
     * @param limite
     * @param fin
     * @return 
     *
    @PUT
    @Path("(concursoId: \\d+)/rondas/(rondaId: \\d+)/fechas/(fechaId)")
    public Date updateFechasRonda(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, Date inicio, Date limite, Date fin) {
        return inicio;
    }
    */
    
    /**
     * solo se usa este metodo en las animaciones finalistas(luego de hacer upgradeRank), solo se requiere poner dinero con un upgrade de animacionConcuso a animacionGanadora
     * @param concursoId
     * @param rondaId
     * @param animacionConcursoId
     * @param dinero
     * @return 
     */
    @POST
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/ganadores/(animacionGanadoraId: \\+d)")
    public Long premiarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionConcursoId, Integer dinero)
    {
        return animacionConcursoId;
    }
    
    /**
     * primero se puntua la animacion con este metodo, luego se reankea automaticamente. 
     * @param concursoId
     * @param animacionConcursoId
     * @param rondaId 
     * @param puntaje
     * @return 
     */
    @PUT
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public Long puntuarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId,@PathParam("animacionId") Long animacionConcursoId, Double puntaje )
    {
        return animacionConcursoId;
    }
    
    /**
     * otorga puesto a la animacion, puede hacerla finalista
     * @param concursoId
     * @param rondaId
     * @param animacionConcursoId
     * @param rank
     * @param finalista
     * @return 
     *
    @PUT
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/ganadores")
    public Long updateRankAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId,@PathParam("animacionId") Long animacionConcursoId, Integer rank, boolean finalista)
    {
        return animacionConcursoId;
    }
    */
    
    /**
     * 
     * @param concursoId
     * @param rondaId
     * @param animacionConcursoId
     * @return 
     */
    @GET 
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/ganadores/(animacionFinalistaId: \\+d)")
    public AnimacionConcursoDTO getAnimacion(@PathParam("concursoId") Long concursoId,@PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionConcursoId){
        return null;
    }
    
    /**
     * 
     * @param concursoId
     * @param animacionId
     * @return 
     */
    @POST
    @Path("(concursoId: \\d+)/animaciones/(animacionID: \\d+)")
    public AnimacionConcursoDTO inscribirAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("animacionId") Long animacionId)
    {
      return null;   
    }
    
    /**
     * 
     * @param concursoId
     * @param rondaId
     * @param animacionConcursoId 
     */
    @DELETE
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public void descalificarAnimacion(@PathParam("concursoId") Long concursoId,@PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionConcursoId)
    {
        
    }
    /**
    @GET
    @Path("(concursoId: \\d+)/jurados/(juradoId: \\d+)/votaciones/(votacionesId: \\+d)")
    public VotacionDTO getVotacion(@PathParam("concursoId") Long concursoId,@PathParam("juradoId") Long juradoId, @PathParam("votacionId") Long votacionId)
    {
        return null;
    }
    */
    /**
     * 
     * @param concursoId
     * @param juradoId
     * @param ronda
     * @param votacionId
     * @return 
     */
    @GET
    @Path("(concursoId: \\d+)/jurados/(juradoId: \\d+)/votaciones/(votacionesId: \\+d)")
    public VotacionDTO getVotacion(@PathParam("concursoId") Long concursoId,@PathParam("juradoId") Long juradoId, @QueryParam("ronda") Integer ronda, @PathParam("votacionId") Long votacionId)
    {
        return null;
    }   
    
}
