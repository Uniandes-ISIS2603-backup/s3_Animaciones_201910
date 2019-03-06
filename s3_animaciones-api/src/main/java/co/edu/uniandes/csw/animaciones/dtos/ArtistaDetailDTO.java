package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nicolas Alvarado
 */
public class ArtistaDetailDTO extends ArtistaDTO implements Serializable {
    
    List<AnimacionDTO> animaciones;
    List<PropuestaDTO> propuestas;
    
    public ArtistaDetailDTO () {
        
    }
    
    public ArtistaDetailDTO(ArtistaEntity ae){
        super(ae);
    }

    public List<AnimacionDTO> getAnimaciones() {
        return animaciones;
    }

    public void setAnimaciones(List<AnimacionDTO> animaciones) {
        this.animaciones = animaciones;
    }

    public List<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(List<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }
    
}
