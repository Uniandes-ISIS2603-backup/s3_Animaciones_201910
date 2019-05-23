package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDetailDTO;
import co.edu.uniandes.csw.animaciones.dtos.JuradoDTO;
import co.edu.uniandes.csw.animaciones.dtos.RondaDTO;
import co.edu.uniandes.csw.animaciones.dtos.RondaDetailDTO;
import co.edu.uniandes.csw.animaciones.ejb.ConcursoJuradoLogic;
import co.edu.uniandes.csw.animaciones.ejb.ConcursoLogic;
import co.edu.uniandes.csw.animaciones.ejb.ConcursoRondaLogic;
import co.edu.uniandes.csw.animaciones.ejb.JuradoLogic;
import co.edu.uniandes.csw.animaciones.ejb.RondaLogic;
import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * @author df.perezc recurso que maneja lo relacionado al CRUD de un concurso
 */
@Path("concursos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ConcursoResource {

    @Inject
    private ConcursoLogic cl;

    @Inject
    private RondaLogic rl;

    @Inject
    private JuradoLogic jl;

    @Inject
    private ConcursoRondaLogic crl;

    @Inject
    private ConcursoJuradoLogic cjl;

    /**
     * Metodo que publica un concurso
     *
     * @param concursoDTO es el concurso a ser publicado
     * @return el concurso que se creo
     * @throws BusinessLogicException se lanza en caso de que este concurso
     * rompa las reglas de negocio
     */
    @POST
    public ConcursoDTO crearConcurso(ConcursoDTO concursoDTO) throws BusinessLogicException {
        ConcursoDTO cd = new ConcursoDTO(cl.create(concursoDTO.toEntity()));
        return cd;
    }

    /**
     * Metodo qeu retorna una lista de todos los concursos
     *
     * @return la lista de todos los concursos
     */
    @GET
    public ArrayList<ConcursoDetailDTO> getConcursos() {
        ArrayList<ConcursoDetailDTO> re = ListEntityToDetail(cl.findAll());
        return re;
    }

    /**
     * Medodo que retorna el detalle de un concurso teniedo la id
     *
     * @param concursoDetailId la id del concurso del cual se quiere el detalle
     * @return el detalle del concurso
     */
    @GET
    @Path("{concursoId: \\d+}")
    public ConcursoDetailDTO getConcurso(@PathParam("concursoId") Long concursoDetailId) {
        ConcursoEntity ce = cl.find(concursoDetailId);
        if (ce == null) {
            throw new WebApplicationException("El concurso no existe", 404);
        }
        ConcursoDetailDTO cdd = new ConcursoDetailDTO(ce);
        return cdd;
    }

 
     /**Metodo que actualiza un concurso
     
      @param concursoId es la id del concurso que se busca actualizar
      @param concursoDetailDTO es el detalle actualizado del recurso
     @return el detalle actualizado del concurso
     */
      @PUT
      @Path("{concursoId: \\d+}") 
      public ConcursoDTO updateConcurso(@PathParam("concusoId") Long concursoId, ConcursoDetailDTO concursoDetailDTO)throws BusinessLogicException{
      concursoDetailDTO.setId(concursoId);
      if(cl.find(concursoId) == null){
          throw new WebApplicationException("Elconcurso no existe",404);
      } 
      ConcursoDTO cd = new ConcursoDTO(cl.update(concursoDetailDTO.toEntity())); 
      return cd;
      }
     
    /**
     * metodo que elimina el concurso correspondiente al id ingresado
     *
     * @param concursoId es la id del concurso ingresado
     *
     * @DELETE
     * @Path("{concursoId: \\d+}//") public void
     * deleteConcurso(@PathParam("concursoId") Long concursoId) { ConcursoEntity
     * ae = cl.find(concursoId); if (ae == null) { throw new
     * WebApplicationException("El concurso no existe", 404); }
     * cl.delete(concursoId); }
     */
    
    /**
     * metodo que agrega rondas al concurso
     * @param concursoId
     * @param rondaId
     * @return 
     */
    @POST
    @Path("{concursoId: \\d+}/rondas/{rondaId: \\d+}")
    public RondaDTO addRonda(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId) {
        RondaEntity re = rl.getRonda(rondaId);
        if (re == null) {
            throw new WebApplicationException("La ronda no existe", 404);
        }
        RondaDTO rd = new RondaDTO(crl.addRonda(concursoId, rondaId));
        return rd;
    }

    /**
     * metodo que agrega jurados al concurso
     * @param concursoId
     * @param juradoId
     * @return 
     */
    @POST
    @Path("{concursoId: \\d+}/jurados/{juradoId: \\d+}")
    public JuradoDTO addJurado(@PathParam("concursoId") Long concursoId, @PathParam("juradoId") Long juradoId) {
        JuradoEntity je = jl.getJurado(juradoId);
        if (je == null) {
            throw new WebApplicationException("El jurado no existe", 404);
        }
        JuradoDTO jd = new JuradoDTO(cjl.addJurado(concursoId, juradoId));
        return jd;
    }

   /**
    * metodo que obtiene una ronda del concurso
    * @param concursoId
    * @param rondaId
    * @return 
    */
    @GET
    @Path("{concursoId: \\d+}/rondas/{rondaId: \\d+}")
    public RondaDetailDTO getRonda(@PathParam("concurosId") Long concursoId, @PathParam("rondaId") Long rondaId) {
        RondaEntity re = rl.getRonda(rondaId);
        if (re == null) {
            throw new WebApplicationException("La ronda no existe", 404);
        }
        RondaDetailDTO rd = new RondaDetailDTO(crl.getRonda(concursoId, rondaId));
        return rd;
    }

    /*
     @GET
    @Path("{concursoId: \\d+}/jurados/{juradoId: \\d+}")
    public JuradoDetailDTO getJurado(@PathParam("concurosId") Long concursoId, @PathParam("juradoId") Long juradoId){
        JuradoEntity je = jl.getJurado(juradoId);
        if(je == null){
            throw new WebApplicationException("el jurado no existe",404);
        }
        JuradoDetailDTO jd = new JuradoDetailDTO(cjl.getJurado(concursoId, juradoId));
        return jd;
    }
     */
    
    /**
     * metodo que obtiene todas las rondas del concurso
     * @param concursoId
     * @return 
     */
    @GET
    @Path("{concursoId: \\d+}/rondas")
    public ArrayList<RondaDetailDTO> getRondas(@PathParam("concursoId") Long concursoId) {
        ArrayList<RondaDetailDTO> rdl = RondaEntityToDetailDTO(crl.getRondas(concursoId));
        if (rdl == null) {
            throw new WebApplicationException("el concurso no tiene rondas", 404);
        }
        return rdl;
    }

    /*
    @GET
    @Path("{concursoId: \\d+}/rondas")
    public ArrayList<JuradoDetailDTO> getJurados(@PathParam("concursoId") Long concursoId) {
        ArrayList<JuradoDetailDTO> jdl = JuradoEntityToDetailDTO(cjl.getJurados(concursoId));
        if (jdl == null) {
            throw new WebApplicationException("el concurso no tiene jurados", 404);
        }
        return jdl;
    }
    */
    
    
    /*
    @DELETE
    @Path("{concursoId: \\d+}/rondas/{rondaId: \\d+}")
    public void deleteRonda(@PathParam("concursoId") Long concursoId, @PathParam("rondaId") Long rondaId){
        RondaEntity re = rl.getRonda(rondaId);
        if(re == null){
            throw new WebApplicationException("La ronda no existe",404);
        }
        crl.deleteRonda(concursoId, rondaId);
    }
    
    @DELETE
    @Path("{concursoId: \\d+}/jurados/{juradoId: \\d+}")
    public void deleteJurado(@PathParam("concursoId") Long concursoId, @PathParam("juradoId") Long juradoId){
        JuradoEntity je = jl.getJurado(juradoId);
        if(je == null){
            throw new WebApplicationException("La jurado no existe",404);
        }
        cjl.deleteJurado(concursoId, juradoId);
    }
    */

    /**
     * metodo para obtene una lista de concursosDetailDto apartir de una lista de una lista de entity 
     * @param list
     * @return 
     */
    private ArrayList<ConcursoDetailDTO> ListEntityToDetail(List<ConcursoEntity> list) {
        ArrayList<ConcursoDetailDTO> re = new ArrayList<>();
        for (ConcursoEntity ce : list) {
            re.add(new ConcursoDetailDTO(ce));
        }
        return re;
    }

    /**
     * metodo para obtene una lista de rondassDetailDto apartir de una lista de una lista de entity 
     * @param list
     * @return 
     */
    private ArrayList<RondaDetailDTO> RondaEntityToDetailDTO(List<RondaEntity> list) {
        ArrayList<RondaDetailDTO> rd = new ArrayList<>();
        for (RondaEntity re : list) {
            rd.add(new RondaDetailDTO(re));
        }
        return rd;
    }

    
    /**
     * metodo para obtene una lista de juradosDetailDto apartir de una lista de una lista de entity 
     * @param list
     * @return 
     */
    /*
    private ArrayList<JuradoDetailDTO> JuradoEntityToDetailDTO(List<JuradoEntity> list) {
        ArrayList<JuradoDetailDTO> jd = new ArrayList<>();
        for (JuradoEntity je : list) {
            jd.add(new JuradoDetailDTO(je));
        }
        return jd;
    }
    */

}
