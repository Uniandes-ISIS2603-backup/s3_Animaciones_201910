/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.VotacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author df.serrano
 */
@Stateless
public class VotacionLogic {
    
        @Inject
    private VotacionPersistence persistence;
        @Inject
    private JuradoLogic jl;
           @Inject
    private AnimacionLogic anl;
           @Inject
          private RondaLogic rl;
    
    public VotacionEntity createVotacion(VotacionEntity votacion) throws BusinessLogicException{
        if(votacion.getIdAnimacion()==null || votacion.getIdAnimacion() <= 0){
            throw new BusinessLogicException("El numero de id de animacion tiene que ser mayor a cero");
        }
      // el jurado tiene que existir
      JuradoEntity je = votacion.getJurado();
      if(jl.getJurado(je.getId())==null){
          throw new BusinessLogicException("El jurado tiene que existir");
      }
      // la animacion con ese id tiene que existir
      AnimacionEntity ae = anl.getAnimacion(votacion.getIdAnimacion().longValue());
      if(ae == null)
      {
          throw new BusinessLogicException("La animación tiene que existir");
      }
      //la ronda con ese id tiene que existir

      RondaEntity re = votacion.getRonda();
      if(rl.getRonda(re.getId())==null){
          throw new BusinessLogicException("La ronda tiene que existir");
      }
      
        if(votacion.getPuntos()== null || votacion.getPuntos() < 1 || votacion.getPuntos() > 10){
            System.out.println("puntos:" + votacion.getPuntos());
            throw new BusinessLogicException("El numero de puntos debe ser entre 1 y 10");
        }
        if(votacion.getNumRonda()== null || (votacion.getNumRonda()!= 1 && votacion.getNumRonda()!= 2))
        {
             throw new BusinessLogicException("El numero de la Votacion solo puede ser 1 o 2");
        }
        persistence.create(votacion);
        return votacion;
    }
    
        public VotacionEntity getVotacion(Long id){
        VotacionEntity re = persistence.find(id);
        return re;
    }
    
    public List<VotacionEntity> getVotaciones(){
        List<VotacionEntity> list = persistence.findAll();
        return list;
    }
    
        public VotacionEntity updateVotacion(VotacionEntity votacion) throws BusinessLogicException {
        
                if(votacion.getIdAnimacion()==null || votacion.getIdAnimacion() <= 0){
            throw new BusinessLogicException("El numero de id de animacion tiene que ser mayor a cero");
        }
        // la animacion con ese id tiene que existir
        //la ronda con ese id tiene que existir
        // el jurado tiene que existir
        if(votacion.getPuntos()!= null || votacion.getPuntos() < 1 || votacion.getPuntos() > 10){
            throw new BusinessLogicException("El numero de puntos debe ser entre 1 y 10");
        }
        if(votacion.getNumRonda()!= null || votacion.getNumRonda()!= 1 || votacion.getNumRonda()!= 2)
        {
             throw new BusinessLogicException("El numero de la Votacion solo puede ser 1 o 2");
        }
        VotacionEntity newve = persistence.update(votacion);
        return newve;
    }
    
    public void deleteVotacion(Long id){
        persistence.delete(id);
    }
    
}
