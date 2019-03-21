/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author by.cuta10
 */
@Entity
public class JuradoEntity extends BaseEntity implements Serializable{
    
    /**
     * Atributo que contiene la credencial del usuario
     */
    private String credencial;
    /**
     * Atributo que contiene el nombre del usuario
     */
    private String usuario;
    /**
     * Atributo que contiene la contrasena del usuario
     */
    private String contrasena;
    

    /**
     * Relacion many to one a la clase concurso
     */
    @PodamExclude
    @ManyToOne (cascade = CascadeType.PERSIST)
    private ConcursoEntity concurso;
    
    /**
     * Metodo contructor vacio de la clase JuradoEntity
     */
    public JuradoEntity (){
        
    }
    
    /**
     * Relacion OneToManu con votaciones que se guardan en una lista
     */
    @PodamExclude
    @OneToMany (mappedBy = "jurado" )
    private List<VotacionEntity> votaciones;
    
    /**
     * Cambia la credencia del jurado por la que entra de parametro
     * @param credencial 
     */
    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
    
    /**
     * Camabia el usuario del Jurado por el String que entra como parametro
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Cambia la contrasena del Jurado por la que entra como parametro
     * @param contraseña 
     */
    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }
    /**
     * Da la credencial del jurado
     * @return credencial
     */
    public String getCredencial() {
        return credencial;
    }
    /**
     * Retorna el usuario de Jurado
     * @return  usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Retorna la contrasena del jurado
     * @return contrasena
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Retorna las votaciones del jurado
     * @return  votaciones
     */
    public List getVotaciones()
    {
        return votaciones;
    }
    /**
     * Cambia las votaciones por las que entran por parametro
     * @param votaciones 
     */
    public void setVotaciones(List votaciones){
        
        this.votaciones = votaciones;
    }
    
    
   
}
