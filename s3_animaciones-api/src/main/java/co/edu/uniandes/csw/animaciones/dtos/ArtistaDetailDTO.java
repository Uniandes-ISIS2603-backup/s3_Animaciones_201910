package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import java.io.Serializable;
import java.util.ArrayList;
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
        if(ae != null){
            if(ae.getAnimaciones() != null){
                this.animaciones = new ArrayList<>();
                for(AnimacionEntity pae : ae.getAnimaciones()){
                    animaciones.add(new AnimacionDTO(pae));
                }
            }
            if(ae.getPropuestas() != null){
                this.propuestas = new ArrayList<>();
                for(PropuestaEntity pe : ae.getPropuestas()){
                    propuestas.add(new PropuestaDTO(pe));
                }
            }
        }
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
    
    public ArtistaEntity toEntity() {
        ArtistaEntity re = super.toEntity();
        if(animaciones != null){
            ArrayList<AnimacionEntity> listA = new ArrayList<>();
            for(AnimacionDTO adto : animaciones){
                listA.add(adto.toEntity());
            }
            re.setAnimaciones(listA);
        }
        if(propuestas != null){
            ArrayList<PropuestaEntity> listP = new ArrayList<>();
            for(PropuestaDTO pdto : propuestas){
                listP.add(pdto.toEntity());
            }
            re.setPropuestas(listP);
        }
        return re;
    }
    
}
