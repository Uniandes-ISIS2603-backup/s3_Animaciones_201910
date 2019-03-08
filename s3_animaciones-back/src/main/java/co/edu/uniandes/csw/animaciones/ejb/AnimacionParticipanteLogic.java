/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionParticipanteEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionParticipantePersistence;
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
public class AnimacionParticipanteLogic {

    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

    @Inject
    private AnimacionParticipantePersistence app;

    public AnimacionParticipanteEntity create(AnimacionParticipanteEntity ape) throws BusinessLogicException {
        if (app.find(ape.getId()) != null) {
            throw new BusinessLogicException("ya existe un concurso con el id: " + ape.getId());
        }
        em.persist(ape);
        return ape;
    }

    public AnimacionParticipanteEntity find(Long AnimacionParticipanteEntityId) {
        return em.find(AnimacionParticipanteEntity.class, AnimacionParticipanteEntityId);
    }

    public List<AnimacionParticipanteEntity> findAll() {
        TypedQuery<AnimacionParticipanteEntity> query = em.createQuery("select u from AnimacionParticipanteEntity u", AnimacionParticipanteEntity.class);
        return query.getResultList();
    }

    public AnimacionParticipanteEntity update(AnimacionParticipanteEntity ape) {
        return em.merge(ape);
    }

    public void delete(Long apeId) {
        em.remove(em.find(AnimacionParticipanteEntity.class, apeId));
    }
}
