/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
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
public class RondaPersistence {
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public RondaEntity create(RondaEntity rondaEntity){
        em.persist(rondaEntity);
        return rondaEntity;
    }
    public RondaEntity find (Long rondaId){
        return em.find(RondaEntity.class, rondaId);
    }
    public List<RondaEntity> findAll(){
        TypedQuery<RondaEntity> query = em.createQuery("select u from RondaEntity u", RondaEntity.class);
        return query.getResultList();
    }
}
