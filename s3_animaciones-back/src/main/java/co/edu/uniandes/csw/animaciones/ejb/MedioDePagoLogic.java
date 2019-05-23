/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.MedioDePagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ejb.Stateless;

/**
 *
 * @author estudiante
 */
@Stateless
public class MedioDePagoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(MedioDePagoLogic.class.getName());

    @Inject
    private MedioDePagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Crea una medioDePago en la persistencia.
     *
     * @param medioDePagoEntity La entidad que representa la medioDePago a
     * persistir.
     * @return La entiddad de la medioDePago luego de persistirla.
     * @throws BusinessLogicException Si la medioDePago a persistir ya existe.
     */
    public MedioDePagoEntity createMedioDePago(MedioDePagoEntity medioDePagoEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la medioDePago");
        // Verifica la regla de negocio que dice que no puede haber dos medioDePagoes con el mismo nombre
        // Invoca la persistencia para crear la medioDePago
        persistence.create(medioDePagoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la medioDePago");
        return medioDePagoEntity;
    }
    
        
    /**
     * Actualiza la información de una instancia de MedioDePago.
     *
     * @param medioDePagoId Identificador de la instancia a actualizar
     * @param medioDePagoEntity Instancia de MedioDePagoEntity con los nuevos datos.
     * @return Instancia de MedioDePagoEntity con los datos actualizados.
     */
    public MedioDePagoEntity updateMedioDePago(Long medioDePagoId, MedioDePagoEntity medioDePagoEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el medioDePago con id = {0}", medioDePagoId);
        MedioDePagoEntity newMedioDePagoEntity = persistence.update(medioDePagoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el medioDePago con id = {0}", medioDePagoId);
        return newMedioDePagoEntity;
    }
    
    /**
     *
     * Obtener una editorial por medio de su id.
     *
     * @param medioDePagoId: id de la editorial para ser buscada.
     * @return la editorial solicitada por medio de su id.
     */
    public MedioDePagoEntity getMedioDePago(Long medioDePagoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el medioDePago con id = {0}", medioDePagoId);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        MedioDePagoEntity medioDePagoEntity = persistence.find(medioDePagoId);
        if (medioDePagoEntity == null) {
            LOGGER.log(Level.SEVERE, "El medioDePago con el id = {0} no existe", medioDePagoId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consulta deñ medioDePago con id = {0}", medioDePagoId);
        return medioDePagoEntity;
    }
    
    public List<MedioDePagoEntity> getAll (){
        return persistence.findAll();
    }
    
    

    /**
     * Borrar un medioDePago
     *
     * @param medioDePagosId: id de la medioDePago a borrar
     */
    public void deleteMedioDePago(Long medioDePagosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la medioDePago con id = {0}", medioDePagosId);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(medioDePagosId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la medioDePago con id = {0}", medioDePagosId);
    }
 
}
