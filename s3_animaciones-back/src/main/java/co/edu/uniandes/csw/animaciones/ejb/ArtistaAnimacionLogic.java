package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolas Alvarado
 */
@Stateless
public class ArtistaAnimacionLogic {
    
    @Inject
    private ArtistaPersistence arp;
    
    @Inject
    private AnimacionPersistence anp;
    
    public AnimacionEntity addAnimacion(Long ArtistaId, Long AnimacionId) {
        ArtistaEntity are = arp.findArtista(ArtistaId);
        AnimacionEntity ane = anp.find(AnimacionId);
        are.getAnimaciones().add(ane);
        return ane;
    }
    
    public ArrayList<AnimacionEntity> getAnimaciones(Long artistaId) {
        return arp.findArtista(artistaId).getAnimaciones();
    }
    
    public AnimacionEntity getAnimacion(Long ArtistaId, Long AnimacionId) {
        ArrayList<AnimacionEntity> list = getAnimaciones(ArtistaId);
        AnimacionEntity ane = anp.find(AnimacionId);
        int i = list.indexOf(ane);
        if(i >= 0){
            return list.get(i);
        }
        return null;
    }
    
    public void removeAnimacion(Long ArtistaId, Long AnimacionId) {
        ArtistaEntity are = arp.findArtista(ArtistaId);
        AnimacionEntity ane = anp.find(AnimacionId);
        are.getAnimaciones().remove(ane);
    }
    
}
