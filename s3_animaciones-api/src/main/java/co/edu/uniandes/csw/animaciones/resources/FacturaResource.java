
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.FacturaDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author PORYGON Z
 */
@Path("facturas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class FacturaResource {
    private static final Logger LOGGER = Logger.getLogger(FacturaResource.class.getName());
    
    @POST
    public FacturaDTO crearFactura(FacturaDTO yo){
      return yo;  
    }
    
    @PUT
    @Path("{facturaID: \\d+}/mdp")
    public FacturaDTO actualizarMDP(FacturaDTO yo){
        return yo;
    }
    
    @PUT
    @Path("{facturaID: \\d+}")
    public FacturaDTO cambiarEstado(FacturaDTO yo){
        return yo;
    }
    
    @GET
    @Path("{facturaID: \\d+}/mdp")
    public FacturaDTO darMDP(){
        return null;
    }
    
    @GET
    @Path("{facturaID: \\d+}")
    public FacturaDTO dar(){
        return null;
    }
}
