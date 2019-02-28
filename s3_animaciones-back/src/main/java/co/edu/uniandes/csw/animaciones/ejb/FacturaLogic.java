package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.FacturaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Garc+ia, Porygon Z & Eye of Truth
 */

@Stateless
public class FacturaLogic {
    
    @Inject
    private FacturaPersistence factura;
    
    public FacturaEntity createF(FacturaEntity f) throws BusinessLogicException{
        if(f.getEstado()==null){
            throw new BusinessLogicException("Esta factura tiene Estado nulo, y por esto no se puede crear.");
        }       
        f = factura.create(f);
        return f;
    }
    
    public FacturaEntity getF(Long id){
        FacturaEntity f = factura.find(id);
        return f;
    }
    
    public List<FacturaEntity> getAllF(){
        List<FacturaEntity> alle = factura.findAll();
        return alle;
    }
    
    public FacturaEntity updateF(FacturaEntity f) throws BusinessLogicException{
        if(f.getEstado()==null){
            throw new BusinessLogicException("Esta factura tiene Estado nulo44444, y por esto no se puede actualizar.");
        }
        FacturaEntity newF = factura.update(f);
        return newF;
    }
    
    public void deleteF(Long id){
        factura.delete(id);
    }
}
