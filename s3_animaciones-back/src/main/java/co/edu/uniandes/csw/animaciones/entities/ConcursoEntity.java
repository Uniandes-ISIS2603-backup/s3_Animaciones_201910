/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * clase que maneja la entidad del concurso
 * @author df.perezc
 */
@Entity
public class ConcursoEntity extends BaseEntity implements Serializable {

    //----------------------------------------------------------
    //RELACIONES
    //----------------------------------------------------------
  
    @PodamExclude
    @OneToMany(mappedBy = "concurso", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<JuradoEntity> jurados;
    
    @PodamExclude
    @OneToMany(mappedBy = "concurso", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<RondaEntity> rondas = new ArrayList<>();
    
     //----------------------------------------------------------
    
    /**
     * atributo que guarda el tema del concurso
     */
    private String tema;
    
    /**
     * atributo que guarda la tecnica del concurso
     */
    private String tecnica;
    
    /** 
     * atributo que guarda la id del organizador
     */
    private Long organizador;
    
    /**
     * atributo que guarda las reglas del concurso
     */
    private String reglas;
    

    /**
     * metodo que crea una entidad de concurso vacia
     */
    public ConcursoEntity() {

    }

    /**
     * metodo que retorna la lista de jurados del concurso
     * @return the juradosa es la lista de jurados del concurso
     */
    public ArrayList<JuradoEntity> getJurados() {
       return jurados;
    }

    /**
     * metodo que modifica la lista de jurados del concurso
     * @param juradosa the jurados to set
     */
    public void setJurados(ArrayList<JuradoEntity> jurados) {
        this.jurados = jurados;
    }

    /**
     * metodo que retorna una lista las entidades de rondas del concurso
     * @return the rondas lista de las entidades de rondas del concurso
     */
    public ArrayList<RondaEntity> getRondas() {
        return rondas;
    }

    /**
     * metodo que modifica las rondas de la entidad del concurso
     * @param rondas the rondas to set
     */
    public void setRondas(ArrayList<RondaEntity> rondas) {
       this.rondas = rondas;
    }

    /**
     * metodo que retorna el tema de la entidad del concurso
     * @return the tema es la cadena de caracteres del tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * metodo que modifica el tema de la entidad del concurso
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * metodo que retrona la tecnica de la entidad del concurso
     * @return the tecnica
     */
    public String getTecnica() {
        return tecnica;
    }

    /**
     * metodo que modifica la tecnica de la entidad del concurso
     * @param tecnica the tecnica to set
     */
    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    /**
     * metodo que obtiene la id del organizador del concurso
     * @return the organizador es la id del organizador
     */
    public Long getOrganizador() {
        return organizador;
    }

    /**
     * metodo que modifica el organizador del concurso
     * @param organizador the organizador to set
     */
    public void setOrganizador(Long organizador) {
        this.organizador = organizador;
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
