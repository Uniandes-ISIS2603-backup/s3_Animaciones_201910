/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author df.serrano
 */
public class RondaDTO implements Serializable{
    
    private Long id;
    private Integer numero;
    private Date fechaInicio;
    private Date fechaFin;
    
    public RondaDTO(){
        
    }
    public RondaDTO(RondaEntity re){
        setId(re.getId());
        setFechaInicio(re.getFechaInicio());
        setFechaFin(re.getFechaFin());
        setNumero(re.getNumero());
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
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }
    
    public RondaEntity toEntity()
    {
        RondaEntity re = new RondaEntity();
        re.setId(this.id);
        re.setFechaInicio(this.fechaInicio);
        re.setFechaFin(this.fechaFin);
        re.setNumero(this.getNumero());
        return re;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
