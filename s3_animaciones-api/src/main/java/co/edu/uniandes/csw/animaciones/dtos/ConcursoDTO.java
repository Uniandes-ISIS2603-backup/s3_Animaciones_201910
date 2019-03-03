/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;

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
    private Tecnica tecnica;
    private String tema;
    private Integer organizador ;
    private Integer id;
    private String reglas;
    
    //
    //CONSTRUCTOR
    //
    
    public ConcursoDTO(){
        
    }
    
    //
    //METODOS
    //

    /**
     * @return the tecnica
     */
    public Tecnica getTecnica() {
        return tecnica;
    }

    /**
     * @param tecnica the tecnica to set
     */
    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the organizador
     */
    public Integer getOrganizador() {
        return organizador;
    }

    /**
     * @param organizador the organizador to set
     */
    public void setOrganizador(Integer organizador) {
        this.organizador = organizador;
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
     * @return the reglas
     */
    public String getReglas() {
        return reglas;
    }

    /**
     * @param reglas the reglas to set
     */
    public void setReglas(String reglas) {
        this.reglas = reglas;
    }
    
    

}
