/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;


import co.edu.uniandes.csw.animaciones.dtos.ClienteDTO;
import co.edu.uniandes.csw.animaciones.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.animaciones.ejb.ClienteLogic;
import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

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

/**
 *
 * @author ld.manrique
 */
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteResource {
      @Inject
    private ClienteLogic logic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(co.edu.uniandes.csw.animaciones.resources.ClienteResource.class.getName());
    
    @POST
    public ClienteDTO crearCliente(ClienteDTO dto) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "ClientenResource create: input: {0}", dto);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
       ClienteEntity entity = dto.toEntity();
        // Invoca la lógica para crear la calificación nueva
        ClienteEntity nuevoEntity = logic.create(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        ClienteDTO nuevoDTO = new ClienteDTO(nuevoEntity);
        LOGGER.log(Level.INFO, "ClienteResource create: output: {0}", nuevoDTO);
        return nuevoDTO;
    }
    
    @GET
    @Path("{clienteId: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("clienteId") Long clienteId){
        return null;
    }
    
    /**
     * Busca y devuelve todos los autores que existen en la aplicacion.
     *
     * @return JSONArray {@link AuthorDetailDTO} - Los autores encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
//    @GET
//    public List<ClienteDetailDTO> getClientes() {
//        LOGGER.info("ClienteResource getClientes: input: void");
//        List<ClienteDetailDTO> lista = listEntity2DTO(logic.getClientes());
//        LOGGER.log(Level.INFO, "AuthorResource getAuthors: output: {0}", listaAuthors);
//        return listaAuthors;
//    }    
    
    @DELETE
    @Path("{clienteId: \\d+}")
    public void deleteCliente(@PathParam("clienteId") Long clienteId){
        
    }
    
}
