/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ld.manrique
 */
@Stateless
public class CalificacionPersistence {
     private final static Logger  LOGGER = Logger.getLogger(FacturaPersistence.class.getName());
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public CalificacionEntity create(CalificacionEntity cE){
        LOGGER.log(Level.INFO,"Creando una calificacion...");
        em.persist(cE);
        LOGGER.log(Level.INFO,"Saliendo del proceso...");
        return cE;
    }
    
    public CalificacionEntity find(Long id){
        return em.find(CalificacionEntity.class, id);
    }
    
    public List<CalificacionEntity> findAll(){
        
        TypedQuery<CalificacionEntity> qu = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return qu.getResultList();
    }
    
    public CalificacionEntity update(CalificacionEntity cE){
        LOGGER.log(Level.INFO, "Actualizando el elemento de ID = {0}", cE.getId());
        return em.merge(cE);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "DESTRUYENDO el elemento de ID = {0}",id);
        CalificacionEntity fE = em.find(CalificacionEntity.class, id);
        em.remove(fE);
    }
}
