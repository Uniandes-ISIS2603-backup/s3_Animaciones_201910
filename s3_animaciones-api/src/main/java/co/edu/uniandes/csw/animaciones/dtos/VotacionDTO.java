/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import java.io.Serializable;

/**
 *
 * @author df.serrano
 */
public class VotacionDTO implements Serializable{
    private Long id;
    private Integer idAnimacion;
    private Double puntos;
    private Integer ronda;
    
    public VotacionDTO(){
        
    }
    public VotacionDTO(VotacionEntity ve){
        if(ve!=null)
        {
            
         setId(ve.getId());
        setIdAnimacion(ve.getIdAnimacion());
        setPuntos(ve.getPuntos());
        setRonda(ve.getNumRonda());
        }
    }
    public VotacionEntity toEntity(){
        VotacionEntity ve = new VotacionEntity();
        ve.setId(this.id);
        ve.setIdAnimacion(this.idAnimacion);
        ve.setPuntos(this.puntos);
        ve.setNumRonda(this.ronda);
        return ve;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the idAnimacion
     */
    public Integer getIdAnimacion() {
        return idAnimacion;
    }

    /**
     * @param idAnimacion the idAnimacion to set
     */
    public void setIdAnimacion(Integer idAnimacion) {
        this.idAnimacion = idAnimacion;
    }

    /**
     * @return the puntos
     */
    public Double getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the ronda
     */
    public Integer getRonda() {
        return ronda;
    }

    /**
     * @param ronda the ronda to set
     */
    public void setRonda(Integer ronda) {
        this.ronda = ronda;
    }

    
}
