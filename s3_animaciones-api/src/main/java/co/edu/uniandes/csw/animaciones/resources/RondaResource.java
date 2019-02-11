 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;
import co.edu.uniandes.csw.animaciones.dtos.RondaDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    public RondaDTO darRondas(){
        return null;
    }
    
    @POST
    public RondaDTO crearRonda(RondaDTO aCrear){
        return aCrear;
    }
    
}
