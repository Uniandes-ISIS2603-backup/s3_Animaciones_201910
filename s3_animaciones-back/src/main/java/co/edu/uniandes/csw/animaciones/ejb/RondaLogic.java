/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.serrano
 */
@Stateless
public class RondaLogic {
    
    @Inject
    private RondaPersistence persistence;
    
    public RondaEntity createRonda(RondaEntity ronda) throws BusinessLogicException{
        if(ronda.getFechaFin() == null || ronda.getFechaInicio() == null || ronda.getNumero() == null){
            throw new BusinessLogicException("El numero de la ronda o las fechas no pueden ser nulas");
        }
        if(ronda.getFechaInicio().after(ronda.getFechaFin())){
            throw new BusinessLogicException("La fecha de comienzo no puede ser después de la fecha final");
        }
        if(ronda.getNumero()!= 1 && ronda.getNumero()!= 2)
        {
           throw new BusinessLogicException("El numero de la ronda solo puede ser 1 o 2");
        }
        Calendar cal = new GregorianCalendar(2019, 0, 1);
        if(ronda.getFechaInicio().before(cal.getTime())|| ronda.getFechaFin().before(cal.getTime())){
            throw new BusinessLogicException("Las fechas de las rondas deben ser del minimo del 2019");
        }
        persistence.create(ronda);
        return ronda;
    }
    
        public RondaEntity getRonda(Long id){
        return  persistence.find(id);
    }
    
    public List<RondaEntity> getRondas(){
        List<RondaEntity> list = persistence.findAll();
        return list;
    }
    
        public RondaEntity updateRonda(RondaEntity ronda) throws BusinessLogicException {
        
        if(ronda.getFechaFin() == null || ronda.getFechaInicio() == null || ronda.getNumero() == null){
            throw new BusinessLogicException("El numero de la ronda o las fechas no pueden ser nulas");
        }
        if(ronda.getFechaInicio().after(ronda.getFechaFin())){
            throw new BusinessLogicException("La fecha de comienzo no puede ser después de la fecha final");
        }
        if(ronda.getNumero()!= 1 || ronda.getNumero()!= 2)
        {
             throw new BusinessLogicException("El numero de la ronda solo puede ser 1 o 2");
        }
        Calendar cal = new GregorianCalendar(2019, 0, 1);
        if(ronda.getFechaInicio().before(cal.getTime())|| ronda.getFechaFin().before(cal.getTime())){
            throw new BusinessLogicException("Las fechas de las rondas deben ser del 2019");
        }
        return persistence.update(ronda);
    }
    
    public void deleteRonda(Long id){
        persistence.delete(id);
    }
    
}
