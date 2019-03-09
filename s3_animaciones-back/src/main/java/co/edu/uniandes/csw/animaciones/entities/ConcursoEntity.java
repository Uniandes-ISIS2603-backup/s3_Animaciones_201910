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
 *
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
     /** al descomentar esto descomentar tambien los seters y geters
    @PodamExclude
    @OneToMany(mappedBy = "concurso", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<RondaEntity> rondas;
    */
    
     //----------------------------------------------------------
    
    
    private String tema;
    private String tecnica;
    private Long organizador;
    private String reglas;
    

    public ConcursoEntity() {

    }
    
       public void nohacernada() {
        tema = tema;
    }
    

    /**
     * @return the juradosa
     */
    public ArrayList<JuradoEntity> getJurados() {
       // return jurados;
        return new ArrayList();
    }

    /**
     * @param juradosa the juradosa to set
     */
    public void setJurados(ArrayList<JuradoEntity> juradosa) {
        //this.jurados = juradosa;
    }

    /**
     * @return the rondas
     */
    public ArrayList<RondaEntity> getRondas() {
        //return rondas;
         return new ArrayList();
    }

    /**
     * @param rondas the rondas to set
     */
    public void setRondas(ArrayList<RondaEntity> rondas) {
       //this.rondas = rondas;
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
