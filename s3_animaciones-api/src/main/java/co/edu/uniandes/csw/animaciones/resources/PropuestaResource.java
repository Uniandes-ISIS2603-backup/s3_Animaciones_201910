package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.FacturaDTO;
import co.edu.uniandes.csw.animaciones.dtos.PropuestaDTO;
import co.edu.uniandes.csw.animaciones.ejb.PropuestaLogic;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * Segundo intento de esta clase 
 * @author Porygon Z & Eye of Truth, parte 2
 */
@Path("propuestas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PropuestaResource {
    
    @Inject
    private PropuestaLogic pl;
    
    @POST
    public PropuestaDTO crear(PropuestaDTO yo) throws BusinessLogicException{
        PropuestaEntity fe = pl.createP(yo.toEntity());
        return new PropuestaDTO(fe);
    }
    
    @GET
    public List<PropuestaDTO> darPropuestas(){
        List<PropuestaEntity> sapos = pl.getAllP();
        List<PropuestaDTO> bigSapos = new ArrayList();
        if (sapos!=null){            
            for(PropuestaEntity sapingo: sapos){
                PropuestaDTO granSapo = new PropuestaDTO(sapingo);
                bigSapos.add(granSapo);
            }
        }
        return bigSapos;
    }
    
    @GET
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO dar(@PathParam("propuestaID") Long id){
        PropuestaEntity fe = pl.getP(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }else{
            return new PropuestaDTO(fe);
        }
    }
    
    @GET
    @Path("{propuestaID: \\d+}/factura")
    public FacturaDTO darFactura(@PathParam("propuestaID") Long id){
        
        PropuestaEntity pe = pl.getP(id);
          if(pe ==null){
            throw new WebApplicationException("Propuesta with id: " + id + " does not exists", 404);
          }else{
            return dar(id).getFactura(); 
          }                  
    }
    
    @PUT
    @Path("{propuestaID: \\d+}")
    public PropuestaDTO cambiar(PropuestaDTO yo, @PathParam("propuestaID") Long id) throws BusinessLogicException{
        PropuestaEntity fe = pl.getP(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }
        PropuestaEntity fe2 = pl.updateP(yo.toEntity());
        return new PropuestaDTO(fe2);
    }
    
    @DELETE
    @Path("{PropuestaID: \\d+}")
    public PropuestaDTO eliminar(@PathParam("propuestaID") Long id){
        PropuestaEntity fe = pl.getP(id);
        if(fe==null){
            throw new WebApplicationException("El recurso con id "+id+" no existe.",404);
        }else{
            pl.deleteP(id);
            return new PropuestaDTO(fe);
        }
    }
    
    
}
