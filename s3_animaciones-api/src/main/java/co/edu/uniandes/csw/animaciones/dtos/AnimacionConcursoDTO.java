/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import co.edu.uniandes.csw.animaciones.dtos;
/**
 *
 * @author df.perezc
 */
public class AnimacionConcursoDTO extends AnimacionDTO implements Serializable{
    
    
    //
    // ATRIBUTOS
    //
    Double puntaje;
    Integer puesto;
    Boolean finalista;
    Integer id;
    
    //
    //CONSTRUCTOR
    //
    
    /**
     * constructor
     */
    public AnimacionConcursoDTO(){
        
    }
    
    //
    //METODOS
    //
   
    /**
     * @return the puntaje
     */
    public Double getPuntaje(){
        return puntaje;
    }
   
    /**
     * @return the puesto
     */
    public Integer getPuesto(){ 
        return puesto;
    }
   
    /**
     * @return the finalista
     */
    public Boolean getFinalista(){
        return finalista;
    }
    /**
     * @return the finalista
     */
    public Integer getId(){
        return id;
    }    
 
    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(Double puntaje)
    {
        this.puntaje = puntaje;
    }
     /**
     * @param puesto the puesto to set
     */
    public void setPuesto(Integer puesto)
    {
        this.puesto = puesto;
    }
     /**
     * @param finalista the finalistato set
     */
    public void setFinalista(Boolean finalista)
    {   
        this.finalista = finalista;
    }
     /**
     * @param id the finalistato set
     */
    public void setId(Integer id)
    {   
        this.id = id;
    }
}
