/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import java.io.Serializable;

/**
 *
 * @author df.perezc
 */
public class ConcursoDTO implements Serializable {

    //
    //ENUMERACION
    //
    public enum Tecnica {
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
    private String tecnica;
    private String tema;
    private Long organizador;
    private Long id;
    private String reglas;

    //
    //CONSTRUCTOR
    //
    public ConcursoDTO() {

    }


    public ConcursoDTO(ConcursoEntity ce) {
        this.tecnica = ce.getTecnica();
        this.tema = ce.getTema();
        this.organizador = ce.getOrganizador();
        this.id = ce.getId();
        this.reglas = ce.getReglas();
    }

    //
    //METODOS
    //
    public ConcursoEntity toEntity() {
        ConcursoEntity ce = new ConcursoEntity();
        ce.setTecnica(this.tecnica);
        ce.setTema(this.tema);
        ce.setOrganizador(this.organizador);
        ce.setId(this.id);
        ce.setReglas(this.reglas);
        return ce;
    }

    /**
     * @return the tecnica
     */
    public String getTecnica() {
        return tecnica;
    }

    /**
     * @param tecnica the tecnica to set
     */
    public void setTecnica(String tecnica) {
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
    public Long getOrganizador() {
        return organizador;
    }

    /**
     * @param organizador the organizador to set
     */
    public void setOrganizador(Long organizador) {
        this.organizador = organizador;
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
