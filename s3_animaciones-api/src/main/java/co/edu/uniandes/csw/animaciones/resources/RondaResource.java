 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;
import co.edu.uniandes.csw.animaciones.dtos.RondaDTO;
import co.edu.uniandes.csw.animaciones.dtos.RondaDetailDTO;
import java.util.List;
import java.util.logging.Logger;
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
 * @author df.serrano
 */
@Path("rondas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RondaResource {
    private static final Logger LOGGER = Logger.getLogger(RondaResource.class.getName());
    
    @GET
    public List <RondaDetailDTO> darRondas(){
        return null;
    }
    
    @GET
    @Path("{rondaId: \\d+}")
    public RondaDetailDTO darRonda(@PathParam("rondaId") Long rondaId){
        return null;
    }    
    @POST
    public RondaDTO crearRonda(RondaDTO ronda) {
        return ronda;
    }
    @PUT
       @Path("{rondaId: \\d+}")
    public RondaDTO cambiarRonda(@PathParam("rondaId") Long rondaId, RondaDTO ronda){
        return ronda;
    }
    @DELETE
    @Path("{rondaId: \\d+}")
    public RondaDTO eliminarRonda(@PathParam("rondaId") Long rondaId){
        return null;
    }
}
