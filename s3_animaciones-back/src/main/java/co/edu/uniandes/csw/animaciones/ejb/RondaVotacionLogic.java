/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
import co.edu.uniandes.csw.animaciones.persistence.VotacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author df.serrano
 */
@Stateless
public class RondaVotacionLogic {
    private static final Logger LOGGER = Logger.getLogger(RondaVotacionLogic.class.getName());

    @Inject
    private VotacionPersistence votacionPersistence;

    @Inject
    private RondaPersistence rondaPersistence;

    /**
     * Agregar un votacion a la Ronda
     *
     * @param votacionsId El identificador de la votacion a guardar
     * @param RondasId El id de la Ronda en la cual se va a guardar la votacion
     * @return El votacion creada.
     */
    public VotacionEntity addVotacion(Long votacionsId, Long rondasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle una votacion a la Ronda con id = {0}", rondasId);
        RondaEntity rondaEntity = rondaPersistence.find(rondasId);
        VotacionEntity votacionEntity = votacionPersistence.find(votacionsId);
        votacionEntity.setRonda(rondaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle una votacion a la Ronda con id = {0}", rondasId);
        votacionPersistence.update(votacionEntity);
        return votacionEntity;
    }

    /**
     * Retorna todos los votacions asociados a una Ronda
     *
     * @param RondasId El ID de la Ronda buscada
     * @return La lista de libros de la Ronda
     */
    public List<VotacionEntity> getVotaciones(Long rondasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las votaciones asociadas a la Ronda con id = {0}", rondasId);
        return rondaPersistence.find(rondasId).getVotaciones();
    }

    /**
     * Retorna un votacion asociado a una Ronda
     *
     * @param RondasId El id de la Ronda a buscar.
     * @param votacionsId El id del libro a buscar
     * @return El libro encontrado dentro de la Ronda.
     * @throws BusinessLogicException Si la votacion no se encuentra en los
     * Rondas
     */
    public VotacionEntity getVotacion(Long RondasId, Long votacionsId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0} de la Ronda con id = " + RondasId, votacionsId);
        List<VotacionEntity> votacions = rondaPersistence.find(RondasId).getVotaciones();
        VotacionEntity votacionEntity = votacionPersistence.find(votacionsId);
        int index = votacions.indexOf(votacionEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0} de la Ronda con id = " + RondasId, votacionsId);
        if (index >= 0) {
            return votacions.get(index);
        }
        throw new BusinessLogicException("La votación no está asociada a la Ronda");
    }

    /**
     * Remplazar votacions de una Ronda
     *
     * @param votacions Lista de votaciones que serán los de la Rondas.
     * @param RondasId El id de la Ronda que se quiere actualizar.
     * @return La lista de votaciones actualizada.
     */
    public List<VotacionEntity> replaceVotaciones(Long rondasId, List<VotacionEntity> votacions) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la Ronda con id = {0}", rondasId);
        RondaEntity rondaEntity = rondaPersistence.find(rondasId);
        List<VotacionEntity> votacionList = votacionPersistence.findAll();
        for (VotacionEntity votacion : votacionList) {
            if (votacions.contains(votacion)) {
                votacion.setRonda(rondaEntity);
            } else if (votacion.getRonda() != null && votacion.getRonda().equals(rondaEntity)) {
                votacion.setRonda(null);
            }
            votacionPersistence.update(votacion);
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la Ronda con id = {0}", rondasId);
        return votacions;
    }
}
