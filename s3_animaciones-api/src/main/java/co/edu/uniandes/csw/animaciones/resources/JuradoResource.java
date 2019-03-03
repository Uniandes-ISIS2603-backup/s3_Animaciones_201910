/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.JuradoDTO;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author by.cuta10
 */
@Path("jurados")
@Produces("application/jason")
@Consumes("application/jason")


public class JuradoResource {
    
    private static final Logger LOGGER = Logger.getLogger(MedioDePagoResource.class.getName());
    
    
    @GET    
    @Path("concursos/{id: \\d+}/jurados")
    public JuradoDTO darJurado (){
        return null;
    }
    
    @POST
    @Path("concursos/{id: \\d+}/jurados")
    public boolean crearJurado (){
        return false;
    }
   
    @PUT
    @Path("concursos/{id: \\d+}/jurados")
    public JuradoDTO updateJurado (){
        return null;
    }
    
    @GET    
    @Path("concursos/{idC : \\d+}/jurados/{idJ : \\d+}")
    public JuradoDTO darUnJurado (){
        return null;
    }
    
    
    @DELETE
    @Path("concursos/{idC : \\d+}/jurados/ {idJ : \\d+}")
    public void eliminarJurado (){
        
    }
    
    public JuradoDTO crearEntity ( JuradoEntity entity)  {
        JuradoEntity nuevo = new JuradoEntity();
        
        return new JuradoDTO();
    }
    
    
}
