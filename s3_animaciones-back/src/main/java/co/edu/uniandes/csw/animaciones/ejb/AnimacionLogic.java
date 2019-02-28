package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolas Alvarado 
 */
@Stateless
public class AnimacionLogic {
    
    @Inject
    private AnimacionPersistence ap;
    
    @Inject
    private ArtistaPersistence arp;
    
    public AnimacionEntity createAnimacion(AnimacionEntity ae) throws BusinessLogicException {
        if(ae.getNombre() == null || ae.getFecha() == null || ae.getLink() == null){
            throw new BusinessLogicException("El nonmbre, fecha o link no puede ser nunlo");
        }
        if(ae.getArtista() == null || arp.findArtista(ae.getArtista().getId()) == null){
            throw new BusinessLogicException("Las animaciones tienen que tener un artista");
        }
        if(ae.getPrecio() < 0){
            throw new BusinessLogicException("El precio tiene que ser positivo");
        }
        ap.create(ae);
        return ae;
    }
    
    public AnimacionEntity getAnimacion(Long id){
        AnimacionEntity ae = ap.find(id);
        return ae;
    }
    
    public List<AnimacionEntity> getAnimaciones(){
        List<AnimacionEntity> list = ap.finndAll();
        return list;
    }
    
    public AnimacionEntity updateAnimacion(AnimacionEntity ae) throws BusinessLogicException {
        if(ae.getNombre() == null || ae.getFecha() == null || ae.getLink() == null){
            throw new BusinessLogicException("El nonmbre, fecha o link no puede ser nunlo");
        }
        if(ae.getArtista() == null){
            throw new BusinessLogicException("Las animaciones tienen que tener un artista");
        }
        if(ae.getPrecio() < 0){
            throw new BusinessLogicException("El precio tiene que ser positivo");
        }
        AnimacionEntity newae = ap.update(ae);
        return newae;
    }
    
    public void deleteAnimacion(Long id){
        ap.delete(id);
    }
    
}
