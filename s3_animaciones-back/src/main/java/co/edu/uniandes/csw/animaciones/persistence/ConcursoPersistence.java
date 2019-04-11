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
 *  clase que se encarga de la persistencia de un concurso
 * @author df.perezc
 */
@Stateless
public class ConcursoPersistence {

    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

    /**
     * metodo que persiste el concurso
     * @param ce el concurso a ser persistido
     * @return el concurso persistido
     */
    public ConcursoEntity create(ConcursoEntity ce) {
        em.persist(ce);
        return ce;
    }

    /**
     * metodo que encuentra un concurso persistido
     * @param concursoEntityId la id de un concurso persistido
     * @return el concurso que fue persistido
     */
    public ConcursoEntity find(Long concursoEntityId) {
        return em.find(ConcursoEntity.class, concursoEntityId);
    }

    /**
     * la lista con todas  las entidades de concursos persistidas
     * @return 
     */
    public List<ConcursoEntity> findAll() {
        TypedQuery<ConcursoEntity> query = em.createQuery("select u from ConcursoEntity u", ConcursoEntity.class);
        return query.getResultList();
    }
    
    /**
     * metodo que actualiza un la entidad de un concurso
     * @param ce la entidad concurso actualizada
     * @return la entidad concurso actualizada
     */
     public ConcursoEntity update(ConcursoEntity ce){
        return em.merge(ce);
    }
     
     /**
      * metodo que borra la entidad de un concurso teniendo su id
      * @param ceId la id del la entidad del concurso
      */
    public void delete(Long ceId) {
        em.remove(em.find(ConcursoEntity.class, ceId));
    }

}
