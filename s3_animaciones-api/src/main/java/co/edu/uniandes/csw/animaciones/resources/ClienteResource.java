/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.ClienteDTO;
import co.edu.uniandes.csw.animaciones.dtos.ClienteDetailDTO;

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
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
    
    @POST
    public ClienteDTO crearArtista(ClienteDTO cliente){
        return cliente;
    }
    
    @GET
    @Path("{clienteId: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("clienteId") Long clienteId){
        return null;
    }
    
    @GET
    public ArrayList<ClienteDetailDTO> getClientes(){
        return null;
    }
    
    
    @DELETE
    @Path("{clienteId: \\d+}")
    public void deleteCliente(@PathParam("clienteId") Long clienteId){
        
    }
    
}
