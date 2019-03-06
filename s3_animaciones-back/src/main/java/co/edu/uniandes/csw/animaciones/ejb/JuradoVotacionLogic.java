package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.JuradoPersistence;
import co.edu.uniandes.csw.animaciones.persistence.VotacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @jurado by.cuta
 */
@Stateless
public class JuradoVotacionLogic {
    
private static final Logger LOGGER = Logger.getLogger(JuradoVotacionLogic.class.getName());

    @Inject
    private VotacionPersistence votacionPersistence;

    @Inject
    private JuradoPersistence juradoPersistence;

    /**
     * Agregar un votacion a la jurado
     *
     * @param votacionsId El identificador de la votacion a guardar
     * @param juradosId El id de la jurado en la cual se va a guardar la votacion
     * @return El votacion creada.
     */
    public VotacionEntity addVotacion(Long votacionsId, Long juradosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un libro a la jurado con id = {0}", juradosId);
        JuradoEntity juradoEntity = juradoPersistence.find(juradosId);
        VotacionEntity votacionEntity = votacionPersistence.find(votacionsId);
        votacionEntity.setJurado(juradoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un libro a la jurado con id = {0}", juradosId);
        votacionPersistence.update(votacionEntity);
        return votacionEntity;
    }

    /**
     * Retorna todos los votacions asociados a una jurado
     *
     * @param juradosId El ID de la jurado buscada
     * @return La lista de libros de la jurado
     */
    public List<VotacionEntity> getVotaciones(Long juradosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los libros asociados a la jurado con id = {0}", juradosId);
        return juradoPersistence.find(juradosId).getVotaciones();
    }

    /**
     * Retorna un votacion asociado a una jurado
     *
     * @param juradosId El id de la jurado a buscar.
     * @param votacionsId El id del libro a buscar
     * @return El libro encontrado dentro de la jurado.
     * @throws BusinessLogicException Si la votacion no se encuentra en los
     * jurados
     */
    public VotacionEntity getVotacion(Long juradosId, Long votacionsId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0} de la jurado con id = " + juradosId, votacionsId);
        List<VotacionEntity> votacions = juradoPersistence.find(juradosId).getVotaciones();
        VotacionEntity votacionEntity = votacionPersistence.find(votacionsId);
        int index = votacions.indexOf(votacionEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0} de la jurado con id = " + juradosId, votacionsId);
        if (index >= 0) {
            return votacions.get(index);
        }
        throw new BusinessLogicException("La votación no está asociada a la jurado");
    }

    /**
     * Remplazar votacions de una jurado
     *
     * @param votacions Lista de votaciones que serán los de la jurados.
     * @param juradosId El id de la jurado que se quiere actualizar.
     * @return La lista de votaciones actualizada.
     */
    public List<VotacionEntity> replaceVotaciones(Long juradosId, List<VotacionEntity> votacions) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la jurado con id = {0}", juradosId);
        JuradoEntity juradoEntity = juradoPersistence.find(juradosId);
        List<VotacionEntity> votacionList = votacionPersistence.findAll();
        for (VotacionEntity votacion : votacionList) {
            if (votacions.contains(votacion)) {
                votacion.setJurado(juradoEntity);
            } else if (votacion.getJurado() != null && votacion.getJurado().equals(juradoEntity)) {
                votacion.setJurado(null);
            }
            votacionPersistence.update(votacion);
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la jurado con id = {0}", juradosId);
        return votacions;
    }
}
