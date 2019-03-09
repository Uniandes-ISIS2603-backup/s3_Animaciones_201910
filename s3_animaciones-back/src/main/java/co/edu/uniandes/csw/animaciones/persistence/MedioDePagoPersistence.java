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
    
    /**
     * Crea un nuevo medio de pago con el Entity que entra como parametro
     * @param medioDePagoEntity
     * @return MedioPagoEntity
     */
    public MedioDePagoEntity create(MedioDePagoEntity medioDePagoEntity){
        em.persist(medioDePagoEntity);
        return medioDePagoEntity;
    }
    /**
     * Encuentra un medio de pago con el id que entra como parametro
     * @param medioDePagoId
     * @return MedioDePagoEntity
     */
    public MedioDePagoEntity find (Long medioDePagoId){
        return em.find(MedioDePagoEntity.class, medioDePagoId);
    }
    /**
     * Encuentra todos los pagos 
     * @return List con los medio de pagos
     */
    public List<MedioDePagoEntity> findAll(){
        TypedQuery<MedioDePagoEntity> query = em.createQuery("select u from MedioDePagoEntity u", MedioDePagoEntity.class);
        return query.getResultList();
    }
    /**
     * Actualiza los medios de pago 
     * @param mdpe
     * @return MedioDePagoEntity
     */
    public MedioDePagoEntity update(MedioDePagoEntity mdpe){
        return em.merge(mdpe);
    }
    /**
     * Elimina un medio de pago con el ID que entra como parametro 
     * @param aID 
     */
    public void delete(Long aID){
        MedioDePagoEntity mdpe = em.find(MedioDePagoEntity.class, aID);
        em.remove(mdpe);
    }
    
}
