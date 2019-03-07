package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolas Alvarado
 */
@Stateless
public class ArtistaLogic {
    
    @Inject
    private ArtistaPersistence ap;
    
    public ArtistaEntity createArtista(ArtistaEntity ae) throws BusinessLogicException {
        if(ae.getNombre() == null || ae.getUsuario() == null || ae.getContrasenia() == null){
            throw new BusinessLogicException("El nombre, usuario o contrasena no pueden ser nulos");
        }
        if(ap.findByUser(ae.getUsuario()) != null){
            throw new BusinessLogicException("El nombre de usuario ya existe");
        }
        ap.createArtista(ae);
        return ae;
    }
    
    public ArtistaEntity getArtista(Long id){
        ArtistaEntity ae = ap.findArtista(id);
        return ae;
    }
    
    public List<ArtistaEntity> getArtistas() {
        List<ArtistaEntity> list = ap.findAll();
        return list;
    }
    
    public ArtistaEntity updateArtista(ArtistaEntity ae) throws BusinessLogicException {
        if(ae.getNombre() == null || ae.getUsuario() == null || ae.getContrasenia() == null){
            throw new BusinessLogicException("El nombre, usuario o contrasena no pueden ser nulos");
        }
        if(ap.findByUser(ae.getUsuario()) != null){
            throw new BusinessLogicException("El nombre de usuario ya existe");
        }
        ArtistaEntity ae2 = ap.updateArtista(ae);
        return ae2;
    }
    
    public void deleteArtista(Long id){
        ap.deleteArtista(id);
    }
    
}
