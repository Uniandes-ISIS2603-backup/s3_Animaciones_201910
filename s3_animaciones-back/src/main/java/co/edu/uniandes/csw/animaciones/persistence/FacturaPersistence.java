
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
