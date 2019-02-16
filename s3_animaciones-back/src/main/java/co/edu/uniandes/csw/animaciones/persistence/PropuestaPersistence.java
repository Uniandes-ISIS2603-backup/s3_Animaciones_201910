
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author sigo siendo yo; no me he movido de aquí (García)
 */
@Stateless
public class PropuestaPersistence {
    private final static Logger  LOGGER = Logger.getLogger(PropuestaPersistence.class.getName());
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public PropuestaEntity create(PropuestaEntity fE){
        LOGGER.log(Level.INFO,"Creando una propuesta...");
        em.persist(fE);
        LOGGER.log(Level.INFO,"Saliendo del proceso...");
        return fE;
    }
    
    public PropuestaEntity find(Long id){
        return em.find(PropuestaEntity.class, id);
    }
    
    public List<PropuestaEntity> findAll(){
        
        TypedQuery<PropuestaEntity> qu = em.createQuery("select u from PropuestaEntity u", PropuestaEntity.class);
        return qu.getResultList();
    }
}
