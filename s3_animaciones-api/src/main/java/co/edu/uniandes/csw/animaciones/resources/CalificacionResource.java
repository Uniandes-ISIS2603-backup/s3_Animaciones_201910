/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.CalificacionDTO;
import co.edu.uniandes.csw.animaciones.ejb.CalificacionLogic;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ld.manrique
 */
@Path("calificaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource {
    @Inject
    private CalificacionLogic logic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(co.edu.uniandes.csw.animaciones.resources.CalificacionResource.class.getName());
    
   /**
     * Crea una nueva calificacion con la informacion que se recibe en el cuerpo de la
     * petición y se regresa un objeto identico con un id auto-generado por la
     * base de datos.
     *
     * @param animacionId El ID dela animacion  del cual se le agrega la calificacion
     * @param calificacion {@link ReviewDTO} - La calificacion que se desea guardar.
     * @return JSON {@link CalificacionDTO} - La calificacion guardada con el atributo id
     * autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     */
    @POST
    public CalificacionDTO createCalificacion(@PathParam("animacionId") Long animacionId, CalificacionDTO calificacion) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "CalificacionResource createCalificacion: input: {0}", calificacion);
        CalificacionDTO nuevoCalificacionDTO = new CalificacionDTO(logic.create( animacionId, calificacion.toEntity()));
        LOGGER.log(Level.INFO, "CalificacionResource createCalificacion: output: {0}", nuevoCalificacionDTO);
        return nuevoCalificacionDTO;
    }
    

     /**
     * Busca y devuelve todas las calificaciones que existen en un animacion.
     *
     * @param animacionId El ID del animacion del cual se buscan las calificacion
     * @return JSONArray {@link CalificacionDTO} - Las calificacion encontradas en el
     * animacion. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CalificacionDTO> getCalificaciones(@PathParam("animacionId") Long animacionId) {
        LOGGER.log(Level.INFO, "CalificacionResource getCalificaciones: input: {0}", animacionId);
        List<CalificacionDTO> listaDTOs = listEntity2DTO(logic.getCalificacionesAnimacion(animacionId));
        LOGGER.log(Level.INFO, "EditorialBooksResource getBooks: output: {0}", listaDTOs);
        return listaDTOs;
    }

    /**
     * Busca y devuelve la calificacion con el ID recibido en la URL, relativa a un
     * animacion.
     *
     * @param animacionId El ID del animacion del cual se buscan las calificaciones
     * @param calificacionId El ID de la calificacion que se busca
     * @return {@link CalificacionDTO} - La reseña encontradas en el animacion.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el animacion.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la calificacion.
     */
    @GET
    @Path("{calificacionId: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("calificacionId") Long calificacionId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "ReviewResource getCalificacion: input: {0}", calificacionId);
        CalificacionEntity entity = logic.getCalificacion(calificacionId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /animacion/" + "/calificacion/" + calificacionId + " no existe.", 404);
        }
        CalificacionDTO calificacionDTO = new CalificacionDTO(entity);
        LOGGER.log(Level.INFO, "ReviewResource getCalificacion: output: {0}", calificacionDTO);
        return calificacionDTO;
    }

    /**
     * Actualiza una recalificacionseña con la informacion que se recibe en el cuerpo de la
     * petición y se regresa el objeto actualizado.
     *
     * @param animacionId El ID del animacion del cual se guarda la calificacion
     * @param calificacionId El ID de la calificacion que se va a actualizar
     * @param calificacion {@link ReviewDTO} - La calificacion que se desea guardar.
     * @return JSON {@link ReviewDTO} - La calificacion actualizada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
 
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la calificacion.
     */
    @PUT
    @Path("{calificacionId: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("animacionId") Long animacionId, @PathParam("calificacionId") Long calificacionId, CalificacionDTO calificacion) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "CalificacionResource updateCalificacion: input: animacionId: {0} , calificacionId: {1} , calificacion:{2}", new Object[]{animacionId, calificacionId, calificacion});
        if (calificacionId.equals(calificacion.getId())) {
            throw new BusinessLogicException("Los ids del Calificacion no coinciden.");
        }
        CalificacionEntity entity = logic.getCalificacion(calificacionId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /animaciones/" + animacionId + "/reviews/" + calificacionId + " no existe.", 404);

        }
        CalificacionDTO reviewDTO = new CalificacionDTO(logic.update(animacionId, calificacion.toEntity()));
        LOGGER.log(Level.INFO, "ReviewResource updateReview: output:{0}", reviewDTO);
        return reviewDTO;

    }

    /**
     * Borra la calificacion con el id asociado recibido en la URL.
     *
     * @param animacionId El ID del animacion del cual se va a eliminar la calificacion.
     * @param calificacionId El ID de la calificacion que se va a eliminar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede eliminar la calificacion.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la calificacion.
     */
    @DELETE
    @Path("{calificacionId: \\d+}")
    public void delete(@PathParam("animacionId") Long animacionId, @PathParam("calificacionId") Long calificacionId) throws BusinessLogicException {
        CalificacionEntity entity = logic.getCalificacion(calificacionId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /animaciones/" + animacionId + "/calificacion/" + calificacionId + " no existe.", 404);
        }
        logic.delete(animacionId, calificacionId);
    }

    /**
     * Lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos CalificacionEntity a una lista de
     * objetos CalificacionDTO (json)
     *
     * @param entityList corresponde a la lista de calificaciones de tipo Entity que
     * vamos a convertir a DTO.
     * @return la lista de calificaciones en forma DTO (json)
     */
    private List<CalificacionDTO> listEntity2DTO(List<CalificacionEntity> entityList) {
        List<CalificacionDTO> list = new ArrayList<CalificacionDTO>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDTO(entity));
        }
        return list;
    }
    
}
