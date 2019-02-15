package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nicolas Alvarado
 */
@Stateless
public class AnimacionPersistence {
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public AnimacionEntity create(AnimacionEntity ae){
        em.persist(ae);
        return ae;
    }
    
    public AnimacionEntity find(Long aID){
        return em.find(AnimacionEntity.class, aID);
    }
    
    public List<AnimacionEntity> finndAll(){
        Query q = em.createQuery("select u from AnimacionEntity u");
        return q.getResultList();
    }
    
    public AnimacionEntity update(AnimacionEntity ae){
        return em.merge(ae);
    }
    
    public void delete(Long aID){
        AnimacionEntity a = em.find(AnimacionEntity.class, aID);
        em.remove(a);
    }
    
}
