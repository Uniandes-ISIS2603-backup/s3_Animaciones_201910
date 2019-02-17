/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;

/**
 *
 * @author df.serrano
 */
public class VotacionDTO implements Serializable{
    private Integer id;
    private Integer idAnimacion;
    private Integer puntos;
    private Integer ronda;
    
    public VotacionDTO(){
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(Integer puntos) {
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
