package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.CalificacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolas Alvarado
 */
@Stateless
public class AnimacionCalificacionLogic {
    
    @Inject
    private AnimacionPersistence ap;
    
    @Inject
    private CalificacionPersistence cp;
    
    @Inject
    private ClientePersistence clp;
    
    public CalificacionEntity addCalificacion(Long idAnimacion, CalificacionEntity calificacion) throws BusinessLogicException {
        if(calificacion.getCalificacion()== null || calificacion.getComentario()== null ){
            throw new BusinessLogicException("El comentario, o calificación no pueden ser nulos");
        }
        if(calificacion.getCalificacion()<0 || calificacion.getCalificacion()>10){
            throw new BusinessLogicException("La calificación debe ser un número entre 0 y 10");
        }
        
        AnimacionEntity ae = ap.find(idAnimacion);
        ClienteEntity ce = clp.find(calificacion.getCliente().getId());
        
        calificacion.setAnimacion(ae);
        calificacion.setCliente(ce);
        cp.create(calificacion);
        
        ae.getCalificaciones().add(calificacion);
        return calificacion;
    }
    
    public CalificacionEntity update(CalificacionEntity entity) {
        cp.update(entity);
        return entity;
    }
    
    public List<CalificacionEntity> getAnimaciones(Long idAnimacion) {
        return ap.find(idAnimacion).getCalificaciones();
    }
    
    public CalificacionEntity getAimacion(Long idAnimacion, Long idCalificacion) {
        List<CalificacionEntity> list = getAnimaciones(idAnimacion);
        CalificacionEntity ce = cp.find(idCalificacion);
        int i = list.indexOf(ce);
        if(i >= 0){
            return list.get(i);
        }
        return null;
    }
    
    public void deleteCalificacion(Long idAnimacion, Long idCalificacion) {
        AnimacionEntity ae = ap.find(idAnimacion);
        CalificacionEntity ce = cp.find(idCalificacion);
        ae.getCalificaciones().remove(ce);
    }
    
}
