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
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la jurado");
        
        // Invoca la persistencia para crear la jurado
        persistence.create(juradoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la jurado");
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
