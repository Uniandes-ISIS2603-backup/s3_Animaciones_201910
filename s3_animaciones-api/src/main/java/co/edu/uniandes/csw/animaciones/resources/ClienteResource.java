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
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteResource {
      @Inject
    private ClienteLogic logic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(co.edu.uniandes.csw.animaciones.resources.ClienteResource.class.getName());
    private static final String A = "No existe";
    private static final String B = "El Cliente";
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
    
   /**
     * Busca el cliente con el id asociado recibido en la URL y lo devuelve.
     *
     * @param clienteId Identificador del cliente que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link AuthorDetailDTO} - El cliente buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el cliente.
     */
    @GET
    @Path("{clienteId: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("clienteId") Long clienteId) {
        LOGGER.log(Level.INFO, "ClienteResource getCliente: input: {0}", clienteId);
        ClienteEntity entity = logic.getCliente(clienteId);
        if (entity == null) {
            throw new WebApplicationException(B + clienteId + A, 404);
        }
        ClienteDetailDTO detailDTO = new ClienteDetailDTO(entity);
        LOGGER.log(Level.INFO, "ClienteResource getCliente: output: {0}", detailDTO);
        return detailDTO;
    }
    
     /**
     * Convierte una lista de ClienteEntity a una lista de ClienteDetailDTO.
     *
     * @param entityList Lista de ClienteEntity a convertir.
     * @return Lista de ClienteDetailDTO convertida.
     */
    private List<ClienteDetailDTO> listEntity2DTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList<>();
        for (ClienteEntity entity : entityList) {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Busca y devuelve todos los clientes que existen en la aplicacion.
     *
     * @return JSONArray {@link ClienteDetailDTO} - Los clientes encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ClienteDetailDTO> getClientes() {
        LOGGER.info("ClienteResource getClientes: input: void");
        List<ClienteDetailDTO> lista = listEntity2DTO(logic.getClientes());
        LOGGER.log(Level.INFO, "ClienteResource getClientes: output: {0}", lista);
        return lista;
    }    
    
    /**
     * Actualiza el cliente con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param clienteId Identificador del cliente que se desea actualizar. Este
     * debe ser una cadena de dígitos.
     * @param cliente {@link ClienteDto} El cliente que se desea guardar.
     * @return JSON {@link ClienteDto} - El cliente guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el cliente a
     * actualizar.
     */
    @PUT
    @Path("{clienteId: \\d+}")
    public ClienteDetailDTO updateCliente(@PathParam("clienteId") Long clienteId, ClienteDTO cliente) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "ClienteResource updateCliente: input: clienteId: {0} , cliente: {1}", new Object[]{clienteId, cliente});
        cliente.setId(clienteId);
        if (logic.getCliente(clienteId) == null) {
            throw new WebApplicationException(B + clienteId + A, 404);
        }
        ClienteDetailDTO detailDTO = new ClienteDetailDTO(logic.update( cliente.toEntity()));
        LOGGER.log(Level.INFO, "ClienteResource updateCliente: output: {0}", detailDTO);
        return detailDTO;
    }

    /**
     * Borra el cliente con el id asociado recibido en la URL.
     *
     * @param clienteId Identificador del cliente que se desea borrar. Este debe
     * ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     * si el cliente tiene  asociados
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra el cliente a borrar.
     */
    @DELETE
    @Path("{clienteId: \\d+}")
    public void deleteCliente(@PathParam("clienteId") Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "ClienteResource deleteCliente: input: {0}", clienteId);
        if (logic.getCliente(clienteId) == null) {
            throw new WebApplicationException(B + clienteId + A, 404);
        }
        logic.delete(clienteId);
        LOGGER.info("ClienteResource deleteCliente: output: void");
    }

    
}
