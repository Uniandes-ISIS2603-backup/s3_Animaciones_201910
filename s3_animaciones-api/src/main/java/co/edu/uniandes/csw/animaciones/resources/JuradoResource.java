
package co.edu.uniandes.csw.animaciones.resources;

import co.edu.uniandes.csw.animaciones.dtos.JuradoDTO;
import co.edu.uniandes.csw.animaciones.ejb.JuradoLogic;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * 
 * @author by.cuta10
 */
@Path("jurados")
@Produces("application/json")
@Consumes("application/json")
public class JuradoResource {
    
    /**
     * 
     */
    @Inject
    private JuradoLogic logic;
    
    @GET
    @Path("all")
    public List<JuradoDTO> darJurados(){
       List<JuradoEntity> sl= logic.getJurados();
       List<JuradoDTO> out=new ArrayList<>();
       for(JuradoEntity ls:sl){
           out.add(new JuradoDTO(ls));
       }
       return out;
    }
    
    @POST
    public JuradoDTO crearJurado (JuradoDTO jurado) throws BusinessLogicException{
        return new JuradoDTO(logic.createJurado(jurado.toentity()));
    }
   
    @PUT
    public JuradoDTO updateJurado (JuradoDTO jurado){
        return new JuradoDTO(logic.updateJurado(jurado.toentity()));
    }
    
    @GET    
    @Path("concursos/jurados/{id: \\d+}")
    public JuradoDTO darUnJurado (@PathParam("id") Long id){
        return  new JuradoDTO(logic.getJurado(id));
    }
 
    @DELETE
    @Path("concursos/{id : \\d+}")
    public void eliminarJurado (@PathParam("id") Long id) throws BusinessLogicException{
        logic.deleteJurado(id);
    }
}
