
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author PORYGON Z (García)
 */
@Stateless
public class FacturaPersistence {
    private final static Logger  LOGGER = Logger.getLogger(FacturaPersistence.class.getName());
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public FacturaEntity create(FacturaEntity fE){
        LOGGER.log(Level.INFO,"Creando una factura...");
        em.persist(fE);
        LOGGER.log(Level.INFO,"Saliendo del proceso...");
        return fE;
    }
    
    public FacturaEntity find(Long id){
        return em.find(FacturaEntity.class, id);
    }
    
    public List<FacturaEntity> findAll(){
        
        TypedQuery<FacturaEntity> qu = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        return qu.getResultList();
    }
}
