/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author estudiante
 */
public class VotacionEntity extends BaseEntity implements Serializable{
    
    private Long id;
    private Integer idAnimacion;
    private Double puntos;
    private Integer numRonda;
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RondaEntity ronda;
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private JuradoEntity jurado;

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
     * @return the numRonda
     */
    public Integer getNumRonda() {
        return numRonda;
    }

    /**
     * @param numRonda the numRonda to set
     */
    public void setNumRonda(Integer numRonda) {
        this.numRonda = numRonda;
    }

    /**
     * @return the ronda
     */
    public RondaEntity getRonda() {
        return ronda;
    }

    /**
     * @param ronda the ronda to set
     */
    public void setRonda(RondaEntity ronda) {
        this.ronda = ronda;
    }

    /**
     * @return the jurado
     */
    public JuradoEntity getJurado() {
        return jurado;
    }

    /**
     * @param jurado the jurado to set
     */
    public void setJurado(JuradoEntity jurado) {
        this.jurado = jurado;
    }
    
    
    
    
}
