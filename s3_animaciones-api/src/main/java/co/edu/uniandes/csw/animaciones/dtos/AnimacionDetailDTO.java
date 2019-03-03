package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas Alvarado
 */
public class AnimacionDetailDTO extends AnimacionDTO implements Serializable {
    
    List<CalificacionDTO> calificaciones;
    
    public AnimacionDetailDTO () {
        
    }
    
    public AnimacionDetailDTO(AnimacionEntity ae){
        super(ae);
        if(ae != null){
            if(ae.getCalificaciones() != null){
                this.calificaciones = new ArrayList<>();
                for(CalificacionEntity ce : ae.getCalificaciones()){
                    calificaciones.add(new CalificacionDTO(ce));
                }
            }
        }
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    public AnimacionEntity toEntity(){
        AnimacionEntity ae = super.toEntity();
        if(calificaciones != null){
            ArrayList<CalificacionEntity> listC = new ArrayList<>();
            for(CalificacionDTO cd : calificaciones){
                listC.add(cd.toEntity());
            }
            ae.setCalificaciones(listC);
        }
        return ae;
    }
    
}
