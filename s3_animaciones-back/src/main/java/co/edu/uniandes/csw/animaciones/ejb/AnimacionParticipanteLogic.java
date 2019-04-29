/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
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

   // @PersistenceContext(unitName = "animacionesPU")
   // protected EntityManager em;

    @Inject
    private AnimacionParticipantePersistence app;

    /**
     * medodo que persiste la entidad de una animacion participante
     * @param ape la animacion participante entity
     * @return  la entidad de la animacion que fue persistida
     * no se nesecita bussinesException porque ya es revisado cuando se crea la 
     * animacion
     */
    public AnimacionParticipanteEntity create(AnimacionParticipanteEntity ape)  {
        
        app.create(ape);
        return ape;
    }

    /**
     * medodo que encuentra la entidad de la animacion participante con el id ingresado
     * @param animacionParticipanteEntityId es el id de la entidad buscada
     * @return la entidad con el id ingresado
     */
    public AnimacionParticipanteEntity find(Long animacionParticipanteEntityId) {
        return app.find( animacionParticipanteEntityId);
    }

    /**
     * metodo que devuelve la lista de todas las entidades de animacionesParticipantes existentes
     * @return la lista de entides de animaciones existentes
     */
    public List<AnimacionParticipanteEntity> findAll() {
        List<AnimacionParticipanteEntity> list = app.findAll();
        return list;
    }

    /**
     * metodo que actualiza una entidad animacion participante
     * @param ape la entidad de animacion participante que se quiere actualizar
     * @return la animacion que se actualizo
     */
    public AnimacionParticipanteEntity update(AnimacionParticipanteEntity ape)throws BusinessLogicException {
       if(ape.getPuesto()==null||ape.getDinero()==null||ape.getFinalista()==null||ape.getPuntaje()==null){
            throw new BusinessLogicException("ningun atributo puede ser null");
        }
        if(ape.getPuesto()<0){
            throw new BusinessLogicException("el puesto no puede ser menor a 0 y es: " + ape.getPuesto());
        }
       if(ape.getPuntaje()<0||5<ape.getPuntaje()){
            throw new BusinessLogicException("el debe estar entre 0 y 5, es: " + ape.getPuntaje());
        }
        if(ape.getDinero()<0){
            throw new BusinessLogicException("Las animaciones tienen que tener un artista");
        }
        
        AnimacionParticipanteEntity nape = app.update(ape);
        return nape;
    }

    /**
     * metodo que borra una animacion participante teniendo su id
     * @param apeId el id de la animacion que se quiere borrar
     */
    // public void delete(Long apeId) {
    //    em.remove(em.find(AnimacionParticipanteEntity.class, apeId));
    //}
    //una vez inscritas las animaciones no deben ser borradas
}
