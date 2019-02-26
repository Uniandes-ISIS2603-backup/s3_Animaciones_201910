package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.CalificacionPersistence;
import java.util.ArrayList;
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
    
    public CalificacionEntity addCalificacion(Long idAnimacion, Long idCalificacion) {
        AnimacionEntity ae = ap.find(idAnimacion);
        CalificacionEntity ce = cp.find(idCalificacion);
        ae.getCalificaciones().add(ce);
        return ce;
    }
    
    public ArrayList<CalificacionEntity> getAnimaciones(Long idAnimacion) {
        return ap.find(idAnimacion).getCalificaciones();
    }
    
    public CalificacionEntity getAimacion(Long idAnimacion, Long idCalificacion) {
        ArrayList<CalificacionEntity> list = getAnimaciones(idAnimacion);
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
