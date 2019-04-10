/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import java.io.Serializable;

/**
 *clase que maneja la informacion de un concurso 
 * @author df.perezc
 */
public class ConcursoDTO implements Serializable {

    //
    //ENUMERACIONS
    //
    /**
     * enumeracion que contiene los posibles valores (tecnicas) del atributo tecnica
     */
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
    
    /**
     * atributo que guarda la informacion de la tecnica de animacion que pide el concurso
     */
    private String tecnica;
    
    /**
    * atributo que guarda la tematica del concurso propuesta por el organizador del mismo
    */
    private String tema;
    
    /**
     * atributo que guarda la id del organizador
     */
    private Long organizador;
    
    /**
     * atributo que guarda la id del concurso
     */
    private Long id;
    
    /**
     * atributo que guarda las reglas del concurso
     */
    private String reglas;

    //
    //CONSTRUCTOR
    //
    
    /**
     * medoto que crea un concurso vacio 
    */
    public ConcursoDTO() {

    }

   /**
    * metodo que recibe una entidad concurso y a partir de ella crea un objeto concurso
    * @param ce 
    */
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
    /**
     * metodo que traduce este concurso en una entidad
     * @return la entidad correspondiente a este concurso
     */
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
     * metodo que retorna la tecnica que exige el concurso
     * @return the tecnica 
     */
    public String getTecnica() {
        return tecnica;
    }

    /**
     * metodo que cambia la tecnica exigida por el concurso
     * @param tecnica the tecnica to set
     */
    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    /**
     * metodo que retorna la tematica del concurso propuesta por el organizador
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * metodo que modifica la tematica del concurso 
     * @param tema el tema a asignar
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * metodo que retorna la id del organizador
     * @return the organizador
     */
    public Long getOrganizador() {
        return organizador;
    }

    /**
     * metodo que modifica la id del organizador 
     * @param organizador the organizador to set
     */
    public void setOrganizador(Long organizador) {
        this.organizador = organizador;
    }

    /**
     * metodo que devuelve la id del concurso
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * metodo que modifica la id del concurso
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * metodo que retorna las reglas del concurso
     * @return the reglas
     */
    public String getReglas() {
        return reglas;
    }

    /**
     * metodo que modifica las reglas del concurso
     * @param reglas the reglas to set
     */
    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

}
