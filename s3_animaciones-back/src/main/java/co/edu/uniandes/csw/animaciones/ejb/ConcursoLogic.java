/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ConcursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author df.perezc
 */

@Stateless
public class ConcursoLogic {
 
    @Inject
    private ConcursoPersistence cp;
    
     @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

    public ConcursoEntity createConcursoEntity(ConcursoEntity ce)throws BusinessLogicException
    {
        if(cp.find(ce.getId())!=null)
        {
            throw new BusinessLogicException("ya existe un concurso con el id: " + ce.getId()  );
        }
        if(ce.getTema().length()>=100)
        {
         throw new BusinessLogicException("ya existe un concurso con el id: " + ce.getId()  );
        }
        ce = cp.create(ce);
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
