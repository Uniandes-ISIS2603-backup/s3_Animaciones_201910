/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class VotacionDTO implements Serializable{
    private int id;
    private int idAnimacion;
    private int puntos;
    private int ronda;
    
    public VotacionDTO(){
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idAnimacion
     */
    public int getIdAnimacion() {
        return idAnimacion;
    }

    /**
     * @param idAnimacion the idAnimacion to set
     */
    public void setIdAnimacion(int idAnimacion) {
        this.idAnimacion = idAnimacion;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the ronda
     */
    public int getRonda() {
        return ronda;
    }

    /**
     * @param ronda the ronda to set
     */
    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
}
