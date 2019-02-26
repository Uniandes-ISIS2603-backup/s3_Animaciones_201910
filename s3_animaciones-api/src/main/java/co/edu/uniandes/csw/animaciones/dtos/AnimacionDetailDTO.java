package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nicolas Alvarado
 */
public class AnimacionDetailDTO extends AnimacionDTO implements Serializable {
    
    List<CalificacionDTO> calificaciones;
    
    public AnimacionDetailDTO () {
        
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
}
