/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
import java.util.Date;
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
            // throw new BusinessLogicException("El numero de la ronda solo puede ser 1 o 2");
        }
        // que la ronda le pertenezca a un concurso
        // que la un concurso solo puede tener una ronda 2 si ya tenía creada una ronda 1
        if(ronda.getFechaInicio().before(new Date(119, 0, 1))|| ronda.getFechaInicio().before(new Date(119, 0, 1))){
            throw new BusinessLogicException("Las fechas de las rondas deben ser del 2019");
        }
        persistence.create(ronda);
        return ronda;
    }
    
        public RondaEntity getRonda(Long id){
        RondaEntity re = persistence.find(id);
        return re;
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
        // que la ronda le pertenezca a un concurso
        // que la un concurso solo puede tener una ronda 2 si ya tenía creada una ronda 1
        if(ronda.getFechaInicio().before(new Date(119, 0, 1))|| ronda.getFechaFin().before(new Date(119, 0, 2))){
            throw new BusinessLogicException("Las fechas de las rondas deben ser del 2019");
        }
        RondaEntity newre = persistence.update(ronda);
        return newre;
    }
    
    public void deleteRonda(Long id){
        persistence.delete(id);
    }
    
}
