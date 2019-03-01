
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.FacturaDTO;
import co.edu.uniandes.csw.animaciones.dtos.MedioDePagoDTO;
import co.edu.uniandes.csw.animaciones.ejb.FacturaLogic;
import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

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
    
    @Inject
    private FacturaLogic fl;
    
    @POST
    public FacturaDTO crearFactura(FacturaDTO yo) throws BusinessLogicException{
        FacturaEntity fe = fl.createF(yo.toEntity());
        return new FacturaDTO(fe);  
    }
    
    @PUT
    @Path("{facturaID: \\d+}")
    public FacturaDTO actualizar(FacturaDTO yo) throws BusinessLogicException{
        FacturaEntity fe2 = fl.getF(yo.getId());
        if(fe2==null){
            throw new WebApplicationException("El recurso con id "+yo.getId()+" no existe.",404);
        }
        FacturaEntity fe = fl.updateF(yo.toEntity());
        return new FacturaDTO(fe);
    }
    /*
    @PUT
    @Path("{facturaID: \\d+}/mdp")
    public FacturaDTO cambiarMDP(MedioDePagoDTO yo, @PathParam("facturaID") Long id) throws BusinessLogicException{
        FacturaEntity fe = fl.getF(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }
        MedioDePagoEntity mdp = yo.toEntity();
        fe.setMedioDePago(mdp);
        fe = fl.updateF(mdp);
        return new FacturaDTO(fe);
    }*/
    
    @GET
    @Path("{facturaID: \\d+}/mdp")
    public MedioDePagoDTO darMDP(@PathParam("facturaID") Long id){
        FacturaEntity fe = fl.getF(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }
        MedioDePagoEntity mdpe = fe.getMedioDePago();
        //return new MedioDePagoDTO(mdpe);
        return null;
    }
    
    @GET
    @Path("{facturaID: \\d+}")
    public FacturaDTO dar(@PathParam("facturaID") Long id){
        FacturaEntity fe = fl.getF(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }else{
            return new FacturaDTO(fe);  
        } 
    }
}
