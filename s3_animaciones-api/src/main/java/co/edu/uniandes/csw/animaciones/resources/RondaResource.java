 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.resources;
import co.edu.uniandes.csw.animaciones.dtos.RondaDTO;
import co.edu.uniandes.csw.animaciones.dtos.RondaDetailDTO;
import co.edu.uniandes.csw.animaciones.ejb.RondaLogic;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.List;
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
    @Inject
    private RondaLogic rl;
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
    public RondaDTO createRonda(RondaDTO ronda) throws BusinessLogicException {
        RondaEntity re = ronda.toEntity();
        re = rl.createRonda(re);
        return new RondaDTO(re);
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
