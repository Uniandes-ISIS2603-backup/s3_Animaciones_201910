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
import javax.ws.rs.Produces;

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
    
    @POST
    public CalificacionDTO create(CalificacionDTO dto) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "CalificacionResource create: input: {0}", dto);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        CalificacionEntity entity = dto.toEntity();
        // Invoca la lógica para crear la calificación nueva
        CalificacionEntity nuevoEntity = logic.create(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        CalificacionDTO nuevoDTO = new CalificacionDTO(nuevoEntity);
        LOGGER.log(Level.INFO, "CalificacionResource create: output: {0}", nuevoDTO);
        return nuevoDTO;
    }
    
    @GET
    @Path("{calificacionID: \\d+}")
    public CalificacionDTO get(){
        return null;
    }
    
   
    
    @PUT
    @Path("{calificacionID: \\d+}")
    public CalificacionDTO update(CalificacionDTO dto){
        return dto;
    }
    
    @DELETE
    @Path("{calificacionID: \\d+}")
    public CalificacionDTO delete(CalificacionDTO dto){
        return dto;
    }
    
}
