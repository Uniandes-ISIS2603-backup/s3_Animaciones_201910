/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import java.util.List;
import java.util.logging.Level;
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
public class JuradoPersistence {
    private static final Logger LOGGER = Logger.getLogger(JuradoPersistence.class.getName());

    @PersistenceContext (unitName = "animacionesPU")
        protected EntityManager em;
    
    
    public JuradoEntity create (JuradoEntity usuario){
        em.persist(usuario);
        return usuario;
    }
    
    
    public JuradoEntity find (Long userId){
        JuradoEntity find = em.find(JuradoEntity.class, userId);
        return find;
    }
    
    public List<JuradoEntity> getAll (){
        TypedQuery<JuradoEntity> tp = em.createQuery("SELECT j FROM JuradoEntity j", JuradoEntity.class);
        return tp.getResultList();
    }
    
    public JuradoEntity update (JuradoEntity juradoEntity){
        return em.merge(juradoEntity);
    }
    
    public void delete (Long userId){
        JuradoEntity del = find(userId);
        em.remove(del);
    }
    
    public JuradoEntity findByName(String name)
    {
        
        TypedQuery query = em.createQuery("Select e From JuradoEntity e where e.usuario = :name", JuradoEntity.class);

        query = query.setParameter("name", name);

        List<JuradoEntity> sameName = query.getResultList();
        JuradoEntity result;
        if (sameName == null) {
            result = null;
        } else if (sameName.isEmpty()) {
            result = null;
        } else {
            result = sameName.get(0);
        }
  
        return result;
    }

    public List<JuradoEntity> findAll() {
        TypedQuery query = em.createQuery("Select e from JuradoEntity e", JuradoEntity.class);
    return query.getResultList();
    }
}
