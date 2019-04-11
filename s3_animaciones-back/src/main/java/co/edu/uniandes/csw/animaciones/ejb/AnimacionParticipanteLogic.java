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
 *  clase que maneja la logica de la animacion participante
 * @author df.perezc
 */
@Stateless
public class AnimacionParticipanteLogic {

    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;

    @Inject
    private AnimacionParticipantePersistence app;

    /**
     * medodo que persiste la entidad de una animacion participante
     * @param ape la animacion participante entity
     * @return  la entidad de la animacion que fue persistida
     * @throws BusinessLogicException 
     */
    public AnimacionParticipanteEntity create(AnimacionParticipanteEntity ape) throws BusinessLogicException {
        if (app.find(ape.getId()) != null) {
            throw new BusinessLogicException("ya existe un concurso con el id: " + ape.getId());
        }
        em.persist(ape);
        return ape;
    }

    /**
     * medodo que encuentra la entidad de la animacion participante con el id ingresado
     * @param AnimacionParticipanteEntityId es el id de la entidad buscada
     * @return la entidad con el id ingresado
     */
    public AnimacionParticipanteEntity find(Long AnimacionParticipanteEntityId) {
        return em.find(AnimacionParticipanteEntity.class, AnimacionParticipanteEntityId);
    }

    /**
     * metodo que devuelve la lista de todas las entidades de animacionesParticipantes existentes
     * @return la lista de entides de animaciones existentes
     */
    public List<AnimacionParticipanteEntity> findAll() {
        TypedQuery<AnimacionParticipanteEntity> query = em.createQuery("select u from AnimacionParticipanteEntity u", AnimacionParticipanteEntity.class);
        return query.getResultList();
    }

    /**
     * metodo que actualiza una entidad animacion participante
     * @param ape la entidad de animacion participante que se quiere actualizar
     * @return la animacion que se actualizo
     */
    public AnimacionParticipanteEntity update(AnimacionParticipanteEntity ape) {
        return em.merge(ape);
    }

    /**
     * metodo que borra una animacion participante teniendo su id
     * @param apeId el id de la animacion que se quiere borrar
     */
    public void delete(Long apeId) {
        em.remove(em.find(AnimacionParticipanteEntity.class, apeId));
    }
}
