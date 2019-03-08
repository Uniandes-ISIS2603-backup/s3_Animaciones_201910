/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author df.perezc
 */
@Entity
public class ConcursoEntity extends BaseEntity implements Serializable {

    private String tema;
    private String tecnica;
    private Long organizador;
    private String reglas;

    public ConcursoEntity() {

    }

    /*

    @PodamExclude
    @OneToMany(mappedBy = "concurso", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<JuradoEntity> juradosa;
     */

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
