/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.JuradoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class JuradoLogic {

    private static final Logger LOGGER = Logger.getLogger(JuradoLogic.class.getName());

    @Inject
    private JuradoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Crea una jurado en la persistencia.
     *
     * @param juradoEntity La entidad que representa la jurado a
     * persistir.
     * @return La entiddad de la jurado luego de persistirla.
     * @throws BusinessLogicException Si la jurado a persistir ya existe.
     */
    public JuradoEntity createJurado(JuradoEntity juradoEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la jurado");
        // Verifica la regla de negocio que dice que no puede haber dos juradoes con el mismo usuario
        if (persistence.findByName(juradoEntity.getUsuario()) != null) {
            throw new BusinessLogicException("Ya existe un Jurado con el usuario \"" + juradoEntity.getUsuario() + "\"");
        }
        // Invoca la persistencia para crear la jurado
        persistence.create(juradoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la jurado");
        return juradoEntity;
    }

    /**
     *
     * Obtener todas las juradoes existentes en la base de datos.
     *
     * @return una lista de juradoes.
     */
    public List<JuradoEntity> getJurados() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las juradoes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<JuradoEntity> jurados = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todas las juradoes");
        return jurados;
    }

    /**
     *
     * Obtener una jurado por medio de su id.
     *
     * @param juradosId: id de la jurado para ser buscada.
     * @return la jurado solicitada por medio de su id.
     */
    public JuradoEntity getJurado(Long juradosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la jurado con id = {0}", juradosId);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        JuradoEntity juradoEntity = persistence.find(juradosId);
        if (juradoEntity == null) {
            LOGGER.log(Level.SEVERE, "La jurado con el id = {0} no existe", juradosId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la jurado con id = {0}", juradosId);
        return juradoEntity;
    }

    /**
     *
     * Actualizar una jurado.
     *
     * @param juradosId: id de la jurado para buscarla en la base de
     * datos.
     * @param juradoEntity: jurado con los cambios para ser actualizada,
     * por ejemplo el nombre.
     * @return la jurado con los cambios actualizados en la base de datos.
     */
    public JuradoEntity updateJurado(JuradoEntity juradoEntity) {
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        JuradoEntity newEntity = persistence.update(juradoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la jurado con id = {0}", juradoEntity.getId());
        return newEntity;
    }

    /**
     * Borrar un jurado
     *
     * @param juradosId: id de la jurado a borrar
     * @throws BusinessLogicException Si la jurado a eliminar tiene libros.
     */
    public void deleteJurado(Long juradosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la jurado con id = {0}", juradosId);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        List<VotacionEntity> books = getJurado(juradosId).getVotaciones();
        if (books != null && !books.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar la jurado con id = " + juradosId + " porque tiene votaciones asociados");
        }
        persistence.delete(juradosId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la jurado con id = {0}", juradosId);
    }
   
   
}
