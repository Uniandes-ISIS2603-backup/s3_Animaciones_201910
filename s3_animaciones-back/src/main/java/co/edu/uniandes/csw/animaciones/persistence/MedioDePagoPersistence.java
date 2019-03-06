package co.edu.uniandes.csw.animaciones.persistence;
import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author df.serrano
 */
@Stateless
public class MedioDePagoPersistence {
    
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public MedioDePagoEntity create(MedioDePagoEntity medioDePagoEntity){
        em.persist(medioDePagoEntity);
        return medioDePagoEntity;
    }
    public MedioDePagoEntity find (Long medioDePagoId){
        return em.find(MedioDePagoEntity.class, medioDePagoId);
    }
    public List<MedioDePagoEntity> findAll(){
        TypedQuery<MedioDePagoEntity> query = em.createQuery("select u from MedioDePagoEntity u", MedioDePagoEntity.class);
        return query.getResultList();
    }
    
        public MedioDePagoEntity update(MedioDePagoEntity mdpe){
        return em.merge(mdpe);
    }
    
    public void delete(Long aID){
        MedioDePagoEntity mdpe = em.find(MedioDePagoEntity.class, aID);
        em.remove(mdpe);
    }
    
}
