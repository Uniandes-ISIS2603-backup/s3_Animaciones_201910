/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import java.util.Date;
import co.edu.uniandes.csw.animaciones.dtos;

/**
 *
 * @author df.perezc
 */
public class ConcursoDTO implements Serializable
{
    

    //
    //ENUMERACION
    //
    public enum Tecnica
    {
        ANIMACION_COMPLETA, 
        ANIMACION_LIMITADA,
        ROTOSCOPIA,
        LIVE_ACTION,
        CLAY_MOTION,
        PIXILACION,
        GO_MOTION,
        ANIMACION_DE_RECORTES,
        ANIMACION_FLASH,
        CAPTURA_DE_MOVIMIENTO,
        MODELADO_3D_POR_ORDENADOR,
        ANIMACION_CON_ARENA,
        PINSCREEN
    }
    
    //
    // ATRIBUTOS
    //
    Date fechaInicio;
    Date fechaFin;
    Tecnica tecnica;
    String tema;
    String organizador ;
    Integer id;
    
    //
    //CONSTRUCTOR
    //
    
    public ConcursoDTO(){
        
    }
    
    //
    //METODOS
    //
    
    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio(){
        return fechaInicio;
    } 
    /**
     * @return the fechaFin
     */
    public Date getFechaFin(){
        return fechaFin;
    } 
    /**
     * @return the tema
     */
    public String getTema(){
        return tema;
    }
     /**
     * @return the tecnica
     */
    public Tecnica getTecnica(){
        return tecnica;
    } 
    /**
     * @return the corganizador
     */
    public String getOrganizador(){
        return organizador;
    } 
   
    /**
     * @return the id
     */
    public Integer getId(){
        return id;
    }
    

    
    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema)
    {
        this.tema = tema;
    }

    /**
     * @param tecnica the tecnica to set
     */
    public void setTecnica(Tecnica tecnica)
    {
        this.tecnica = tecnica;
    }

    /**
     * @param organizador the organizador to set
     */
    public void setOrganizador(String organizador )
    {
        this.organizador = organizador;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

}
