/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import co.edu.uniandes.csw.animaciones.persistence.CalificacionPersistence;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ld.manrique
 */
@Stateless
public class CalificacionLogic {
    
    @Inject
    private CalificacionPersistence calificacion;
    
     @Inject
    private AnimacionPersistence animacionPersistence;
    
    public CalificacionEntity create(long animacionId, CalificacionEntity temp) throws BusinessLogicException {
        if(temp.getCalificacion()== null || temp.getComentario()== null ){
            throw new BusinessLogicException("El comentario, o calificación no pueden ser nulos");
        }
//        if(temp.getCalificacion()<0 || temp.getCalificacion()>10){
//            throw new BusinessLogicException("La calificación debe ser un número entre 0 y 10");
//        }


   
        AnimacionEntity animacion = animacionPersistence.find(animacionId);
        temp.setAnimacion(animacion);
    
        return calificacion.create(temp);
    }
    
    public CalificacionEntity getCalificacion(Long id){
        CalificacionEntity temp = calificacion.find(id);
        return temp;
    }
    
    public List<CalificacionEntity> getCalificaciones() {
        List<CalificacionEntity> list = calificacion.findAll();
        return list;
    }
    
    public CalificacionEntity update(CalificacionEntity temp) throws BusinessLogicException {
        if(temp.getCalificacion()== null || temp.getComentario()== null ){
            throw new BusinessLogicException("El comentario, o calificación no pueden ser nulos");
        }
       if(temp.getCalificacion()<0 || temp.getCalificacion()>10){
            throw new BusinessLogicException("La calificación debe ser un número entre 0 y 10");
        }
        CalificacionEntity temp2 = calificacion.update(temp);
        return temp2;
    }
    
    public void delete(Long id){
        calificacion.delete(id);
    }
}
