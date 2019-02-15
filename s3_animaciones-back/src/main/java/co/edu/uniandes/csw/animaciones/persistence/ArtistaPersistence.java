package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
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
public class ArtistaPersistence {
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public ArtistaEntity createArtista(ArtistaEntity ae){
        em.persist(ae);
        return ae;
    }
    
    public ArtistaEntity findArtista(Long aID){
        return em.find(ArtistaEntity.class, aID);
    }
    
    public List<ArtistaEntity> findAll(){
        Query q = em.createQuery("selec u from ArtistaEntity u");
        return q.getResultList();
    }
    
    public ArtistaEntity updateArtista(ArtistaEntity ae){
        return em.merge(ae);
    }
    
    public void deleteArtista(Long aID){
        ArtistaEntity a = em.find(ArtistaEntity.class, aID);
        em.remove(a);
    }
    
}
