/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

/**
 *
 * @author df.perezc
 */
public class AnimacionGanadoraDTO extends AnimacionConcursoDTO implements Serializable
{
    //
    // ATRIBUTOS
    //
  
    Integer dinero;
    Integer id;
    
    //
    //CONSTRUCTOR
    //
    
    /**
     * constructor
     */
    public AnimacionGanadoraDTO(){
        
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
     * @return the id
     */
   public List getId(){ 
       return id;
   }
   
   /**
     * @param dinero the dinero to set
     */
    public void setGanadores(Integer dinero)
    {
        this.dinero = dinero;
    }
    
     /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {   
        this.id = id;
    }
    
    
}
