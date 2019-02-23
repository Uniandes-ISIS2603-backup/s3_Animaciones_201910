/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
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
public class VotacionPersistence {
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public VotacionEntity create(VotacionEntity votacionEntity){
        em.persist(votacionEntity);
        return votacionEntity;
    }
    public VotacionEntity find (Long votacionId){
        return em.find(VotacionEntity.class, votacionId);
    }
    public List<VotacionEntity> findAll(){
        TypedQuery<VotacionEntity> query = em.createQuery("select u from VotacionEntity u", VotacionEntity.class);
        return query.getResultList();
    }
}
