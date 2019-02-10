package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Nicolas Alvarado
 */
public class ArtistaDetailDTO extends ArtistaDTO implements Serializable {
    
    ArrayList<AnimacionDTO> animaciones;
    ArrayList<PropuestaDTO> propuestas;

    public ArrayList<AnimacionDTO> getAnimaciones() {
        return animaciones;
    }

    public void setAnimaciones(ArrayList<AnimacionDTO> animaciones) {
        this.animaciones = animaciones;
    }

    public ArrayList<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(ArrayList<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }
    
}
