/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author df.perezc
 */
@Stateless
public class ConcursoPersistence {

    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

    public ConcursoEntity create(ConcursoEntity ce) {
        em.persist(ce);
        return ce;
    }

    public ConcursoEntity find(Long concursoEntityId) {
        return em.find(ConcursoEntity.class, concursoEntityId);
    }

    public List<ConcursoEntity> findAll() {
        TypedQuery<ConcursoEntity> query = em.createQuery("select u from ConcursoEntity u", ConcursoEntity.class);
        return query.getResultList();
    }
    
     public ConcursoEntity update(ConcursoEntity ce){
        return em.merge(ce);
    }
     
    public void delete(Long ceId) {
        em.remove(em.find(ConcursoEntity.class, ceId));
    }

}
