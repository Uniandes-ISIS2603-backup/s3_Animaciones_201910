
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.PropuestaDTO;
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
 * @author EYE OF TRUTH
 */
@Path("propuestas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PropuestaResource {
    private static final Logger LOGGER = Logger.getLogger(PropuestaResource.class.getName());
    
    @POST
    public PropuestaDTO crear(PropuestaDTO yo){
        return yo;
    }
    
    @GET
    @Path("{propuesaID: \\d+}")
    public PropuestaDTO dar(PropuestaDTO yo){
        return yo;
    }
    
    @GET
    @Path("{propuesaID: \\d+}/factura")
    public PropuestaDTO darFactura(PropuestaDTO yo){
        return yo;
    }
    
    @PUT
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO cambiarEstado(PropuestaDTO yo){
        return yo;
    }
    
    @DELETE
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO borrar(PropuestaDTO yo){
        return yo;
    }
}
