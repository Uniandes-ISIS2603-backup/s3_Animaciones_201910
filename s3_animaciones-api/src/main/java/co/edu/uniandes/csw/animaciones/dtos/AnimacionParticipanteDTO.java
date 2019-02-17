/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import java.util.List;
import co.edu.uniandes.csw.animaciones.dtos.AnimacionConcursoDTO;
/**
 *
 * @author by.cuta10
 */
public class AnimacionParticipanteDTO extends AnimacionConcursoDTO implements Serializable
{
    //
    // ATRIBUTOS
    //
  
    Integer dinero;
    
    //
    //CONSTRUCTOR
    //
    
    /**
     * constructor
     */
    public AnimacionParticipanteDTO(){
        
    }
    
    //
    //METODOS
    //
   
    /**
     * @return the dinero
     */
    public Integer getDinero(){
        return dinero;
    }
   
    
   
   /**
     * @param dinero the dinero to set
     */
    public void setGanadores(Integer dinero)
    {
        this.dinero = dinero;
    }
    

    
    
}
