/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.AnimacionParticipanteEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 * clase que se encarga de la persistencia de la animacion participante
 * @author df.perezc
 */
@Stateless
public class AnimacionParticipantePersistence {

    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

    /**
     * metodo que persiste a la entidad de una animacion participante
     * @param ape entidad de la animacionParticipante a ser persistida
     * @return la entidad de la animacion participante persistida
     */
    public AnimacionParticipanteEntity create(AnimacionParticipanteEntity ape) {
        em.persist(ape);
        return ape;
    }

    /**
     * metodo que retorna la entidad de una animacion participante teniendo su id
     * @param AnimacionParticipanteEntityId la id de la entidad de animacion participante a ser persistida
     * @return la entidad persistida
     */
    public AnimacionParticipanteEntity find(Long AnimacionParticipanteEntityId) {
        return em.find(AnimacionParticipanteEntity.class, AnimacionParticipanteEntityId);
    }

    /**
     * metodo que retorna la lista de todas entidades persistidas de animaciones participantes
     * @return 
     */
    public List<AnimacionParticipanteEntity> findAll() {
        TypedQuery<AnimacionParticipanteEntity> query = em.createQuery("select u from AnimacionParticipanteEntity u", AnimacionParticipanteEntity.class);
        return query.getResultList();
    }

    /**
     * metodo que actualiza una entidad de animacion participante
     * @param ape la entidad actualizda
     * @return la entidad acutalizada
     */
    public AnimacionParticipanteEntity update(AnimacionParticipanteEntity ape) {
        return em.merge(ape);
    }
    
    /**
     * metodo que borra la animacion participante correspondiente a ese id
     * @param apeId 
     */
    public void delete( Long apeId){
        em.remove( em.find(AnimacionParticipanteEntity.class, apeId));
    }
}
