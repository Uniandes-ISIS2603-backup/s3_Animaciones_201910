 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;
import co.edu.uniandes.csw.animaciones.dtos.RondaDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author estudiante
 */
@Path("rondas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RondaResource {
    private static final Logger LOGGER = Logger.getLogger(PropuestaResource.class.getName());
    
    @GET
    public List <RondaDTO> darRondas(){
        return null;
    }
    
    @GET
    @Path("{rondaId: \\d+}")
    public RondaDTO darRonda(@PathParam("rondaId") Long rondaId){
        return null;
    }    
}
