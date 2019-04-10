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
        LOGGER.log(Level.INFO, "RCalificacionResource createCalificacion: output: {0}", nuevoCalificacionDTO);
        return nuevoCalificacionDTO;
    }
    
//
//     /**
//     * Busca y devuelve todas las calificaciones que existen en un libro.
//     *
//     * @param animacionId El ID del animacion del cual se buscan las calificacion
//     * @return JSONArray {@link ReviewDTO} - Las calificacion encontradas en el
//     * animacion. Si no hay ninguna retorna una lista vacía.
//     */
//    @GET
//    public List<CalificacionDTO> getCalificacioness(@PathParam("booksId") Long animacionId) {
//        LOGGER.log(Level.INFO, "ReviewResource getReviews: input: {0}", animacionId);
//        List<CalificacionDTO> listaDTOs = listEntity2DTO(logic.getCalificaciones(animacionId));
//        LOGGER.log(Level.INFO, "EditorialBooksResource getBooks: output: {0}", listaDTOs);
//        return listaDTOs;
//    }

//    /**
//     * Busca y devuelve la calificacion con el ID recibido en la URL, relativa a un
//     * animacion.
//     *
//     * @param booksId El ID del libro del cual se buscan las reseñas
//     * @param calificacionId El ID de la calificacion que se busca
//     * @return {@link ReviewDTO} - La reseña encontradas en el libro.
//     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
//     * Error de lógica que se genera cuando no se encuentra el libro.
//     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
//     * Error de lógica que se genera cuando no se encuentra la reseña.
//     */
//    @GET
//    @Path("{calificacionId: \\d+}")
//    public ReviewDTO getReview(@PathParam("animacionId") Long booksId, @PathParam("calificacioId") Long reviewsId) throws BusinessLogicException {
//        LOGGER.log(Level.INFO, "ReviewResource getReview: input: {0}", reviewsId);
//        ReviewEntity entity = reviewLogic.getReview(booksId, calificacionId);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /animacion/" + animacionId + "/calificacion/" + calificacionId + " no existe.", 404);
//        }
//        ReviewDTO reviewDTO = new ReviewDTO(entity);
//        LOGGER.log(Level.INFO, "ReviewResource getReview: output: {0}", reviewDTO);
//        return reviewDTO;
//    }

//    /**
//     * Actualiza una recalificacionseña con la informacion que se recibe en el cuerpo de la
//     * petición y se regresa el objeto actualizado.
//     *
//     * @param booksId El ID del libro del cual se guarda la reseña
//     * @param reviewsId El ID de la calificacion que se va a actualizar
//     * @param calificacion {@link ReviewDTO} - La calificacion que se desea guardar.
//     * @return JSON {@link ReviewDTO} - La calificacion actualizada.
//     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
// 
//     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
//     * Error de lógica que se genera cuando no se encuentra la calificacion.
//     */
//    @PUT
//    @Path("{reviewsId: \\d+}")
//    public ReviewDTO updateReview(@PathParam("booksId") Long booksId, @PathParam("reviewsId") Long reviewsId, ReviewDTO calificacion) throws BusinessLogicException {
//        LOGGER.log(Level.INFO, "ReviewResource updateReview: input: booksId: {0} , reviewsId: {1} , review:{2}", new Object[]{booksId, reviewsId, calificacion});
//        if (reviewsId.equals(review.getId())) {
//            throw new BusinessLogicException("Los ids del Review no coinciden.");
//        }
//        ReviewEntity entity = reviewLogic.getReview(booksId, reviewsId);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /books/" + booksId + "/reviews/" + reviewsId + " no existe.", 404);
//
//        }
//        ReviewDTO reviewDTO = new ReviewDTO(reviewLogic.updateReview(booksId, calificacion.toEntity()));
//        LOGGER.log(Level.INFO, "ReviewResource updateReview: output:{0}", reviewDTO);
//        return reviewDTO;
//
//    }
//
//    /**
//     * Borra la reseña con el id asociado recibido en la URL.
//     *
//     * @param booksId El ID del libro del cual se va a eliminar la reseña.
//     * @param reviewsId El ID de la calificacion que se va a eliminar.
//     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
//     * Error de lógica que se genera cuando no se puede eliminar la calificacion.
//     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
//     * Error de lógica que se genera cuando no se encuentra la calificacion.
//     */
//    @DELETE
//    @Path("{reviewsId: \\d+}")
//    public void deleteReview(@PathParam("booksId") Long booksId, @PathParam("reviewsId") Long reviewsId) throws BusinessLogicException {
//        ReviewEntity entity = reviewLogic.getReview(booksId, reviewsId);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /books/" + booksId + "/calificacion/" + reviewsId + " no existe.", 404);
//        }
//        reviewLogic.deleteReview(booksId, reviewsId);
//    }
//
//    /**
//     * Lista de entidades a DTO.
//     *
//     * Este método convierte una lista de objetos PrizeEntity a una lista de
//     * objetos ReviewDTO (json)
//     *
//     * @param entityList corresponde a la lista de reseñas de tipo Entity que
//     * vamos a convertir a DTO.
//     * @return la lista de reseñas en forma DTO (json)
//     */
//    private List<ReviewDTO> listEntity2DTO(List<ReviewEntity> entityList) {
//        List<ReviewDTO> list = new ArrayList<ReviewDTO>();
//        for (ReviewEntity entity : entityList) {
//            list.add(new ReviewDTO(entity));
//        }
//        return list;
//    }
//    
}
