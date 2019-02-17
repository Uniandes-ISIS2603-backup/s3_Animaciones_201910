/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
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
public class ClientePersistence {
    
    
      private final static Logger  LOGGER = Logger.getLogger(FacturaPersistence.class.getName());
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
    public ClienteEntity create(ClienteEntity cE){
        LOGGER.log(Level.INFO,"Creando un cliente...");
        em.persist(cE);
        LOGGER.log(Level.INFO,"Saliendo del proceso...");
        return cE;
    }
    
    public ClienteEntity find(Long id){
        return em.find(ClienteEntity.class, id);
    }
    
    public List<ClienteEntity> findAll(){
        
        TypedQuery<ClienteEntity> qu = em.createQuery("select u from CalificacionEntity u", ClienteEntity.class);
        return qu.getResultList();
    }
    
    public ClienteEntity update(ClienteEntity cE){
        LOGGER.log(Level.INFO, "Actualizando el elemento de ID = {0}", cE.getId());
        return em.merge(cE);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "DESTRUYENDO el elemento de ID = {0}",id);
        ClienteEntity fE = em.find(ClienteEntity.class, id);
        em.remove(fE);
    }
}
