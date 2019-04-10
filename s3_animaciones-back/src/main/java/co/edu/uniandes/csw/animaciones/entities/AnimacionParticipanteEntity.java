/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 *
 * @author df.perezc
 */
@Entity
@DiscriminatorValue("P")
public class AnimacionParticipanteEntity extends AnimacionEntity implements Serializable {
    
    private Double puntaje;
    private Integer puesto;
    private Boolean finalista;
    private Integer dinero;

    public AnimacionParticipanteEntity(){
        
    }


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
}
