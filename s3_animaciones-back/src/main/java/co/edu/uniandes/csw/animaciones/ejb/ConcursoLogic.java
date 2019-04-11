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
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que maneja la logica de un concurso
 * @author df.perezc
 */

@Stateless
public class ConcursoLogic {
    
    
    @Inject
    private ConcursoPersistence cp;
    
     @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

     /**
      * medoto que crea la entidad de un concurso
      * @param ce es el concurso qeu se quiere crear
      * @return el concurso que se crea
      * @throws BusinessLogicException se lanza si el tema es demasiado largo
      */
    public ConcursoEntity createConcursoEntity(ConcursoEntity ce)throws BusinessLogicException
    {
        if(ce.getTema().length()>=100)
        {
         throw new BusinessLogicException("el tema del concurso debe tener menos de 100 caracteres " + ce.getTema() );
        }
        
        ce = cp.create(ce);
        return ce;
    }
    
    /**
     * metodo que retorna un concurso teniendo su id
     * @param concursoEntityId la id del concurso buscado
     * @return el concurso correspondiente a la id ingresada
     */
     public ConcursoEntity find(Long concursoEntityId) {
        return em.find(ConcursoEntity.class, concursoEntityId);
    }

     /**
      * metodo que retorna la lista de todas las entidades de concursos
      * @return la lista del entidades de los concursos
      */
    public List<ConcursoEntity> findAll() {
        TypedQuery<ConcursoEntity> query = em.createQuery("select u from ConcursoEntity u", ConcursoEntity.class);
        return query.getResultList();
    }
    
    /** 
     * metodo que actualiza la entidad un concurso 
     * @param ce la entidad que va a actualizar el concurso
     * @return la entidad actualizada
     */
     public ConcursoEntity update(ConcursoEntity ce){
        return em.merge(ce);
    }
     
     /**
      * metodo que borra la entidad de un concurso teniendo su id
      * @param ceId la id de la entidad del concurso a eliminar
      */
    public void delete(Long ceId) {
        em.remove(em.find(ConcursoEntity.class, ceId));
    }
    
    
}
