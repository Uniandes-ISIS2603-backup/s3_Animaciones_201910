package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Nicolas Alvarado
 */
public class AnimacionDetailDTO extends AnimacionDTO implements Serializable {
    
    ArrayList<CalificacionDTO> calificaciones;

    public ArrayList<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
}
