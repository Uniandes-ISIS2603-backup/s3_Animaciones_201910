/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.persistence;

import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ld.manrique
 */
@Stateless
public class CalificacionPersistence {
     private final static Logger  LOGGER = Logger.getLogger(FacturaPersistence.class.getName());
    
    @PersistenceContext(unitName = "animacionesPU")
    protected EntityManager em;
    
   /**
     * Crear una calificacion
     *
     * Crea una nueva calificacion con la información recibida en la entidad.
     *
     * @param entity La entidad que representa la nueva calificacion
     * @return La entidad creada
     */
    public CalificacionEntity create(CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Creando un calificacion nuevo");
        em.persist(entity);
        LOGGER.log(Level.INFO, "calificacion creado");
        return entity;
    }
    public List<CalificacionEntity> findAll(){
        
        TypedQuery<CalificacionEntity> qu = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return qu.getResultList();
    }
    /**
     * Actualizar una calificacion
     *
     * Actualiza la entidad que recibe en la base de datos
     *
     * @param entity La entidad actualizada que se desea guardar
     * @return La entidad resultante luego de la acutalización
     */
    public CalificacionEntity update(CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando calificacion con id = {0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Eliminar una calificacion
     *
     * Elimina la reseña asociada al ID que recibe
     *
     * @param reviewsId El ID de la reseña que se desea borrar
     */
    public void delete(Long calificacionId) {
        LOGGER.log(Level.INFO, "Borrando calificacion con id = {0}", calificacionId);
        CalificacionEntity entity = em.find(CalificacionEntity.class, calificacionId);
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar El calificacion con id = {0}", calificacionId);
    }

    /**
     * Buscar una calificacion
     *
     * Busca si hay alguna calificacion asociada a un animacion y con un ID específico
     *
     * @param animacionId El ID del animacion con respecto al cual se busca
     * @param calificacionId El ID de la calificacion buscada
     * @return La reseña encontrada o null. Nota: Si existe una o más reseñas
     * devuelve siempre la primera que encuentra
     */
    public CalificacionEntity find(Long calificacionId) {
        /**LOGGER.log(Level.INFO, "Consultando el calificacion con id = {0} del animacion con id = " + animacionId, calificacionId);
        TypedQuery<CalificacionEntity> q = em.createQuery("select p from CalificacionEntity p where (p.animacion.id = :animacionId) and (p.id = :calificacionId)", CalificacionEntity.class);
        q.setParameter("animacionId", animacionId);
        q.setParameter("calificacionId", calificacionId);
        List<CalificacionEntity> results = q.getResultList();
        CalificacionEntity calificacion = null;
        if (results == null) {
            calificacion = null;
        } else if (results.isEmpty()) {
            calificacion = null;
        } else if (results.size() >= 1) {
            calificacion = results.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar el calificacion con id = {0} del animacion con id =" + animacionId, calificacionId);**/
        return em.find(CalificacionEntity.class, calificacionId);
    }
}
