package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.CalificacionPersistence;
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
    
    public CalificacionEntity addCalificacion(Long idAnimacion, CalificacionEntity calificacion) throws BusinessLogicException {
        if(calificacion.getCalificacion()== null || calificacion.getComentario()== null ){
            throw new BusinessLogicException("El comentario, o calificación no pueden ser nulos");
        }
        if(calificacion.getCalificacion()<0 || calificacion.getCalificacion()>10){
            throw new BusinessLogicException("La calificación debe ser un número entre 0 y 10");
        }
        
        AnimacionEntity ae = ap.find(idAnimacion);
        
        calificacion.setAnimacion(ae);
        cp.create(calificacion);
        
        ae.getCalificaciones().add(calificacion);
        return calificacion;
    }
    
    public List<CalificacionEntity> getAnimaciones(Long idAnimacion) {
        return ap.find(idAnimacion).getCalificaciones();
    }
    
    public CalificacionEntity getAimacion(Long idAnimacion, Long idCalificacion) {
        List<CalificacionEntity> list = getAnimaciones(idAnimacion);
        CalificacionEntity ce = cp.find(idAnimacion,idCalificacion);
        int i = list.indexOf(ce);
        if(i >= 0){
            return list.get(i);
        }
        return null;
    }
    
    public void deleteCalificacion(Long idAnimacion, Long idCalificacion) {
        AnimacionEntity ae = ap.find(idAnimacion);
        CalificacionEntity ce = cp.find(idAnimacion,idCalificacion);
        ae.getCalificaciones().remove(ce);
    }
    
}
