/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.AnimacionGanadoraEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author estudiante
 */
@Stateless
public class AnimacionGanadoraPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(AnimacionGanadoraPersistence.class.getName());

    @PersistenceContext (unitName = "animacionesPU")
        protected EntityManager em;
    
    
    public AnimacionGanadoraEntity create (AnimacionGanadoraEntity usuario){
        em.persist(usuario);
        return usuario;
    }
    
    
    public AnimacionGanadoraEntity find (Long userId){
        AnimacionGanadoraEntity find = em.find(AnimacionGanadoraEntity.class, userId);
        return find;
    }
    
    public List<AnimacionGanadoraEntity> getAll (){
        TypedQuery<AnimacionGanadoraEntity> tp = em.createQuery("SELECT a FROM AnimacionGanadoraEntity a", AnimacionGanadoraEntity.class);
        return tp.getResultList();
    }
    
    public AnimacionGanadoraEntity update (AnimacionGanadoraEntity animacionGanadoraEntity){
        return em.merge(animacionGanadoraEntity);
    }
    
    public void delete (Long userId){
        AnimacionGanadoraEntity del = find(userId);
        em.remove(del);
    }
    
}
