/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.JuradoPersistence;
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
        LOGGER.log(Level.INFO, "Inicia proceso de creación del jurado");
        
        // Invoca la persistencia para crear la jurado
        persistence.create(juradoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del jurado");
        return juradoEntity;
    }
    
    /**
     * Actualiza la información de una instancia de Jurado.
     *
     * @param juradoId Identificador de la instancia a actualizar
     * @param juradoEntity Instancia de JuradoEntity con los nuevos datos.
     * @return Instancia de JuradoEntity con los datos actualizados.
     */
    public JuradoEntity updateJurado(Long juradoId, JuradoEntity juradoEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el jurado con id = {0}", juradoId);
        JuradoEntity newJuradoEntity = persistence.update(juradoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el jurado con id = {0}", juradoId);
        return newJuradoEntity;
    }
    
    /**
     *
     * Obtener una editorial por medio de su id.
     *
     * @param juradoId: id de la editorial para ser buscada.
     * @return la editorial solicitada por medio de su id.
     */
    public JuradoEntity getJurado(Long juradoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el jurado con id = {0}", juradoId);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        JuradoEntity juradoEntity = persistence.find(juradoId);
        if (juradoEntity == null) {
            LOGGER.log(Level.SEVERE, "El jurado con el id = {0} no existe", juradoId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consulta deñ jurado con id = {0}", juradoId);
        return juradoEntity;
    }
    
    

    /**
     * Borrar un jurado
     *
     * @param juradosId: id de la jurado a borrar
     */
    public void deleteJurado(Long juradosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la jurado con id = {0}", juradosId);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(juradosId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la jurado con id = {0}", juradosId);
    }
   
   
}
