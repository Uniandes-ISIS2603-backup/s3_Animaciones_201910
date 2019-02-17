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
 * @author by.cuta10   
 */
@Entity
public class AnimacionGanadoraEntity extends BaseEntity implements Serializable{
    
     //
    // ATRIBUTOS
    //
  
    Integer dinero;

    
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
