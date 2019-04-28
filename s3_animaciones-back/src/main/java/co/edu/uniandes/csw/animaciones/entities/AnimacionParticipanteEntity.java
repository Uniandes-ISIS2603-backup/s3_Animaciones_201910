/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 * clase que maneja la entidad Animacion participante
 * @author df.perezc
 */
@Entity
@DiscriminatorValue("P")
public class AnimacionParticipanteEntity extends AnimacionEntity implements Serializable {
    
    //relacion con la ronda
    @PodamExclude
    @ManyToOne()
    private RondaEntity ronda;
    /**
     * atributo que guarda el puntaje, otorgado por los jueces, de la entidad de la animacionParticipante
     */
    private Double puntaje;
    
    /**
     * atributo que guarda el puesto de la entidad de la animacion participante en el concuso
     */
    private Integer puesto;
    
    /**
     * atributo que indica si la entidad de la animacion participante pasa a segunda ronda
     */
    private Boolean finalista;
    
    /**
     * atributo que guarda cuantó dinero gano la animacionParicipante correspondiente a la entidad
     */
    private Integer dinero;

    public AnimacionParticipanteEntity(){
        
    }


    /**
     * metodo que retorna el puntaje de la animacion participante correspondiente a la entidad
     * @return the puntaje asignado por los jurados
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * metodo que modifica el puntaje de la animacion participante correspondiente a la entidad
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * metodo que retorna el pueso de la animacion participante correspondiente a la entidad
     * @return the puesto obtenido por la animacion 
     */
    public Integer getPuesto() {
        return puesto;
    }

    /**
     * metodo que modifica el puesto de la animacion participante correspondiente a la entidad
     * @param puesto the puesto to set
     */
    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    /**
     * metodo que retorna true si la entidad corresponde a una animacion que clasifica a segunda ronda
     * @return the finalista
     */
    public Boolean getFinalista() {
        return finalista;
    }

    /**
     * metodo que modifica si la animacion participante correspondiente a la entidad clasifica a segunda ronda
     * @param finalista the finalista to set
     */
    public void setFinalista(Boolean finalista) {
        this.finalista = finalista;
    }

    /**
     * metodo que retorna el dinero obtenido como premio por la animacion participante correspondiente a la entidad
     * @return the dinero
     */
    public Integer getDinero() {
        return dinero;
    }

    /**
     * metodo que modifica el dinero obtenido como premio por la animacion participante correspondiente a la entidad
     * @param dinero the dinero to set
     */
    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }
    
    public RondaEntity getRonda(){
        return ronda;
    }
    
    public  void setRonda(RondaEntity re){
        this.ronda = re;
    }
}
