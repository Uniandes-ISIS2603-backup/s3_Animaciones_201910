
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.FacturaDTO;
import co.edu.uniandes.csw.animaciones.dtos.PropuestaDTO;
import co.edu.uniandes.csw.animaciones.ejb.PropuestaLogic;
import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
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
 * @author EYE OF TRUTH
 */
@Path("propuestas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PropuestaResource {
    private static final Logger LOGGER = Logger.getLogger(PropuestaResource.class.getName());
    
    @Inject
    private PropuestaLogic pl;
    
    @POST
    public PropuestaDTO crear(PropuestaDTO yo) throws BusinessLogicException{
        PropuestaEntity fe = pl.createP(yo.toEntity());
        return new PropuestaDTO(fe);
    }
    
    @GET
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO dar(@PathParam("propuestaID") Long id){
        PropuestaEntity fe = pl.getP(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }
        return new PropuestaDTO(fe);
    }
    
    @GET
    @Path("{propuestaID: \\d+}/factura")
    public FacturaDTO darFactura(@PathParam("propuestaID") Long id){
        PropuestaEntity fe = pl.getP(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }
        FacturaEntity yo = fe.getFactura();
        return new FacturaDTO(yo);
    }
    
    @PUT
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO cambiar(PropuestaDTO yo) throws BusinessLogicException{
        PropuestaEntity fe = pl.getP(yo.getId());
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+yo.getId()+" no existe.",404);
        }
        PropuestaEntity fe2 = pl.updateP(yo.toEntity());
        return new PropuestaDTO(fe2);
    }
    
    @DELETE
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO borrar(@PathParam("propuestaID") Long id){
        PropuestaEntity fe = pl.getP(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }
        pl.deleteP(id);
        return new PropuestaDTO(fe);
    }
}
