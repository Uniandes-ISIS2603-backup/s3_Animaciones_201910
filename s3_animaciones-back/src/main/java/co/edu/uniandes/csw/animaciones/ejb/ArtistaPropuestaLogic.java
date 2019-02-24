package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
import co.edu.uniandes.csw.animaciones.persistence.PropuestaPersistence;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolas Alvarado
 */
@Stateless
public class ArtistaPropuestaLogic {
    
    @Inject
    private ArtistaPersistence ap;
    
    @Inject
    private PropuestaPersistence pp;
    
    public PropuestaEntity addPropuesta(Long ArtistaId, Long PropuestaId) {
        ArtistaEntity ae = ap.findArtista(ArtistaId);
        PropuestaEntity pe = pp.find(PropuestaId);
        ae.getPropuestas().add(pe);
        return pe;
    }
    
    public ArrayList<PropuestaEntity> getPrestamos(Long ArtistaId) {
        return ap.findArtista(ArtistaId).getPropuestas();
    }
    
    public PropuestaEntity getPropuesta(Long ArtistaId, Long PropuestaId) {
        ArrayList<PropuestaEntity> list = getPrestamos(ArtistaId);
        PropuestaEntity pe = pp.find(PropuestaId);
        int i = list.indexOf(pe);
        if(i >= 0){
            return list.get(i);
        }
        return null;
    }
    
    public void removePropuesta(Long ArtistaId, Long PropuestaId) {
        ArtistaEntity ae = ap.findArtista(ArtistaId);
        PropuestaEntity pe = pp.find(PropuestaId);
        ae.getPropuestas().remove(pe);
    }
    
}
