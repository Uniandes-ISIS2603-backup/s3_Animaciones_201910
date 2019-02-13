package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import java.util.Date;

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
    @POST
    @Path("(concursoId: \\d+)")
    public String createReglaConcurso(@PathParam("concursoId") Long concursoId, String reglaConcurso) {
        return reglaConcurso;
    }

    @GET
    @Path("(concursoId: \\d+)")
    public String getReglasConcurso(@PathParam("concursoId") Long concursoId) {
        return "reglas";
    }

    /**
     * las reglas estan en un arreglo por lo cual para acceder a ellas no se
     * sales de concurso, el identificador de una regla será su pocision en el 
     * arreglo
     */
    @DELETE
    @Path("(concursoId: \\d+)//")
    public void deleteRegla(@PathParam("concursoId") Long concursoId, @PathParam("reglaId") Long reglaId) {
        
    }
    
    @POST
    @Path("(concursoId: \\d+)/rondas/(rondaId: \\d+)")
    public Date createFechasRonda(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, Date inicio, Date limite, Date fin) {
        return inicio;
    }

    @PUT
    @Path("(concursoId: \\d+)/rondas/(rondaId: \\d+)")
    public Date updateFechasRonda(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, Date inicio, Date limite, Date fin) {
        return inicio;
    }
    
    /**
     * solo se usa este método en las animaciones finalistas(luego de hacer upgradeRank), solo se requiere poner dinero con un upgrade de animacionConcuso a animacionGanadora
     * @param concursoId
     * @param rondaId
     * @param animacionConcursoId
     * @param dinero
     * @return 
     */
    @POST
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public Long premiarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionConcursoId, Integer dinero)
    {
        return animacionConcursoId;
    }
    
    /**
     * primero se puntua la animacion con este metodo, luego se reankea automaticamente. 
     * @param concursoId
     * @param animacionConcursoId
     * @param puntaje
     * @return 
     */
    @PUT
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public Long puntuarAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId,@PathParam("animacionId") Long animacionConcursoId, Double puntaje )
    {
        return animacionConcursoId;
    }
    
    @PUT
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public Long updateRankAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId,@PathParam("animacionId") Long animacionConcursoId, Integer rank, boolean finalista)
    {
        return animacionConcursoId;
    }
    
    @GET 
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public AnimacionConcursoDTO getAnimacion(@PathParam("concursoId") Long concursoId,@PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionConcursoId){
        return null;
    }
    
    @POST
    @Path("concursoId: \\d+")
    public AnimacionConcursoDTO inscribirAnimacion(@PathParam("concursoId") Long concursoId, @PathParam("animacionId") Long animacionId)
    {
      return null;   
    }
    
    @DELETE
    @Path("(concursoId: \\d+)/rondas/(ronda: \\d+)/animacionesConcurso/(animacionConcursoId: \\+d)")
    public void descalificarAnimacion(@PathParam("concursoId") Long concursoId,@PathParam("rondaId") Long rondaId, @PathParam("animacionId") Long animacionConcursoId)
    {
        
    }
            }
