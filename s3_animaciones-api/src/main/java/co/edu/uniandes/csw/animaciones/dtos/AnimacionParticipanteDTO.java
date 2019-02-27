/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.AnimacionParticipanteEntity;
import co.edu.uniandes.csw.animaciones.test.logic.AnimacionParticipanteLogic;
import java.io.Serializable;
import javax.inject.Inject;
/**
 *
 * @author df.perezc
 */
public class AnimacionParticipanteDTO extends AnimacionDTO implements Serializable
{
    //
    // ATRIBUTOS
    //
  
    private Double puntaje;
    private Integer puesto;
    private Boolean finalista;
    private Integer dinero;
    
    /**clase250219
    @Inject
    AnimacionParticipanteLogic apl;
    */
    
    //
    //CONSTRUCTOR
    //
    
    /**
     * constructor
     */
    public AnimacionParticipanteDTO(){
        
    }
    
    
    
    //
    //METODOS
    //

    /**
     * @return the puntaje
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the puesto
     */
    public Integer getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    /**
     * @return the finalista
     */
    public Boolean getFinalista() {
        return finalista;
    }

    /**
     * @param finalista the finalista to set
     */
    public void setFinalista(Boolean finalista) {
        this.finalista = finalista;
    }

    /**
     * @return the dinero
     */
    public Integer getDinero() {
        return dinero;
    }
    
     /**
     * @param dinero the dinero to set
     */
    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

   //------------------------------------clase250219
    /**
    public AnimacionParticipanteEntity toEntity()
    {
        AnimacionParticipanteEntity ape = new AnimacionParticipanteEntity() ;
        ape.setPuntaje(this.puntaje);
        ape.setPuesto(this.puesto);
        ape.setFinalista(this.finalista);
        ape.setDinero(this.dinero);
        
        return ape;
    }
    
      //------------------------------------clase250219
    public AnimacionParticipanteDTO toDTO()
    {
        AnimacionParticipanteDTO apDTO = new AnimacionParticipanteDTO() ;
        apDTO.setPuntaje(this.puntaje);
        apDTO.setPuesto(this.puesto);
        apDTO.setFinalista(this.finalista);
        apDTO.setDinero(this.dinero);
        
        return apDTO;
    }
     */
    
  

    
    
}
