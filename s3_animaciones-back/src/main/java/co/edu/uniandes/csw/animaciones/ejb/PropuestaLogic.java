package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.PropuestaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author PZ&EOT
 */
@Stateless
public class PropuestaLogic {
    
    @Inject
    private PropuestaPersistence propuesta;
    
    public PropuestaEntity createP(PropuestaEntity p) throws BusinessLogicException{
        if(p.getPrecio()<0){
            throw new BusinessLogicException("El precio no puede ser negativo");
        }
        p = propuesta.create(p);
        return p;
    }
    
    public PropuestaEntity getP(Long id){
        PropuestaEntity p = propuesta.find(id);
        return p;
    }
    
    public List<PropuestaEntity> getAllP(){
        List<PropuestaEntity> alle = propuesta.findAll();
        return alle;
    }
    
    public PropuestaEntity updateP(PropuestaEntity p) throws BusinessLogicException{
        if(p.getPrecio()<0){
            throw new BusinessLogicException("El precio no debe ser negativo.");
        }
        PropuestaEntity newP = propuesta.update(p);
        return newP;
    }
    
    public void deleteP(Long id){
        propuesta.delete(id);
    }
}
